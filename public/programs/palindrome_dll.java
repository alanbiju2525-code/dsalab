import java.util.Scanner;

public class palindrome_dll {

    static class Node {
        char data;
        Node prev;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    static Node head = null;
    static Node tail = null;

    static void insert(char value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    static boolean isPalindrome() {

        Node left = head;
        Node right = tail;

        while (left != null && right != null) {

            if (left.data != right.data) {
                return false;
            }

            if (left == right || left.next == right) {
                break;
            }

            left = left.next;
            right = right.prev;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            insert(str.charAt(i));
        }

        if (isPalindrome()) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        sc.close();
    }
}