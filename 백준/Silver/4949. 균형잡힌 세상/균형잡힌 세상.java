import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean ok = true;

            for (char ch : line.toCharArray()) {
                if (!ok) break; // 이미 실패면 더 안 봐도 됨
                switch (ch) {
                    case '(':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') ok = false;
                        else stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') ok = false;
                        else stack.pop();
                        break;
                    default:
                }
            }
            System.out.println(ok && stack.isEmpty() ? "yes" : "no");
        }
    }
}
