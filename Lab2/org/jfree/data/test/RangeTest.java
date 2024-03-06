package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The chentral value of -1 and 1 should be 0",
				0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}
	
	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength(), 0.0000001d); 
	} 
	
	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		Range r2 = new Range(4, 9); 
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength(), 0.0000001d);
	} 
	
	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength(), 0.0000001d); 
	} 
	
	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11, -4); 
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength(), 0.0000001d); 
	} 
	
	@Test
	public void testGetLengthOnePositiveOneNegative() { 
		Range r5 = new Range(-5, 3); 
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength(), 0.0000001d); 
	} 
	
	@Test
	public void testNewRangedoesntContainAnInteger() {
		Range testRange1 = new Range(7, 12);
		assertEquals("Range(7, 12).contains(5) should return a false", false, testRange1.contains(5));
	}
	
	@Test
	public void testValueIsNotWithinTheRangeWithConstraint() {
		Range testRange2 = new Range(8, 20);
		assertEquals("The value 404.0 will not be in the range. should return 20.0", 20.0, testRange2.constrain(404.0), 0.0000001d);
	}

	@Test
	public void testLowerBoundsWithNegativeLowerBound() {
		Range testRange3 = new Range(-12, 15);
		assertEquals("The value -12 is the lower bound", -12.0, testRange3.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testLowerBoundsWithHighLowerBound() {
		Range testRange4 = new Range(400, 1000);
		assertEquals("The value 400 is the lower bound", 400.0, testRange4.getLowerBound(), 0.0000001d);
	}

	@Test
	public void testUpperBoundsWithNegativeUpperBound() {
		Range testRange5 = new Range(-51, -12);
		assertEquals("The value -12 is the Upper bound", -12.0, testRange5.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testUpperBoundsWithHighUpperBound() {
		Range testRange6 = new Range(300, 1000);
		assertEquals("The value 1000 is the Upper bound", 1000.0, testRange6.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testExpandRangeToIncludeALowNumber() {
		Range inputRange1 = new Range(12, 52);
		Range ExpectedRange1 = new Range(4, 52);
		assertEquals("The new range should be (4,52)", ExpectedRange1, Range.expandToInclude(inputRange1, 4.0));
	}

	@Test
	public void testExpandRangeToIncludeAHighNumber() {
		Range inputRange2 = new Range(100, 200);
		Range expectedRange2 = new Range(100, 420);
		assertEquals("The new range should be (100, 420)", expectedRange2, Range.expandToInclude(inputRange2, 420.0));
	}
	
	@Test
	public void testCombineTwoNegativeRanges() {
		Range firstRange3 = new Range(-10, 200);
		Range secondRange3 = new Range(-20, 100);
		Range expectedRange3 = new Range(-20, 200);
		assertEquals("The new range should be (-15, 200)", expectedRange3, Range.combine(firstRange3, secondRange3));
	}
	
	@Test
	public void testCombineTwoPositiveRanges() {
		Range firstRange4 = new Range(100, 200);
		Range secondRange4 = new Range(100, 420);
		Range expectedRange4 = new Range(100, 420);
		assertEquals("The new range should be (100, 420)", expectedRange4, Range.combine(firstRange4, secondRange4));
	}

	@Test
	public void testCombineBothNullRange() {
		Range firstRange6 = new Range(0, 0);
		Range secondRange6 = new Range(0, 0);
		Range expectedRange6 = new Range(0, 0);
		assertEquals("The new range should be (0, 0)", expectedRange6, Range.combine(firstRange6, secondRange6));
	}


}
