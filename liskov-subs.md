# Square and Rectangle Example
Let Rectanlge be a class that has a width and height attribute. Square is a subclass of Rectangle.
```java
class Rectangle {
	protected int width, height;

	public Rectangle() {
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}
}
```
```java
class Square extends Rectangle {
	public Square() {}

	public Square(int size) {
		width = height = size;
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
}
```
Our Square class extends the Rectangle class. We set height and width to the same value in the constructor, but we do not want any client (someone who uses our class in their code) to change height or weight in a way that can violate the square property.

Therefore we override the setters to set both properties whenever one of them is changed. But by doing that we have just violated the Liskov substitution principle.

```java
class Test {

   static void getAreaTest(Rectangle r) {
      int width = r.getWidth();
      r.setHeight(10);
      System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
   }

   public static void main(String[] args) {
      Rectangle rc = new Rectangle(2, 3);
      getAreaTest(rc);

      Rectangle sq = new Square();
      sq.setWidth(5);
      getAreaTest(sq);
   }
}
```
```
Expected area of 20, got 20
Expected area of 50, got 100
```

In the first test, we create a rectangle where the width is 2 and the height is 3 and call getAreaTest. The output is 20 as expected, but things go wrong when we pass in the square. This is because the call to setHeight function in the test is setting the width as well and results in an unexpected output.

It was inappropriate to make square a subclass of rectangle though in natural language we say that square is a special kind of rectangle having the same width and height. In everyday world we say many similar kind of things while modeling them we must pay special attention to its behaviours. A real duck and a battery operated duck make similar sounds but their behaviours are different from one another.