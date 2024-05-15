package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
private List<Item> createList(Item elems){
    return new ArrayList<Item>(Arrays.asList(elems));
}
    @Test
    void checkEveryBranch() {
     RuntimeException ex;
     //1
     ex= assertThrows(RuntimeException.class, ()->
             SILab2.checkCart(null,123));
     assertTrue(ex.getMessage().contains("allItems list can't be null!"));
     //2
        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));
        //3
        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));
     //4
        ex = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(createList(new Item(" ", null, 20, 0.5f)), 1));
        assertTrue(ex.getMessage().contains("No barcode!"));
        //5
        assertFalse(SILab2.checkCart(createList(new Item(" ", "01234", 350, 0.5f)), 1));
        //6
        ex= assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(createList(new Item("Ljubica", "0123ad4", 200, 0.5f)), 1));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
        //7
        assertFalse(SILab2.checkCart(createList(new Item("Ljubica", "234", 200, -1f)), 1));


    }

    @Test
    void checkMultipleCondition(){
      //TTN
        assertFalse(SILab2.checkCart(createList(new Item("vccx", "1245", 350, 0.2f)), 1));
      //TTT
        assertTrue(SILab2.checkCart(createList(new Item("abc", "01234", 400, 0.5f)),200));
        //NXX
        assertFalse(SILab2.checkCart(createList(new Item("cxccvx", "01245", 100, 0.2f)), 1));
        //TNX
        assertFalse(SILab2.checkCart(createList(new Item("cvcv", "01245", 350, 0f)), 1));




    }
}