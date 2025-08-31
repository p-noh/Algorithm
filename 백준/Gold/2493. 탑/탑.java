import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) h[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장 스택
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && h[i] > h[stack.peek()]){
                stack.pop();
            }
            sb.append(stack.isEmpty()? 0 : (stack.peek() + 1));
            if (i < n - 1) sb.append(" ");
            stack.push(i);
        }
        System.out.print(sb.toString());
    }
}
