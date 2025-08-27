import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x =  Integer.parseInt(br.readLine());

        boolean[] seen = new boolean[1000001];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int v = Integer.parseInt(st.nextToken());
            int check = x - v;

            if (1<= check && check <= 1000001 &&  seen[check]){
                cnt++;
            }
            seen[v] = true;
        }
        System.out.println(cnt);
    }
}