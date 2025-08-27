import java.util.LinkedList;
import java.io.*;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        LinkedList<Integer> list = new LinkedList();
        for(int i = 1; i <= n; i++) list.add(i);

        ListIterator<Integer> iterator = list.listIterator();

        while(!list.isEmpty()) {
            for(int i = 0; i < k; i++) {
                if (!iterator.hasNext())
                    iterator = list.listIterator();
                iterator.next();
            }
            int target = iterator.previous();
            iterator.next();
            iterator.remove();
            sb.append(target);
            if (!list.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}