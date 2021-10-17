package ua.goit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class CostCalculateTest {

    CostCalculate bag = new CostCalculate();

    @Test
    public void splitBagTest() {
        Map<String, Integer> count = new HashMap<>();
        count.put("A", 1);
        count.put("B", 1);
        count.put("C", 1);
        count.put("D", 1);

        Map<String, Integer> count2 = new HashMap<>();
        count2.put("A", 0);
        count2.put("B", 0);
        count2.put("C", 0);
        count2.put("D", 0);

        assertEquals(bag.splitBag("ABCD"), count);
        assertEquals(bag.splitBag(""), count2);
    }

    @Test
    public void calculateTotalCostTest () {
        assertEquals("False", 13.25, bag.calculateTotalCost("ABCDABA"), 0.0);
        assertEquals(7.25, bag.calculateTotalCost("ABCD"), 0.0);
        assertEquals(0.0, bag.calculateTotalCost(""), 0.0);
    }

}
