import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push_front")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                dq.addFirst(x);
            }
            else if (cmd.startsWith("push_back")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                dq.addLast(x);
            }
            else if (cmd.equals("pop_front")) {
                sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
            }
            else if (cmd.equals("pop_back")) {
                sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
            }
            else if (cmd.equals("size")) {
                sb.append(dq.size()).append('\n');
            }
            else if (cmd.equals("empty")) {
                sb.append(dq.isEmpty() ? 1 : 0).append('\n');
            }
            else if (cmd.equals("front")) {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
            }
            else if (cmd.equals("back")) {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
