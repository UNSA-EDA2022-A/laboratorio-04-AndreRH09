package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise3 {
    @Test
    public void case_1() {

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        list.deleteNth(2);

        String result = list.toString();
        String expected = "{a,b}";

        assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
    }

    @Test
    public void case_2() {

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        list.deleteNth(4);

        String result = list.toString();
        String expected = "{a,b,d}";

        assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
    }

    @Test
    public void case_3() {

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        list.deleteNth(0);

        String result = list.toString();
        String expected = "{b,d}";

        assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
    }

    @Test
    public void case_4() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(10);

        list.deleteNth(0);

        String result = list.toString();

        String expected = "{}";

        assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
    }
}
