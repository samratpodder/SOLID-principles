# Illustrate Decoupling of classes with Dependency Inversion
We can use Dependency Inversion to decouple classes from each other. Suppose we have a class for WindowsXP and is declared as follows:
```java
public class WindowsXPMachine {

    private final StandardKeyboard keyboard;
    private final Monitor monitor;

    public WindowsXPMachine() {
        monitor = new Monitor();
        keyboard = new StandardKeyboard();
    }

}
```

Here the class WindowsXPMachine is tightly coupled with the classes StandardKeyboard and Monitor. We've lost the ability to switch out our StandardKeyboard class with a different one should the need arise. And we're stuck with our Monitor class too.

Instead, we can use a Keyboard and a Monitor Interface to be used in our WindowsXP. In this way, we can not only use a standardkeyboard but all sorts of different keyboards. 
```java
public interface Keyboard { }
```
```java
public interface Monitor { }
```
We can re-define our StandardKeyboard class as follows:
```java
public class StandardKeyboard implements Keyboard { }
```
And our Monitor class as follows:
```java
public class Monitor implements Monitor { }
```
And Finally

```java
public class WindowsXPMachine{

    private final Keyboard keyboard;
    private final Monitor monitor;

    public WindowsXPMachine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
```
Now our classes are decoupled and communicate through the Keyboard abstraction. If we want, we can easily switch out the type of keyboard in our machine with a different implementation of the interface. We can follow the same principle for the Monitor class.

Excellent! We've decoupled the dependencies and are free to test our WindowsXPMachine with whichever testing framework we choose.