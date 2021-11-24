package test_classes;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;

import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class PeripheriqueTest extends TestCase
{
    private Ordinateur mac;
    private Peripherique epson;
    private Peripherique logitec;

   
   

  
    @Before
    public void setUp() // throws java.lang.Exception
    {
        mac = new Ordinateur("Desktop", "Apple");
        epson = new Peripherique("imprimante");
        logitec = new Peripherique("souris");

        mac.addPeripherique(epson);
    }

  
    @After
    public void tearDown() // throws java.lang.Exception
    {
      
    }

    
    public void testSampleMethod()
    {
        
        String expected= "imprimante de Desktop Apple\nPeripheriques : \nimprimante\n";
        String  result= epson.sampleMethod();
        Assert.assertTrue(expected.equals(result));
      
    }
    
    
    public void testEquals() {
        Assert.assertTrue(!epson.equals(null));
        Assert.assertEquals(epson, epson);
        Assert.assertEquals(epson, new Peripherique("imprimante"));
        Assert.assertTrue(!epson.equals(logitec));
        
    }
    
    public static TestSuite suite() {
	    return new TestSuite(PeripheriqueTest.class);
    }
    
  
   
    
}

