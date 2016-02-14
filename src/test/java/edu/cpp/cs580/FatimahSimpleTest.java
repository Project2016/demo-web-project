package edu.cpp.cs580;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.cpp.cs580.controller.WebController;

public class FatimahSimpleTest {

	
	@Test
	public void test() {
		WebController greeting = new WebController();
		String result = greeting.greet("Fatimah");
		assertNotNull(result);
		assertEquals("Hello" + "Fatimah",result);
	}

}
