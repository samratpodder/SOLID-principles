package SOLID;

//class Invoice {
//
//	private Book book;
//	private int quantity;
//	private double discountRate;
//	private double taxRate;
//	private double total;
//
//	public Invoice(Book book, int quantity, double discountRate, double taxRate) {
//		this.book = book;
//		this.quantity = quantity;
//		this.discountRate = discountRate;
//		this.taxRate = taxRate;
//		this.total = this.calculateTotal();
//	}
//
//	public double calculateTotal() {
//	        double price = ((book.price - book.price * discountRate) * this.quantity);
//
//		double priceWithTaxes = price * (1 + taxRate);
//
//		return priceWithTaxes;
//	}
//}
class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        System.out.println(invoice.quantity + "x " + invoice.book.name + " " + invoice.book.price + " $");
        System.out.println("Discount Rate: " + invoice.discountRate);
        System.out.println("Tax Rate: " + invoice.taxRate);
        System.out.println("Total: " + invoice.total + " $");
    }
}
class InvoicePersistence {
    Invoice invoice;

    public InvoicePersistence(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}