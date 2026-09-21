import java.util.Scanner;

public class queue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    static void insert(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(value + " inserted.");
    }

    static void delete() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(front.data + " deleted.");

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    static void display() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;

        System.out.println("Queue elements:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insertion");
            System.out.println("2. Deletion");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    insert(value);
                    break;

                case 2:
                    delete();
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