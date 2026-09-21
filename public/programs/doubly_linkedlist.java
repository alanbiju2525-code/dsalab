import java.util.Scanner;

public class doubly_linkedlist {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head = null;

    static void insert(int value, int position) {

        Node newNode = new Node(value);

        if (position == 1) {

            newNode.next = head;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    static void delete(int position) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        if (position == 1) {

            head = head.next;

            if (head != null) {
                head.prev = null;
            }

            return;
        }

        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    static void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.println("Doubly linked list:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();

                    insert(value, pos);
                    break;

                case 2:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();

                    delete(pos);
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}