package Queue;

import java.util.Scanner;

public class Queue{
    public static void main(String args[]) {
            System.out.println("Homework B by  xxxxxx "); // fill in your name here
            Deque<String> q = new ArrayDeque<>();
            Deque<String> qLink = new LinkedDeque<>();
            testDeque(q, qLink); // test both together
    }

    public static void testDeque(Deque<String> q, Deque<String> qLink) {
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        while (!done) {
            try {
                System.out.println(" Array queue: " + q + "  ");
                System.out.print("Linked queue: " + qLink + "      ");
                System.out.println("\ncmds are a r A R Q: >>");
                String cmd = sc.next();
                String entry = null;
                char command = cmd.charAt(0);
                if (command == 'a' || command == 'A')
                    entry = sc.next();
                switch (cmd.charAt(0)) {
                case 'Q':
                    done = true;
                    break;
                case 'a':
                    q.addFront(entry);
                    qLink.addFront(entry);
                    break;
                case 'A':
                    q.addRear(entry);
                    qLink.addRear(entry);
                    break;
                case 'r':
                    q.removeFront();
                    qLink.removeFront();
                    break;
                case 'R':
                    q.removeRear();
                    qLink.removeRear();
                    break;
                    }
            } catch (Exception e) {
                    System.out.println("Error " + e.toString());
            }
        }
        sc.close();
    }
}//ends Queue


