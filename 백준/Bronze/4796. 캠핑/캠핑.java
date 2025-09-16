import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int l, p, v;
        for(int i = 1; ; i++){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if(l == 0 && p == 0 && v == 0) break;
            int full = (v / p) * l;
            int rest = Math.min(l, v % p);
            sb.append("Case ").append(i).append(": ").append(full + rest).append('\n');
        }
        System.out.println(sb);
    }
}
