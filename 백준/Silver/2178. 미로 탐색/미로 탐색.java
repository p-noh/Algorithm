import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        if (map[0][0] == 0) return -1; //
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) return dist[cur.x][cur.y]; // 조기 종료

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (!inBound(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;
                if (dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        return -1;
    }

    static boolean inBound(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
