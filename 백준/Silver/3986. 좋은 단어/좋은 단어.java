import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        String str;
        int cnt = 0;
        Deque<Character> stack;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            stack = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == str.charAt(j))
                    stack.pop();
                else
                    stack.push(str.charAt(j));
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
