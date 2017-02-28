/**
 * This class represents an Orange fruit object
 * @author Abin
 *
 */
public class Orange extends Item {

	//defining the price of an orange
	private final static double ORANGEPRICE = 0.25;	//25p
	
	//Constructor
	public Orange(int quantity) 
	{
		super("Orange",ORANGEPRICE, quantity);
	}

}
