package junit_test_classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;

public class PeripheriqueTest {
	private Ordinateur mac;
	private Peripherique epson;
	private Peripherique logitec;

	@Before
	public void setUp(){
		mac = new Ordinateur("Desktop", "Apple");
		epson = new Peripherique("imprimante");
		logitec = new Peripherique("souris");
		mac.addPeripherique(epson);
	}

	@Test
	public void testSampleMethod(){
		String expected= "imprimante de Desktop Apple\nPeripheriques : \nimprimante\n";
		String result= epson.sampleMethod();
		Assert.assertTrue(expected.equals(result));
	}

	@Test
	public void testEquals() {
		Assert.assertTrue(!epson.equals(null));
		Assert.assertEquals(epson, epson);
		Assert.assertEquals(epson, new Peripherique("imprimante"));
		Assert.assertTrue(!epson.equals(logitec));
	}
}
