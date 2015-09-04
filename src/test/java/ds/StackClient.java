package ds;

public class StackClient {

    public static void main(String [] args) {
        String data = "ABC-DEF--XYZ";
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < data.length(); i++) {
            String key = String.valueOf(data.charAt(i));
            if (!key.equals("-")) {
                stack.push(key);
                System.out.println("pushed: " + key);
            } else {
                System.out.println("popped: " + stack.pop());
            }
        }
        System.out.println("final items on stack");
        for (String s: stack) {
            System.out.print(s + " -> ");
        }
        System.out.println("null");
    }
}

