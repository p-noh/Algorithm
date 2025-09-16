import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] num = new boolean[n+1];
        Arrays.fill(num, true);
        if(1 <= n){
            num[0] = false;
            num[1] = false;
        }
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            for(int j = i; j <= n; j+=i){
                if(num[j] == true){
                    num[j] = false;
                    cnt++;
                }
                if(cnt == m){
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
