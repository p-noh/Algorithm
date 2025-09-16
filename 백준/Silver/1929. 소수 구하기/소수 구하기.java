import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int i) {
        if(i == 1) return false;
        for (int j = 2; j*j <= i; j++) {
            if(i%j==0) return false;
        }
        return true;
    }
}

