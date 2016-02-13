package edu.cpp.cs580;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.cpp.cs580.controller.WebController;

public class TestNorahMethod {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSum() {
		int expected_value = 10 ;
		int actual_value = WebController.sum(3, 7);
		assertEquals(expected_value,actual_value);
		}

}
