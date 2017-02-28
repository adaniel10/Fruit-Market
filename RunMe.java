/**
 * This is the main class which starts and runs the main program.
 * @author Abin Daniel
 *
 */
public class RunMe {
	
	public static void main(String[] args) 
	{
		Checkout chk = new Checkout();	//creating checkout object
		chk.displayWelcomeMsg();
		chk.startup();	//running the startup
	}
}
