import java.util.Scanner;

/**
 * This is the Checkout class which processes all the items by creating its
 * necessary objects and calculating the total prices of those items and printing
 * to the user.
 * @author Abin
 *
 */
public class Checkout {
	
	/**Instance Variables**/
	private int userSetQuantity;
	private Scanner in;
	private double total;
	
	//Constructor
	public Checkout()
	{
		userSetQuantity = 0;
		total = 0.0;
		in = new Scanner(System.in);
	}
	
	/**
	 * Displays welcome message.
	 */
	public void displayWelcomeMsg()
	{
		System.out.println("******************************");
		System.out.println("Welcome To The Fruit Market!!!");
		System.out.println("******************************");
	}
	
	/**
	 * This method is used to display the welcome message to the user and then
	 * allow the user to select which type of fruit they want to purchase.
	 */
	public void startup()
	{	
		String fruit = "";
		for(;;)
		{
			System.out.print("\nPlease Enter 'o' to Purchase an Orange or 'a' to Purchase an Apple: ");
			
			String fruitLetter = trimString(in.nextLine());
			
			if(fruitLetter.equalsIgnoreCase("o"))
			{
				fruit = "Orange";
				break;
			}
			else if(fruitLetter.equalsIgnoreCase("a"))
			{
				fruit = "Apple";
				break;
			}
			else
				System.out.println("You have entered an invalid letter.");
		}
		
		System.out.println("You have selected: "+fruit);	//prints the selected fruit
		
		System.out.print("\nPlease enter how many "+fruit+"'s would you like to buy: ");
		performQuantityCheck();
		
		//this loop will repeat itself until the 'userSetQuantity' variable is greater
		//...than 0.
//		do
//		{
//			userSetQuantity = checkQuantityFormat(in.nextLine());
//		}
//		while(userSetQuantity <= 0);
		
		System.out.println("You have selected to purchase "+userSetQuantity+" "+fruit+"(s).");
		accumulateTotalPrice(fruit);
		
		System.out.print("\nEnter 'y' To Purchase More Items or 'n' To Proceed To Checkout: ");
		String reply = in.nextLine();
		buyMoreItems(reply);
	}
	
	/**
	 * This method takes the user input quantity and checks whether its a valid
	 * number by calling checkUserQuantity method and throwing an error if an invalid 
	 * number is found.
	 */
	public void performQuantityCheck()
	{
		userSetQuantity = checkQuantityFormat(in.nextLine());
		checkUserQuantity(userSetQuantity);
	}
	
	/**
	 * If the input number is less than or equal to zero then it will ask the user
	 * to try and enter a valid number. 
	 * @param u int
	 */
	public void checkUserQuantity(int u)
	{
		if(u <= 0)
		{
			System.out.print("\nPlease enter a valid number: ");
			performQuantityCheck();
		}
	}
	
	/**
	 * This method calculates the total price for all the items purchased.
	 */
	public void accumulateTotalPrice(String f)
	{	
		if(f.equalsIgnoreCase("Orange"))
		{
			Orange o = new Orange(userSetQuantity);
			total += calculatePrice(o,userSetQuantity);
		}
		else if(f.equalsIgnoreCase("Apple"))
		{
			Apple a = new Apple(userSetQuantity);
			total += calculatePrice(a,userSetQuantity);
		}
	}
	
	/**
	 * Print the total price to the user by printing the value of the 'total'
	 * variable.
	 */
	public void printTotalPrice()
	{
		System.out.println("\nProceeding to Checkout...");
		System.out.println("Total Price: £"+String.format("%.2f",total));
	}
	
	/**
	 * Checks the response of the user whether they wish to continue purchasing
	 * more items or if they would like to continue to checkout.
	 * @param r String
	 */
	public void buyMoreItems(String r)
	{
		if(r.equalsIgnoreCase("Y"))
		{
			startup();
		}
		else if(r.equalsIgnoreCase("N"))
		{
			printTotalPrice();
		}
		else
		{
			System.out.println("You have entered an invalid letter!");
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Takes the input string and converts it to a number.
	 * If the input is not a number then throw an error and asking the user
	 * to enter a valid quantity.
	 * @param checkQ String
	 * @return int
	 */
	public int checkQuantityFormat(String checkQ)
	{
		int conv = 0;
		
		try {
			conv = Integer.parseInt(checkQ);
		}
		catch(NumberFormatException e) { 
			System.out.print("Unknown quantity detected!!!\n");
		}
		return conv;
	}
	
	/**
	 * Calculates the total amount by multiplying the quantity with
	 * the price of a fruit. This total number is also rounded of to 2 
	 * decimal places.
	 * @param c Item
	 * @param quant int
	 * @return double
	 */
	public double calculatePrice(Item c, int quant)
	{
		double amount = c.getPrice() * quant;	//price x quantity
		return (double) Math.round(amount * 100) / 100;
	}
	
	/**
	 * Trims the input string by cutting any leading spaces.
	 * @param word String
	 * @return String
	 */
	public String trimString(String word) {
		return word.trim();
	}
	
	/**Accessor Method**/
	public int getUserSetQuantity() { return this.userSetQuantity; }
	
	/**Mutator Method**/
	public void setUserQuantity(int uq) { this.userSetQuantity = uq; } 

}
