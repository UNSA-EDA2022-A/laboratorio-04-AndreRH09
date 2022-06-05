package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise2 {

  @Test
  public void case_1() {

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('d');

    list.insertNth('c', 2);

    String result = list.toString();
    String expected = "{a,b,c,d}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_2() {

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('d');

    list.insertNth('c', 3);

    String result = list.toString();
    String expected = "{a,b,d,c}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_3() {

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('d');

    list.insertNth('c', 5);

    String result = list.toString();
    String expected = "{a,b,d}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_4() {

    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    list.insertNth(5, 0);

    String result = list.toString();

    String expected = "{5,10,20,30}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }
}
