package edu.cpp.cs580;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
// Raveena JUnit testing 
    // START
    public class JunitTesting
	{
		public int square(int x)
		{
			return x*x;
		
		}
		
		public int countA(String word)
		{
			int count = 0;
			for(int i=0; i<=word.length(); i++)
			{
				if (word.charAt(i)=='a' || word.charAt(i)=='A')
				{
					count++;
				}
			}
			return count;
		}	
		
	}
    
    
    
    public void test1() // testing the square of a number
    {
     JunitTesting test =   new JunitTesting();
     int output = test.square(5);
     //int output1 = test.countA("alphabet");
     //assertEquals(2, output1);
     assertEquals(25, output);
    
    }
   // public void test2() // testing the count of variable 'a'
   // {
   // JunitTesting test =   new JunitTesting();
   //  int output = test.countA("alphabet");
   //  assertEquals(2, output);
    
   // }
   
   // Raveena JUnit Testing END
}
 
