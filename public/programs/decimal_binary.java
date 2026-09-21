import java.util.Scanner;

public class deque {

    static int[] dq;
    static int front = -1;
    static int rear = -1;
    static int size;

    static boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    static boolean isEmpty() {
        return front == -1;
    }

    static void insertFront(int value) {

        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        dq[front] = value;
        System.out.println(value + " inserted at front.");
    }

    static void insertRear(int value) {

        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        dq[rear] = value;
        System.out.println(value + " inserted at rear.");
    }

    static void deleteFront() {

        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println(dq[front] + " deleted from front.");

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    static void deleteRear() {

        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println(dq[rear] + " deleted from rear.");

        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    static void display() {

        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        int i = front;

        System.out.println("Deque elements:");

        while (true) {

            System.out.print(dq[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque size: ");
        size = sc.nextInt();

        dq = new int[size];

        while (true) {

            System.out.println("\n1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    insertRear(sc.nextInt());
                    break;

                case 3:
                    deleteFront();
                    break;

                case 4:
                    deleteRear();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}