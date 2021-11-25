package junit_test_classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import electronics_classes.Ordinateur;
import junit.framework.TestSuite;

public class OrdinateurTest {
	private Ordinateur ordinateur1;
	private Ordinateur ordinateur2;

	@Before
	public void setUp(){
		ordinateur1 = new Ordinateur("Desktop", "Apple");
		ordinateur2 = new Ordinateur("Laptop", "HP");
	}
	@Test
	public void testSampleMethod(){
		String expected= "Desktop Apple\nPeripheriques : \n";
		String result = ordinateur1.sampleMethod();
		Assert.assertTrue(expected.equals(result));
	}
	@Test
	public void testEquals() {
		Assert.assertTrue(!ordinateur1.equals(null));
		Assert.assertEquals(ordinateur1, ordinateur1);
		Assert.assertEquals(ordinateur1, new Ordinateur("Desktop", "Apple"));
		Assert.assertTrue(!ordinateur1.equals(ordinateur2));
	}

	public static TestSuite suite() {
		return new TestSuite(OrdinateurTest.class);
	}
}
