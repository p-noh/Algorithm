import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] box;
    static int[][] days;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static final class Pos {
        final int r, c;
        Pos(int r, int c) { this.r = r; this.c = c; }
    }

    static boolean in(int r, int c) { return 0 <= r && r < n && 0 <= c && c < m; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        days = new int[n][m];

        Queue<Pos> q = new ArrayDeque<>();
        int unripe = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(days[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new Pos(i, j));
                    days[i][j] = 0;
                } else if (box[i][j] == 0) {
                    unripe++;
                }
            }
        }

        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        int maxDay = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dx[d], nc = cur.c + dy[d];
                if (!in(nr, nc)) continue;
                if (days[nr][nc] != -1) continue;
                if (box[nr][nc] != 0) continue;

                days[nr][nc] = days[cur.r][cur.c] + 1;
                maxDay = Math.max(maxDay, days[nr][nc]);
                box[nr][nc] = 1;
                unripe--;
                q.offer(new Pos(nr, nc));
            }
        }

        System.out.println(unripe > 0 ? -1 : maxDay);
    }
}
