package org.jfree.data;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.*;

public class DataUtilitiesTest {
	
	private Values2D values2D;

	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown() {
		values2D = null;
	}
	
	@Test
    public void testNullDataColumnTotal() {
        assertThrows(NullPointerException.class, () -> {
        	DataUtilities.calculateColumnTotal(null, 0);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }

	@Test
	public void testValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned, it should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 
				0.0000001d);
	}
	
	@Test
    public void testNullDataRowTotal() {
        assertThrows(NullPointerException.class, () -> {
        	DataUtilities.calculateRowTotal(null, 0);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }

	@Test
	public void testValidDataAndRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		assertEquals("Wrong sum returned, it should be 5.0",
				5.0, DataUtilities.calculateRowTotal(values2D, 1), 
				0.0000001d);
	} 
	
	@Test
    public void testCreateNumberArray() {
        double[] inputArray = {2.0, 4.0, 6.0};
        Number[] resultArray = DataUtilities.createNumberArray(inputArray);
        Number[] expectedArray = {2.0, 4.0, 6.0};
        assertArrayEquals(expectedArray, resultArray);
    }
	
	@Test
    public void testCreatingANullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
        	DataUtilities.createNumberArray(null);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }

	
	@Test
    public void testCreateNumberArray2D() {
        double[][] inputArray = {
                {1.0, 4.0},
                {9.0, 8.0}
        };
        Number[][] resultArray = DataUtilities.createNumberArray2D(inputArray);
        Number[][] expectedArray = {
                {1.0, 4.0},
                {9.0, 8.0}
        };

        assertArrayEquals(expectedArray, resultArray);
    }
	
	@Test
    public void testCreatingANull2DArray() {
        assertThrows(IllegalArgumentException.class, () -> {
        	DataUtilities.createNumberArray2D(null);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }
	
	@Test
	 public void testGetCumulativePercentages() {
		
		 DefaultKeyedValues inputValues = new DefaultKeyedValues();
	        inputValues.addValue(Integer.valueOf(0), 6);
	        inputValues.addValue(Integer.valueOf(1), 8);
	        inputValues.addValue(Integer.valueOf(2), 2);
	        
	        // Call the method
	        KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);

	        // Assert the cumulative percentages
	        assertEquals(0.375, (Double) result.getValue(Integer.valueOf(0)), 0.0001);
	        assertEquals(0.875, (Double) result.getValue(Integer.valueOf(1)), 0.0001);
	        assertEquals(1.0, (Double) result.getValue(Integer.valueOf(2)), 0.0001);
	    }
	
	@Test
    public void testANullCumulativePercentages() {
        assertThrows(IllegalArgumentException.class, () -> {
        	DataUtilities.createNumberArray2D(null);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
    }
	
	// Lab 3 tests
	
	@Test
	public void testCumulativePercentagesDataNull() {
		assertThrows(IllegalArgumentException.class, () -> {
        	DataUtilities.getCumulativePercentages(null);
        	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        });
	}
	
	@Test
    public void testCalculateRowTotalWithNullRowValue() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
        double total = DataUtilities.calculateRowTotal(testValues, 0);
        assertEquals(1.0, total, 0.001);
    }

	@Test
    public void testCalculateRowTotalWithNullColumnValue() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(4, 0, 1);
        double total = DataUtilities.calculateColumnTotal(testValues, 0);
        assertEquals(4.0, total, 0.001);
    }
	
}
