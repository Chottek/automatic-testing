import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathsTest {

    private Maths mathsObj;

    @Test
    public void doesItAdd(){
        assertEquals(100, Maths.add(10, 20, 30, 40));
    }

    @Test
    public void doesItSub(){
        assertEquals(40, Maths.sub(100, 10, 10, 10, 10, 10, 10));
    }

    @Test
    public void doesItMult(){
        assertEquals(20, Maths.mult(2, 10));
    }

    @Test
    public void doesItDiv(){
        assertEquals(10, Maths.div(20, 2));
    }

    @Test
    public void mixThemBooleans(){
        assertFalse(Maths.mixBoolean(10));
    }

    @Test
    public void mixThemBooleansAgain(){
        assertTrue(Maths.mixBoolean(3));
    }

    @Test
    public void checkIfIsNull(){
        assertNull(mathsObj);
    }

    @Test
    public void checkIfIsNotNull(){
        final String name = "Henryk";
        final int age = 77;
        mathsObj = new Maths(name, age);
        assertNotNull(mathsObj);
    }

    @Test
    public void checkArraysEquality(){
        mathsObj = new Maths(null, 0);
        final int[] arr1 = {1, 2, 3, 4, 5, 6};
        mathsObj.setArray1(arr1);
        final int[] arr2 = {6, 5, 4, 3, 2, 1};
        mathsObj.setArray2(arr2);
        assertArrayEquals(mathsObj.getArray1(), Maths.sort(mathsObj.getArray2()));
    }

    @Test
    public void checkNullity(){
        mathsObj = new Maths(null, 10);
        assertNull(mathsObj.getName());
    }
}
