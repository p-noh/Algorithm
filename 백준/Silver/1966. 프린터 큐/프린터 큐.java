import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nDocs = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<int[]> q = new ArrayDeque<>(); // [index, priority]
            int[] counts = new int[10];          // priority: 1..9

            for (int i = 0; i < nDocs; i++) {
                int pr = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, pr});
                counts[pr]++;
            }

            // 현재 남은 문서들 중 최대 우선순위
            int curMax = 9;
            while (curMax > 0 && counts[curMax] == 0) curMax--;

            int printed = 0;
            while (true) {
                int[] front = q.peek();
                int idx = front[0], pr = front[1];

                if (pr == curMax) {
                    q.poll();
                    printed++;
                    counts[pr]--;

                    if (idx == target) {     // 타깃이면 끝
                        sb.append(printed).append('\n');
                        break;
                    }

                    // 최대값 갱신
                    while (curMax > 0 && counts[curMax] == 0) curMax--;
                } else {
                    q.offer(q.poll());       // 뒤로 회전
                }
            }
        }
        System.out.print(sb);
    }
}
