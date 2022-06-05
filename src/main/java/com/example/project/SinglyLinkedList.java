package com.example.project;

public class SinglyLinkedList<T> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        
            Node <T> current = first;
            Node <T> aux;                                                       //Este nodo modificara las conexuiones siguientes del nodo current
            Node <T> repetido;                                                  //Este nodo se usa para comparar los nodos siguientes
            
            while(current !=null ){                                             //Comrpueba que los nodos actual exista

                aux = current;                                                  //Utiliza la direccion del nodo actual para que alterar las siguientes conexxiones 
                repetido = current.getNext();                                   //Utiliza la direccion del siguiente nodo para comparar 
                
                while(repetido!=null ){                                         //verifica que el nodo actual tenga un siguiente diferente a null

                    if(repetido.getValue()== current.getValue()){               //Compara que el nodo actual no este repetido con  el valor del nodo que le sigue
                        
                        aux.setNext(repetido.getNext());                        //Actualiza quien es el nodo siguiente, a dos posiciones adelante ("eliminando" el duplicado)
                        this.size--;                                            //Se reduce el tamaaño de la lista
                    }
                    else
                        aux= repetido;                                          //Si es que el siguiente nodo no esta repetido, el auxiliar toma la posicion siguiente, por si existe un posible cambio
                    repetido = repetido.getNext();                              //El nodo que se esta comparando (siguiente) toma el valor que le sigue

                }
                current = current.getNext();                                    //El siguiente nodo de la lista se convierte en el actual
            }
            
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
        if(position<0 || position>size)       //Si la posicion brindada es negativa o excede el tamaño esta fuera de rango
            System.out.println("Fuera de rango.");
        else{
            if(position == 0 )                                      //Si se desea poner en la primera posicion, se recicla el metodo addFirst
                addFirst(data); 
            else if(position == size)                               //Si se desea poner en la ultima posicion, se recicla el metodo addLast
                addLast(data);
            else{
                Node<T> temp = first;                               //Se crea un temporal para conectar el nuevo nodo en una posicion "entre medios"
                int i=0;
                while (i<position-1) {                              //Se itera hasta llegar un nodo antes de la posicion deseada 
                    temp= temp.getNext();
                    i++;
                }
                size++;                                                 //En los 3 casos se esta agregando el tamaño de la lista
                temp.setNext(new Node<T>(data, temp.getNext()));    //El nodo que precede al nuevo nodo se establece como siguiente, y el nuevo establece su siguiente
            }
        }
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        if(position<0 || position>size)                      //Si la posicion brindada es negativa o excede el tamaño de la lista, fuera de rango 
            System.out.println("Fuera de rango.");
        else{
            if(position == 0 )                                                  //Si se desea eliminar el primero se reutiliza el metodo
                removeFirst();
            else if(position == size())                                         //Si se desea eliminar el ultimo se reutiliza el metodo
                removeLast();
            else{
                Node<T> temp = first;                                           //El temporal permite actualizar el siguiente nodo al finalizar la iteracion
                int i=0;
                while (i<position-1) {                                          //El temporal se ubica una posicion antes del nodo que se quiere eliminar
                    temp= temp.getNext();                                       
                    i++;
                }
                temp.setNext(temp.getNext().getNext());                         //Se establece que el nodo siguiente, sea el posterior al que se esta eliminando, y existe ya que el caso de eliminar el ultimo esta cubierto
                this.size--;                                                    //Se reduce el tamaño de la lista 
            }
        }
    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}
