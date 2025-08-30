import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            q.addLast(i);
        }
        while (q.size() > 1) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        System.out.println(q.pollFirst());
    }
}
