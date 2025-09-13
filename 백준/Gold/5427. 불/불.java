import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireT;
    static int[][] escapeT;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map     = new char[h][w];
            fireT   = new int[h][w];
            escapeT = new int[h][w];

            Queue<int[]> fq = new ArrayDeque<>();
            Queue<int[]> eq = new ArrayDeque<>();

            for (int r = 0; r < h; r++) {
                char[] line = br.readLine().toCharArray();
                for (int c = 0; c < w; c++) {
                    char ch = line[c];
                    map[r][c] = ch;
                    if (ch == '*') {
                        fireT[r][c] = 1;
                        fq.offer(new int[]{r, c});
                    } else if (ch == '@') {
                        escapeT[r][c] = 1;
                        eq.offer(new int[]{r, c});
                    }
                }
            }

            fireBfs(fq);
            int ans = escapeBfs(eq);
            sb.append(ans == -1 ? "IMPOSSIBLE" : ans).append('\n');
        }
        System.out.print(sb);
    }

    static void fireBfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (map[nr][nc] == '#') continue;
                if (fireT[nr][nc] != 0) continue;

                fireT[nr][nc] = fireT[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }

    static int escapeBfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int curTime = escapeT[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    return curTime;
                }

                if (map[nr][nc] == '#') continue;
                if (escapeT[nr][nc] != 0) continue;

                int nextTime = curTime + 1;

                if (fireT[nr][nc] != 0 && fireT[nr][nc] <= nextTime) continue;

                escapeT[nr][nc] = nextTime;
                q.offer(new int[]{nr, nc});
            }
        }
        return -1;
    }
}
