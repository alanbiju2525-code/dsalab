import java.util.Scanner;

public class circular_queue {

    static int[] queue;
    static int front = -1;
    static int rear = -1;
    static int size;

    static void insert(int value) {

        if ((rear + 1) % size == front) {
            System.out.println("Queue is full.");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;

        System.out.println(value + " inserted.");
    }

    static void delete() {

        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(queue[front] + " deleted.");

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    static void display() {

        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue elements:");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        size = sc.nextInt();

        queue = new int[size];

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