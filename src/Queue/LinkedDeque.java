/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;
import Node.DNode;

class LinkedDeque<T> implements Deque<T> {
    private DNode<T> front, rear;
    private int size, cap;

    // add implementations for the following methods
    // your code should perform in exactly the same way as the corresponding
    // ArrayDeque<T> methods
    // you should not add any extra instance variables to the class and must
    // use a doubly linked list implementation.

    public LinkedDeque() {
        size = 0;
        front = rear = null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public T removeFront() throws Exception {
        if(empty())
            throw new Exception("Queue is empty!");
        
        T result = front.getData();
        front = front.getPrev();
        resetCheck();
        
        return result;
    }

    public T removeRear() throws Exception {
        if(empty())
            throw new Exception("Queue is empty!");
        
        T result = rear.getData();
        rear = rear.getNext();
        resetCheck();
        return result;
    }
    
    public void resetCheck(){
        size--;
        if(size == 1)
        front = rear = null;
    }

    public void addRear(T x) throws Exception {
        DNode<T> newNode = new DNode<>(x , null, null);
        if(!empty()){
            addNode(newNode, rear);
            
        }else{
            newNode = front = rear;
        }
        throw new Exception("Queue is full!");
    }

    public void addFront(T x) throws Exception {
        // add implementation
        throw new Exception("Queue is full!");
    }
    public void addNode(DNode<T> prevNode, DNode<T> nextNode){
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }

    public String toString() {
        // add implementation
        return "";
    }
}// linkedDeque class