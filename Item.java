/**
 * This is an abstract class which indicates what types of fields a fruit
 * should have. To use this class, classes must extend this class.
 * @author Abin
 *
 */
public abstract class Item {
	
	/**Instance Variables**/
	private String name;
	private double price;
	private int quantity;
	
	//Constructor
	public Item(String name, double price, int quantity)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**Mutator Methods**/
	public void setName(String n) { this.name = n; }
	public void setPrice(double price) { this.price = price; }
	public void setQuantity(int q) { this.quantity = q; }
	
	/**Accessor Methods**/
	public String getName()  { return this.name; }
	public double getPrice() { return this.price; }
	public int getQuantity() { return this.quantity; }

}
