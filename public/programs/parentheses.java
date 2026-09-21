import java.util.Scanner;
import java.util.Stack;

public class parentheses {

    static boolean isValid(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String expression = sc.nextLine();

        if (isValid(expression)) {
            System.out.println("Parentheses are valid.");
        } else {
            System.out.println("Parentheses are not valid.");
        }

        sc.close();
    }
}