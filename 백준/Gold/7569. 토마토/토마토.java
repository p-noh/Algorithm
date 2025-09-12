import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;                 // m: cols(x), n: rows(y), h: height(z)
    static int[][][] box;               // [z][y][x]
    static int[][][] dist;              // [z][y][x]
    static final int[] dx = {1, -1, 0, 0, 0, 0};
    static final int[] dy = {0, 0, 1, -1, 0, 0};
    static final int[] dz = {0, 0, 0, 0, 1, -1};

    static boolean inBox(int x, int y, int z) {
        return 0 <= x && x < m && 0 <= y && y < n && 0 <= z && z < h;
    }

    static int BFS(Queue<int[]> q, int cnt) {
        int max = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();        // {z, y, x}
            int z = cur[0], y = cur[1], x = cur[2];

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if (!inBox(nx, ny, nz)) continue;
                if (box[nz][ny][nx] == -1) continue; // 토마토 없음
                if (dist[nz][ny][nx] != -1) continue;

                dist[nz][ny][nx] = dist[z][y][x] + 1;
                //box[nz][ny][nx] = 1;                  // 익음으로 갱신
                cnt--;
                max = Math.max(max, dist[nz][ny][nx]);
                q.offer(new int[]{nz, ny, nx});
            }
        }
        return (cnt == 0) ? max : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y
        h = Integer.parseInt(st.nextToken()); // z

        box  = new int[h][n][m];  // [z][y][x]
        dist = new int[h][n][m];

        int cnt = 0; // 안 익은 토마토 개수
        Queue<int[]> q = new ArrayDeque<>();

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    dist[z][y][x] = -1;

                    if (box[z][y][x] == 1) {
                        dist[z][y][x] = 0;
                        q.offer(new int[]{z, y, x});
                    } else if (box[z][y][x] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(BFS(q, cnt));
    }
}
