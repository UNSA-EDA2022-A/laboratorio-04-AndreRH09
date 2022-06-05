package com.example.project;

public class Node<T> {
    private T value;      // Valor guardado en el nodo
    private Node<T> next; // Referencia para el proximo nodo de la lista
 
    // Constructor
    Node(T v, Node<T> n) {
       value = v;
       next = n;
    }
 
    // Getters e Setters
    public T getValue() { return value; }
    public Node<T> getNext()  { return next; }
    public void setValue(T v) { value=v; }
    public void setNext(Node<T> n) { next = n; }
 }