import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int numOfPaper;
        int target;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            numOfPaper = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Integer> idxQ = new ArrayDeque<>();
            Queue<Integer> prQ = new ArrayDeque<>();

            int max = 0;
            int cnt = 0;
            for (int j = 0; j < numOfPaper; j++) {
                int pr = Integer.parseInt(st.nextToken());
                idxQ.offer(j);
                prQ.offer(pr);
                if (pr > max) max = pr;
            }
            while (true) {
                if (prQ.peek() == max) {
                    prQ.poll();
                    int idx = idxQ.poll();
                    cnt++;
                    if (idx == target) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    int newMax = 0;
                    for (int pr : prQ) newMax = Math.max(newMax, pr);
                    max = newMax;
                } else {
                    prQ.offer(prQ.poll());
                    idxQ.offer(idxQ.poll());
                }
            }
        }
        System.out.println(sb.toString());
    }
}
