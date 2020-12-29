package DoubleCirclularLinkedList;
import Node.DNode;
import java.util.Scanner;

//doubly linked list, uses a cursor and no sentinels.

public class DoublyCircularly<E> {
    private DNode<E> cursor;
    private int size;

    public DoublyCircularly(){
        size = 0;
        cursor = new DNode<>(null,null,null);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void advance() throws Exception{ 
        if (isEmpty())
                throw new Exception("List is empty");
        cursor = cursor.getNext();
    }

    private void goBack() throws Exception{
        if (isEmpty())
            throw new Exception("List is empty");
        cursor = cursor.getPrev();
    }

    public void addBefore(E data){
        addBetween(data, cursor.getPrev(), cursor);
    }

    public void addAfter(E data) {
        addBetween(data, cursor, cursor.getNext());
    }
    
    public void addBetween(E data, DNode<E> predecessor, DNode<E> successor){
        DNode<E> newNode = null;
        if (predecessor != null && successor != null){
            newNode = new DNode<>(data, predecessor, successor);
            predecessor.setNext(newNode);
            successor.setPrev(newNode);
            
        }else if (!isEmpty()){
            newNode = new DNode<>(data, cursor, cursor);            
            cursor.setNext(newNode);
            cursor.setPrev(newNode);
            
        }else{
            cursor.setData(data);
        }
        size++;
    }

    public E remove(){
        E data = null;
        DNode<E> afterNode;
            if(!isEmpty()){     
                data = cursor.getData();
                if(size > 1){
                    afterNode = cursor.getNext();
                    cursor = cursor.getPrev();
                    cursor.setNext(afterNode);
                    cursor.getNext().setPrev(cursor);
                }else{
                    cursor = null;
                }
                size--;
                return data;
            }else{
                data = (E) "List is Empty";
            }
        return data;
    }
    // LinkedList testing methods:
    public String toString() {
            String ans = "List status (cursor marked as ■):  ";
            DNode<E> n = cursor;
            ans += "(■)<-->";
            for (int i = 0; i < size; i++, n = n.getNext()){
                ans += " ("+(n.getData() + ") <-->");
                if( i == 0)
                    ans += "(■)";
            }
            return ans;
    }

    public static void main(String args[]) {
        DoublyCircularly<String> l = new DoublyCircularly<>();

        boolean done = false;
        Scanner s = new Scanner(System.in);
        while (!done) {
            try {
                System.out.println(l);
                System.out.println("\ncmds are H(elp) B(efore) A(fter) R(emove) + - Q(uit): >>");

                String cmd = s.next();
                String entry = null;

                char command = cmd.trim().toUpperCase().charAt(0);

                if (command == 'B' || command == 'A')
                    entry = s.next();

                switch (command) {
                    case 'H':
                            giveHelp();
                            break;
                    case 'Q':
                            done = true;
                            break;
                    case 'R':
                            l.remove();
                            break;
                    case '+':
                            l.advance();
                            break;
                    case '-':
                            l.goBack();
                            break;
                    case 'B':
                            l.addBefore(entry);
                            break;
                    case 'A':
                            l.addAfter(entry);
                            break;
                }
            } catch (Exception e) {
                    System.out.println("Error: " + e.toString());
            }
        }//ends while loop
        
        s.close();
    }//ends main

    private static void giveHelp() {
        String help = "Commands are:  H for help, Q to quit\n"
                        + " + or - to move the cursor forwards of backwards in the list\n"
                        + " A data, B data to insert data After or Before the cursor \n"
                        + " R to remove the cursor node from the list.";
        
        System.out.println(help);

    }

}//ends class


