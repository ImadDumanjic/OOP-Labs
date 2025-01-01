package Vjezba;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Testt{
    tests Test = new tests();
    @Test
    public void factorial(){
        assertEquals(120, Test.factorial(5));
        assertNotEquals(120, Test.factorial(6));
        assertTrue(Test.factorial(5) == 120, "It is 201.");
        assertFalse(Test.factorial(5) == 100, "It should be 120.");
    }

    @Test
    public void reverseString(){
        assertEquals("Imad", Test.reverseString("damI"));
        assertThrows(IllegalArgumentException.class, () -> Test.reverseString(null));
    }

    @Test
    public void findMax(){
        assertEquals(10, Test.findMax(new int[]{1, 10, 3}));
        assertNotEquals(9, Test.findMax(new int[]{1, 10, 3}));
        assertFalse(Test.findMax(new int[]{111, 10, 3}) == 10, "It should be 10.");
        assertThrows(IllegalArgumentException.class, () -> Test.findMax(new int[]{}));
    }

    @Test
    public void celsiusToFarenheit(){
        assertEquals(104, Test.celsiusToFahrenheit(40));
        assertTrue(Test.celsiusToFahrenheit(40) == 104);
        assertFalse(109 == Test.celsiusToFahrenheit(80));
    }

}