import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        int cnt = 0;
        for (int target : targets) {
            int idx = 0;
            for (int num : dq) {
                if (num == target) break;
                idx++;
            }

            if (idx <= dq.size() / 2) {
                while (dq.peekFirst() != target) {
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
            } else {
                while (dq.peekFirst() != target) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            }
            dq.pollFirst(); // 타겟 제거
        }

        System.out.println(cnt);
    }
}
