package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise1 {

  @Test
  public void case_1() {

    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addLast('a');
    list.addLast('b');
    list.addLast('c');
    list.addLast('c');
    
    list.deleteDuplicates();

    String result = list.toString();
    String expected = "{a,b,c}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_2() {

    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    list.addLast(47);
    list.addLast(89);
    list.addLast(56);
    list.addLast(89);
    list.addLast(56);
    
    list.deleteDuplicates();

    String result = list.toString();

    String expected = "{47,89,56}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_3() {

    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    
    list.deleteDuplicates();

    String result = list.toString();
    String expected = "{1,2,3,4,5,6}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

  @Test
  public void case_4() {

    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    list.addLast("Jorge");
    list.addLast("Juan");
    list.addLast("Jorge");
    
    list.deleteDuplicates();

    String result = list.toString();
    String expected = "{Jorge,Juan}";

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero retorno: " + result);
  }

}
