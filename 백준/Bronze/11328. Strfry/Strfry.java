import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i= 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if (str1.length() != str2.length()) {
                sb.append("Impossible\n");
                continue;
            }
            int[] cnt = new int[26];
            for(int j=0;j<str1.length();j++) {
                cnt[str1.charAt(j)-'a']++;
                cnt[str2.charAt(j)-'a']--;
            }
            boolean isOk = true;
            for(int x : cnt){
                if (x != 0){
                    isOk = false;
                    break;
                }
            }
            sb.append(isOk? "Possible\n":"Impossible\n");
        }
        System.out.println(sb);
    }
}
