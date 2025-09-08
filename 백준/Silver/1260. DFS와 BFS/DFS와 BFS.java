import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for(int i = 1; i <= n; i++){
            Collections.sort(A[i]);
        }
        visited = new boolean[n+1];
        DFS(start);
        System.out.println();
        visited = new boolean[n+1];
        BFS(start);
        System.out.println();
    }

    private static void DFS(int Node){
        System.out.print(Node+" ");
        visited[Node] = true;
        for(int i : A[Node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    private static void BFS(int Node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(Node);
        visited[Node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int nxt : A[cur]){
                if(!visited[nxt]){
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
