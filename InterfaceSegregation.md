# Describing Interface Segregation with Parking Lot Problem

Let us implement a very simplified parking lot. It is the type of parking lot where you pay an hourly fee. Our parking lot interface is  composed of 2 things: Parking related logic (park car, unpark car, get capacity) and payment related logic.
```java
public interface ParkingLot {

	void parkCar();	// Decrease empty spot count by 1
	void unparkCar(); // Increase empty spots by 1
	void getCapacity();	// Returns car capacity
	double calculateFee(Car car); // Returns the price based on number of hours
	void doPayment(Car car);
}

class Car {

}
```

Now consider that we want to implement a parking lot that is free.
```java
public class FreeParking implements ParkingLot {

	@Override
	public void parkCar() {
		
	}

	@Override
	public void unparkCar() {

	}

	@Override
	public void getCapacity() {

	}

	@Override
	public double calculateFee(Car car) {
		return 0;
	}

	@Override
	public void doPayment(Car car) {
		throw new Exception("Parking lot is free");
	}
}
```

It is too specific. Because of that, our FreeParking class was forced to implement payment-related methods that are irrelevant. Let's separate or segregate the interfaces.

After Segregation, our class design is:
![](https://erinc.io/wp-content/uploads/2020/08/SOLID-Tutorial-1024x432.png)

We've now separated the parking lot. With this new model, we can even go further and split the PaidParkingLot to support different types of payment.

Now our model is much more flexible, extendable, and the clients do not need to implement any irrelevant logic because we provide only parking-related functionality in the parking lot interface.