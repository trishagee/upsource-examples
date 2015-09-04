package ds;

public class QueueClient {


    public static void main(String [] args) {
        String data = "ABC-DEF--XYZ-";
        int len = data.length();
        Queue<String> queue = new Queue<>();

        for (int i=0; i<len; i++) {
            String key = String.valueOf(data.charAt(i));
            if (!key.equals("-")) {
                queue.enqueue(key);
                System.out.println("Enqueued: " + key);
            } else {
                System.out.println("Removed: " + queue.dequeue());
            }
        }
        System.out.println("Items in Queue");
        for (String s: queue) {
            System.out.print(s + " -> ");
        }
        System.out.println("null");
    }
}
