import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        int idx = pattern.indexOf('*');
        String front = pattern.substring(0, idx);
        String back = pattern.substring(idx + 1);

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String str = br.readLine();

            if(str.length() < front.length() + back.length()) {
                sb.append("NE\n");
                continue;
            }
            boolean ok = str.startsWith(front) && str.endsWith(back);
            sb.append(ok ? "DA\n" : "NE\n");
        }
        System.out.println(sb);

    }
}
