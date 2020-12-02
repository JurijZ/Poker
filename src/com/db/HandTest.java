package com.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    public void GetHashSetOfSuit_ShouldReturnASetOfUniqueSuits(){

        Hand h = new Hand("JC", "8D", "KC", "4C", "QC");
        var set = h.GetHashSetOfSuit();

        assertEquals('C', set.iterator().next());
    }

    @Test
    public void GetOrderedListOfValues_ShouldReturnOrderedList(){

        Hand h = new Hand("JC", "8C", "KC", "4C", "QC");
        var list = h.GetOrderedListOfValues();

        assertEquals('4', list.get(0));
    }

    @Test
    void getOrderedListOfValuesAsIntegers() {
        Hand h = new Hand("JC", "8C", "KC", "4C", "QC");
        var list = h.GetOrderedListOfValuesAsIntegers();

        assertEquals(4, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(11, list.get(2));
        assertEquals(12, list.get(3));
        assertEquals(13, list.get(4));
    }

    @Test
    void getHashSetOfValuesAsIntegers() {
        Hand h = new Hand("JC", "8C", "KC", "4C", "QC");
        var set = h.GetHashSetOfValuesAsIntegers();

        //assertEquals(4, list.get(0));
        //assertEquals(8, list.get(1));
    }
}