import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a =  Integer.parseInt(br.readLine());
        int b =  Integer.parseInt(br.readLine());
        int c =  Integer.parseInt(br.readLine());

        int[] cnt = new int[10];
        int mul = a * b * c;
        while(mul > 0){
            cnt[mul%10]++;
            mul /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : cnt) sb.append(x).append('\n');
        System.out.print(sb);
    }
}