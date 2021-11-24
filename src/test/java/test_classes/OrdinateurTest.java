package test_classes;



import org.junit.Assert;
import org.junit.After;
import org.junit.Before;

import electronics_classes.Ordinateur;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class OrdinateurTest extends TestCase {
	
   private Ordinateur ordinate1;
   private Ordinateur ordinate2;
   

    public OrdinateurTest()
    {
    }

    @Before
    public void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
    	ordinate1 = new Ordinateur("Desktop", "Apple");
    	ordinate2 = new Ordinateur("Laptop", "HP");
    }

    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Lib�rez ici les ressources engag�es par setUp()
    }

  
    
    public void testSampleMethod()
    {
        String expected= "Desktop Apple\nPeripheriques : \n";
        String  result= ordinate1.sampleMethod();
        Assert.assertTrue(expected.equals(result));
      
    }
    
    
    public void testEquals() {
        Assert.assertTrue(!ordinate1.equals(null));
        Assert.assertEquals(ordinate1, ordinate1);
        Assert.assertEquals(ordinate1, new Ordinateur("Desktop", "Apple"));
        Assert.assertTrue(!ordinate1.equals(ordinate2));
        
    }
    
    public static TestSuite suite() {
	    return new TestSuite(OrdinateurTest.class);
    }
   

}

