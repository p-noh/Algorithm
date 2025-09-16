import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(m, n, x, y)).append("\n");
        }
        System.out.print(sb);
    }

    private static int solve(int m, int n, int x, int y) {
        if(x == 1 && y == 1) return 1;
        if(m == x) x = 0;
        if(n == y) y = 0;

        int lcm = lcm(m, n);
        for(int i = x; i <= lcm; i+=m){
            if (i == 0) continue;
            if (i % n == y)
                return i;
        }
        return -1;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
}
