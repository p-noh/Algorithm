import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int[] alphabet = new int[26]; // 등장 횟수 저장은 int가 좋아요
        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alphabet.length; i++){
            sb.append(alphabet[i]).append(" ");
        }
        
        System.out.print(sb.toString().trim());
    }
}
