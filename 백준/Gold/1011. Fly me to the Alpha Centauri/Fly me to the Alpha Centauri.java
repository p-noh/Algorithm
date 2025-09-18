import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = y - x;
            int k = (int)Math.sqrt(d);
            if (k*k == d) sb.append(2*k - 1).append("\n");
            else if (d <= k * k + k) sb.append(2 * k).append("\n");
            else sb.append(2*k+1).append("\n");
        }
        System.out.println(sb);
    }
}
