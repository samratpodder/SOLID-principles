# Invoice Class Example to demonstrate open-close principle
Client wants invoices to be saved to a database so that we can search them easily

We can easily modify the InvoicePersistence Class to add the functionality

```java
public class InvoicePersistence {
    Invoice invoice;

    public InvoicePersistence(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }

    public void saveToDatabase() {
        // Saves the invoice to database
    }
}
```

The Above Code disobeys the open-close principle because we are modifying the InvoicePersistence class to add the functionality

We refactor the above code to obey the open-close principle.
We change the type of InvoicePersistence to Interface and add a save method. Each persistence class will implement this save method

```java
interface InvoicePersistence {

    public void save(Invoice invoice);
}

public class DatabasePersistence implements InvoicePersistence {

    @Override
    public void save(Invoice invoice) {
        // Save to DB
    }
}

public class FilePersistence implements InvoicePersistence {

    @Override
    public void save(Invoice invoice) {
        // Save to file
    }
}
```

Class Structure:
![Class Structure](https://erinc.io/wp-content/uploads/2020/08/SOLID-Tutorial-1-1024x554.jpeg)

We may think that we could just create multiple classes without an interface and add a save method to all of them.

But let's say that we extend our app and have multiple persistence classes like InvoicePersistence, BookPersistence and we create a PersistenceManager class that manages all persistence classes:

```java
public class PersistenceManager {
    InvoicePersistence invoicePersistence;
    BookPersistence bookPersistence;
    
    public PersistenceManager(InvoicePersistence invoicePersistence,
                              BookPersistence bookPersistence) {
        this.invoicePersistence = invoicePersistence;
        this.bookPersistence = bookPersistence;
    }
}
```
We can now pass any class that implements the InvoicePersistence interface to this class with the help of polymorphism. This is the flexibility that interfaces provide.