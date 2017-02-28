import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

	Checkout chk = new Checkout(); // Checkout class is tested
	
	Orange o1 = new Orange(0);
	Orange o2 = new Orange(0);
	Orange o3 = new Orange(3);
	
	Apple a1 = new Apple(0);
	Apple a2 = new Apple(2);
	Apple a3 = new Apple(3);
	
	@Test
	public void testAssertions()
	{
		//checks price if same for 2 fruit objects
		assertEquals(o1.getQuantity(),o2.getQuantity());
		assertEquals(o3.getQuantity(),a3.getQuantity());
		
		//checks that 2 objects of Orange are not the same
		assertNotSame(o1,o2);
		
		//checks that the objects are not null
		assertNotNull(o1);
		assertNotNull(a2);
	}
	
	//test to check price with different values
	@Test
	public void checkPrice()
	{
		o3.setQuantity(0);
		double price = chk.calculatePrice(o3, o3.getQuantity());
		assertEquals("0.25 x 0 should be 0", 0, price, 0);
		
		o3.setQuantity(5);
		double price1 = chk.calculatePrice(o3, o3.getQuantity());
		assertEquals("0.25 x 5 should be 1.25", 1.25, price1, 0);
	}
	
	//checks trim string
	@Test
	public void checkTrimString()
	{
		String str1 = "abc";
		String str2 = " abc";
		
		assertEquals("abc",str1);
		assertNotEquals("abc",str2);
		
		String result = chk.trimString(str2);
		assertEquals("abc",result);
	}
	
	//tests if the checkQuantityFormat method will return 0
	//..if a string is provided as an input.
	@Test
	public void testQuantityFormat()
	{
		String s1 = "text";
		assertEquals(0,chk.checkQuantityFormat(s1));
	}
	
	//Checks if the input to the QuantityFormat method is valid.
	@Test
	public void testCorrectQuantityFormatInput()
	{
		String s1 = "23";
		String s2 = "-4";
		
		int result = chk.checkQuantityFormat(s1);
		assertTrue(result > 0);
		
		int result2 = chk.checkQuantityFormat(s2);
		assertTrue(result2 <= 0);
	}
	
	//expected to throw an error if the user does not enter
	//...the stated letters
	@Test (expected = IllegalArgumentException.class)
	public void testBuyMoreItems()
	{
		String maybe = "m";
		chk.buyMoreItems(maybe);
	}
}
