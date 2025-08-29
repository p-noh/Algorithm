import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String cmd =  br.readLine();
            if(cmd.startsWith("push")){
                int x = Integer.parseInt(cmd.substring(5));
                q.addLast(x);
            }
            else if(cmd.equals("pop")){
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.pollFirst()).append("\n");
            }
            else if(cmd.equals("size")){
                sb.append(q.size()).append("\n");
            }
            else if(cmd.equals("empty")){
                sb.append(q.isEmpty()? 1: 0).append("\n");
            }
            else if(cmd.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else
                    sb.append(q.peekFirst()).append("\n");
            }
            else if(cmd.equals("back")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else
                    sb.append(q.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
