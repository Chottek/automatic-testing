package pl.fox.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

public class FoodTest {

    private Beer kozel;
    private Sandwich schinkenBrot;

    @Test
    public void testBeerAmount(){
        kozel = mock(Beer.class);
        when(kozel.getAmount()).thenReturn(700);
        assertNotEquals(600, kozel.getAmount());
    }

    @Test
    public void testBeerInfinity(){
        kozel = mock(Beer.class);
        when(kozel.getAmount()).thenReturn(700);
        try{
            kozel.drink(200);
        }catch(CannotConsumeAirException ccae){
            ccae.printStackTrace();
        }

        assertEquals(700, kozel.getAmount());
    }

    @Test
    public void testBeerDrinking(){
        final Beer hemelinger = new Beer("Hemelinger", 500);
        try{
            hemelinger.drink(100);
        }catch(CannotConsumeAirException ccae){
            ccae.printStackTrace();
        }

        assertEquals(400, hemelinger.getAmount());
    }

    @Test
    public void testBeerNameMocking(){
        Beer noName = mock(Beer.class);
        when(noName.getName()).thenReturn("Desperados".toUpperCase());
        assertEquals("desperados".toUpperCase(), noName.getName());
    }

    @Test
    public void testTooMuchBeerDrinking(){
        final Beer zubr = new Beer("Zubr", 500);
        assertThrows(CannotConsumeAirException.class, () -> zubr.drink(600));
    }

    @Test
    public void testSandwichAmount(){
        schinkenBrot = mock(Sandwich.class);
        given(schinkenBrot.getQuantity()).willReturn(4);
        assertEquals(4, schinkenBrot.getQuantity());
    }

    @Test
    public void testSandwichInfinity(){
        schinkenBrot = mock(Sandwich.class);
        when(schinkenBrot.getQuantity()).thenReturn(4);
        try{
            schinkenBrot.eat(2);
        }catch(CannotConsumeAirException ccae){
            ccae.printStackTrace();
        }
        assertEquals(4, schinkenBrot.getQuantity());
    }

    @Test
    public void testSandwichEating(){
        final Sandwich keiserSemmel = new Sandwich("KeiserSemmel", 2);
        assertDoesNotThrow(() -> keiserSemmel.eat(2));
    }

    @Test
    public void testTooMuchSandwichEating(){
        final Sandwich subwayTeriyaki = new Sandwich("Subway Teriyaki", 9);
        assertThrows(CannotConsumeAirException.class, () -> subwayTeriyaki.eat(10));
    }

    @Test
    public void testSandwichNameMocking(){
        Sandwich noName = mock(Sandwich.class);
        when(noName.getName()).thenReturn("BułkaZMasłem".toUpperCase());
        assertEquals("bułkazmasłem".toUpperCase(), noName.getName());
    }

}
