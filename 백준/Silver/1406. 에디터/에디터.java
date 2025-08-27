import java.util.LinkedList;
import java.io.*;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> list = new LinkedList<>();
        String str =  br.readLine();
        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> cursor = list.listIterator(list.size());

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String cmd = br.readLine();
            switch (cmd.charAt(0)){
                case 'L' :
                    // 왼쪽 한칸 이동
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case 'D' :
                    // 오른쪽 한칸 이동
                    if (cursor.hasNext()) cursor.next();
                    break;
                case 'B' :
                    // 왼쪽 한글자 지우기
                    if (cursor.hasPrevious()){
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P' :
                    // 해당 위치 문자 삽입
                    cursor.add(cmd.charAt(2));
                    break;

            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        System.out.println(sb.toString());
    }
}