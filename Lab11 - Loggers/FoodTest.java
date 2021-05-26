package pl.fox.lab4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

public class FoodTest {


    private static final Logger LOG = LoggerFactory.getLogger(FoodTest.class);

    private Beer kozel;
    private Sandwich schinkenBrot;

    @Test
    public void testBeerAmount(){
        kozel = mock(Beer.class);
        LOG.info("Mocked {}", kozel.getClass());
        LOG.debug("{}", kozel.toString());

        when(kozel.getAmount()).thenReturn(700);
        assertNotEquals(600, kozel.getAmount());
    }

    @Test
    public void testBeerInfinity(){
        kozel = mock(Beer.class);
        when(kozel.getAmount()).thenReturn(700);
        LOG.info("Mocked {} with amount: {}", kozel.getClass(), kozel.getAmount());
        LOG.debug("{}", kozel.toString());

        final int amount = 200;
        try{
            LOG.info("Drinking {} from {} ml", amount, kozel.getAmount());
            kozel.drink(amount);
        }catch(CannotConsumeAirException ccae){
            LOG.error("{} experienced an error", kozel.getClass());
            ccae.printStackTrace();
        }

        assertEquals(700, kozel.getAmount());
    }

    @Test
    public void testBeerDrinking(){
        final Beer hemelinger = new Beer("Hemelinger", 500);
        LOG.info("Created new object of {}", hemelinger.getClass());
        LOG.debug("{}", hemelinger.toString());
        final int amount = 100;
        try{
            LOG.info("Drinking {} from {} ml", amount, hemelinger.getAmount());
            hemelinger.drink(amount);
        }catch(CannotConsumeAirException ccae){
            LOG.error("{} experienced an error", kozel.getClass());
            ccae.printStackTrace();
        }

        assertEquals(400, hemelinger.getAmount());
    }

    @Test
    public void testBeerNameMocking(){
        Beer noName = mock(Beer.class);
        when(noName.getName()).thenReturn("Desperados".toUpperCase());
        LOG.info("Mocked {}", noName.getClass());
        LOG.debug("{}", noName.toString());
        assertEquals("desperados".toUpperCase(), noName.getName());
    }

    @Test
    public void testTooMuchBeerDrinking(){
        final Beer zubr = new Beer("Zubr", 500);
        LOG.info("Created {}", zubr.getClass());
        LOG.debug("{}", zubr.toString());
        assertThrows(CannotConsumeAirException.class, () -> zubr.drink(600));
    }

    @Test
    public void testSandwichAmount(){
        schinkenBrot = mock(Sandwich.class);
        given(schinkenBrot.getQuantity()).willReturn(4);
        LOG.info("Created {} with quantity of: {}", schinkenBrot.getClass(), schinkenBrot.getQuantity());
        LOG.debug("{}", schinkenBrot.toString());
        assertEquals(4, schinkenBrot.getQuantity());
    }

    @Test
    public void testSandwichInfinity(){
        schinkenBrot = mock(Sandwich.class);
        when(schinkenBrot.getQuantity()).thenReturn(4);
        LOG.info("Created {} with quantity of: {}", schinkenBrot.getClass(), schinkenBrot.getQuantity());
        LOG.debug("{}", schinkenBrot.toString());
        final int quantity = 2;
        try{
            LOG.info("Eating {} from {} sandwiches", quantity, schinkenBrot.getQuantity());
            schinkenBrot.eat(quantity);
        }catch(CannotConsumeAirException ccae){
            LOG.error("{} experienced an error", schinkenBrot.getClass());
            ccae.printStackTrace();
        }
        assertEquals(4, schinkenBrot.getQuantity());
    }

    @Test
    public void testSandwichEating(){
        final Sandwich keiserSemmel = new Sandwich("KeiserSemmel", 2);
        LOG.info("Created new {}", keiserSemmel.getClass());
        LOG.debug("{}", keiserSemmel.toString());
        assertDoesNotThrow(() -> keiserSemmel.eat(2));
    }

    @Test
    public void testTooMuchSandwichEating(){
        final Sandwich subwayTeriyaki = new Sandwich("Subway Teriyaki", 9);
        LOG.info("Created new {}", subwayTeriyaki.getClass());
        LOG.debug("{}", subwayTeriyaki.toString());
        assertThrows(CannotConsumeAirException.class, () -> subwayTeriyaki.eat(10));
    }

    @Test
    public void testSandwichNameMocking(){
        Sandwich noName = mock(Sandwich.class);
        when(noName.getName()).thenReturn("BułkaZMasłem".toUpperCase());
        LOG.info("Mocked {} with name: {}", noName.getClass(), noName.getName());
        LOG.debug("{}", noName.toString());

        assertEquals("bułkazmasłem".toUpperCase(), noName.getName());
    }

}
