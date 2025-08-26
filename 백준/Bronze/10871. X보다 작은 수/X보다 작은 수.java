import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int read = 0;

        while (read < n) {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int v = Integer.parseInt(st.nextToken());
            if (v < x) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(v);
            }
            read++;
        }

        System.out.print(sb);
    }
}
