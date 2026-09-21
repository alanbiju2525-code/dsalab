import java.util.Scanner;

public class stack_array {

    static int[] stack;
    static int top = -1;
    static int size;

    static void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--] + " popped from stack.");
        }
    }

    static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        size = sc.nextInt();

        stack = new int[size];

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}