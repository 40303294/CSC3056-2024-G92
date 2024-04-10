package org.jfree.data;

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
	
	// Lab 3 tests
	
	@Test
	public void testForAnIncorrectUpperRangeInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Range(12, 4);;
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
	}
	
	@Test
	public void testRangeContainsAnInteger() {
		Range testRange7 = new Range(2, 26);
		assertEquals("The range (2, 26) contains the number: 5", true, testRange7.contains(5));
	}
	
	@Test
	public void testRangeDoesntContainsThisInteger() {
		Range testRange8 = new Range(7, 13);
		assertEquals("The range (7, 13) does not contain the number: 62", false, testRange8.contains(62));
	}
	
	@Test
	public void testDoRangesIntersect() {
		Range testRange9 = new Range(5, 15);
		assertEquals("The range (2, 7) does intersect the range (5, 15)", true, testRange9.intersects(2, 7));
	}

	@Test
	public void testRangesDoNotIntersect() {
		Range testRange10 = new Range(2, 21);
		assertEquals("The range (25, 42) does intersect the range (2, 21)", false, testRange10.intersects(25,42));
	}
	
	@Test
	public void testConstrainValueNotInRange() {
		Range testRange11 = new Range(15, 73);
		assertEquals("The value 82 closest to the 73", 73, testRange11.constrain(82), 0.0000001d);
	}
	
	@Test
	public void testConstrainValueLowerThanTestRange() {
		Range testRange12 = new Range(15, 73);
		assertEquals("The value 12 closest to the 15", 15, testRange12.constrain(12), 0.0000001d);
	}
	
	@Test
	public void testCombiningNullRanges() {
		Range firstRange13 = null;
		Range secondRange13 = new Range(6, 13);
		Range expectedRange13 = new Range(6, 13);
		assertEquals("The new range should be (6, 13)", expectedRange13, Range.combine(firstRange13, secondRange13));
	}
	
	/*
	@Test
	public void testCombiningNullRangesV2() {
		Range firstRange14 = new Range(51, 92);
		Range secondRange14 = null;
		Range expectedRange14 = new Range(51, 92);
		assertEquals("The new range should be (51, 92)", expectedRange14, Range.combine(firstRange14, secondRange14));
	}
	*/
	
	@Test
	public void testCombineBothNullRanges() {
		Range firstRange15 = null;
		Range secondRange15 = null;
		Range expectedRange15 = null;
		assertEquals("The new range should be null", expectedRange15, Range.combine(firstRange15, secondRange15));
	}
	
	@Test
	public void testExpandingToIncludeRangeIsNull() {
		Range testRange16 = null;
		Range expectedRange16 = new Range(25, 25);
		assertEquals("The new range is (25, 25)", expectedRange16, Range.expandToInclude(testRange16, 25));
	}
	
	
	@Test
	public void testExpandingToIncludeElseStatement() {
		Range testRange17 =  new Range(2, 5);
		Range expectedRange17 = new Range(2, 5);
		assertEquals("The new range is (2, 5)", expectedRange17, Range.expandToInclude(testRange17, 3));
	}
	
	@Test
	public void testExpandWhenRangeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
        	Range.expand(null, 12, 17);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }
	
	@Test
	public void testExpandRange() {
		Range testRange18 = new Range(16, 18);
		Range expectedRange18 = new Range(14, 22);
		assertEquals("The new range is (14, 22)", expectedRange18, Range.expand(testRange18, 2, 5));
	}
	
	@Test
	public void testShiftRange() {
		Range testRange19 = new Range(10, 20);
		Range expectedRange19 = new Range(15, 25);
		assertEquals("The new range is (15, 25)", expectedRange19, Range.shift(testRange19, 5));
	}
	
	@Test
	public void testShiftRangeWithZeroCrossing() {
		Range testRange20 = new Range(-5, 15);
		Range expectedRange20 = new Range(5, 25);
		assertEquals("The new range is (5, 25)", expectedRange20, Range.shift(testRange20, 10, true));
	}
	
	@Test
	public void testShiftRangeWithNoZeroCrossing() {
		Range testRange21 = new Range(-6, 12);
		Range expectedRange21 = new Range(0, 20);
		assertEquals("The new range is (0, 20)", expectedRange21, Range.shift(testRange21, 8, false));
	}
	
	@Test
	public void testShiftRangeWithNoZeroCrossingNegativeValue() {
		Range testRange22 = new Range(2, 17);
		Range expectedRange22 = new Range(0, 10);
		assertEquals("The new range is (0, 10)", expectedRange22, Range.shift(testRange22, -7, false));
	}


	
}
