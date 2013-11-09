package edu.uci.mvu1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UtilityTest {
    @Test
    public void testStringToLong() throws Exception {
        assertEquals(12345, Utility.stringToLong("12345"));
        assertEquals(99999999, Utility.stringToLong("99999999"));
        assertEquals(10, Utility.stringToLong("00010"));
        assertEquals(100100, Utility.stringToLong("100100"));

        String max = String.valueOf(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, Utility.stringToLong(max));

        assertEquals(-12345, Utility.stringToLong("-12345"));
        assertEquals(0, Utility.stringToLong("-0"));
        assertEquals(-100100, Utility.stringToLong("-100100"));

        String min = String.valueOf(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, Utility.stringToLong(min));
    }
}
