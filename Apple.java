/**
 * This class represents an Apple fruit object.
 * @author Abin
 *
 */
public class Apple extends Item {

	//defining the price of an apple
	private final static double APPLEPRICE = 0.6;	//60p
		
	//Constructor
	public Apple(int quantity) 
	{
		super("Apple",APPLEPRICE, quantity);
	}

}