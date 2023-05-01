package io.github.joykrishan.linkedlist_module;

public class LinkedList {
    private Node first;
    private Node last;

    class Node {
       private int item;
       private Node next;

       Node(int item){
           this.item = item;
       }
    }

    public void addFirst(int item){
        Node newNode = new Node(item);
        if (first == null){
            first = last = newNode;
        }else{
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int item){
        Node newNode = new Node(item);
        if (last == null){
         last = first = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteFirst(){
        if (first.next == null){ // only one node
            first = last = null;
        }else{
            Node firstNode = first;
            first = firstNode.next;
            firstNode.next = null;
        }
    }

    public void deleteLast(){
        if (last.next == null) first = last = null;
        else {
            Node secondLastNode = first;
            while (secondLastNode.next != last) {
                secondLastNode = secondLastNode.next;
            }
            secondLastNode.next = null;
            last = secondLastNode;
        }
    }

    public void print(){
        Node node = first;
        while (node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }

    public boolean contains(int item){
        Node node = first;
        while(node != null){
            if(node.item == item) return true;
            node = node.next;
        }
        return false;
    }

    public int indexOf(int item){
        Node node = first;
        int idx = 0;
        while(node != null){
            if(node.item == item) return idx;
            node = node.next;
            idx += 1;
        }
        return -1;
    }
}
