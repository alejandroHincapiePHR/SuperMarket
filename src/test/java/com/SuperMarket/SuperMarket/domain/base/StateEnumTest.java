package com.SuperMarket.SuperMarket.domain.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StateEnumTest {

    @Test
    public void testActiveValueConversion(){
        StateEnum active = StateEnum.fromValue(1);
        assertEquals(StateEnum.ACTIVE, active);
    }

    @Test
    public void testDeletedValueConversion(){
        StateEnum deleted = StateEnum.fromValue(2);
        assertEquals(StateEnum.DELETED, deleted);
    }

    @Test
    public void testActiveStatusConversion(){
        StateEnum active = StateEnum.fromState("Active");
        assertEquals(StateEnum.ACTIVE, active);
    }

    @Test
    public void testDeletedStatusConversion(){
        StateEnum deleted = StateEnum.fromState("Deleted");
        assertEquals(StateEnum.DELETED, deleted);
    }

    @Test
    public void testFromValueException(){
        assertThrows(IllegalArgumentException.class, ()->StateEnum.fromValue(0));
    }


    @Test
    public void testFromStateException(){
        assertThrows(IllegalArgumentException.class, ()->StateEnum.fromState("fdbzdfghf"));
    }

    @Test
    public void testFromValueExceptionNull(){
        assertThrows(IllegalArgumentException.class, ()->StateEnum.fromValue(null));
    }

    @Test
    public void testFromStateExceptionNull(){
        assertThrows(IllegalArgumentException.class, ()->StateEnum.fromState(null));
    }



}
