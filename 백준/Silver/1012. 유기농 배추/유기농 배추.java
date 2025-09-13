import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, m, n, k;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    static void BFS(Queue<int[]> q, int[][] map, int[][] visited) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int r = cur[0] + dr[i];
                int c = cur[1] + dc[i];
                if(r<0||c<0||r>=n||c>=m) continue;
                if(map[r][c]==0) continue;
                if(visited[r][c]!=0) continue;
                q.add(new int[] {r, c});
                visited[r][c]=1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            int[][] visited = new int[n][m];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            Queue<int[]> q = new ArrayDeque<>();
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1 && visited[i][j] == 0){
                        q.offer(new int[]{i, j});
                        visited[i][j] = 1;
                        cnt++;
                        BFS(q, map, visited);
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
