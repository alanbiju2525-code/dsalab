import java.util.Scanner;

public class decimal_binary {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insert(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    static void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int number = sc.nextInt();

        if (number == 0) {
            System.out.println("Binary: 0");
            sc.close();
            return;
        }

        int n = number;

        while (n > 0) {
            int remainder = n % 2;
            insert(remainder);
            n = n / 2;
        }

        System.out.print("Binary: ");
        display();

        sc.close();
    }
}