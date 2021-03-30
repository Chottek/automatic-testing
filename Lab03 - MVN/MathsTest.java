package pl.fox.lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTest {

    private Maths maths;

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
        assertNull(maths);
    }

    @Test
    public void checkIfIsNotNull(){
        final String name = "Martin";
        final int age = 22;
        maths = new Maths()
                .withName(name)
                .withAge(age);
        assertNotNull(maths);
    }

    @Test
    public void checkArraysEquality(){
        maths = new Maths(null, 0);
        final int[] arr1 = {1, 2, 3, 4, 5, 6};
        maths.setArray1(arr1);
        final int[] arr2 = {6, 5, 4, 3, 2, 1};
        maths.setArray2(arr2);
        assertArrayEquals(maths.getArray1(), Maths.sort(maths.getArray2()));
    }

    @Test
    public void checkNullity(){
        maths = new Maths("Name", 22).withName(null);
        assertNull(maths.getName());
    }

    @Test
    public void checkIfThrowsException(){
        maths = new Maths("HelloWorld", 0);
        assertThrows(java.io.IOException.class, () -> maths.exceptionThrower());
    }
}
