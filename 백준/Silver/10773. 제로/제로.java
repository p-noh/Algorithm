import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int sum = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            }
            else stack.push(n);
        }
        while (!stack.isEmpty()){sum +=  stack.pop();}
        System.out.println(sum);
    }
}
