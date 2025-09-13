import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] normal = new char[n][n];
        char[][] colorWeak = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] color = br.readLine().toCharArray();
            normal[i] = color.clone();
            for (int j = 0; j < n; j++) {
                colorWeak[i][j] = (color[j] == 'G') ? 'R' : color[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bfs(normal)).append(" ");
        sb.append(bfs(colorWeak));
        System.out.println(sb);
    }

    static int bfs(char[][] board) {
        final int l = board.length;

        boolean[][] visited = new boolean[l][l];
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                cnt++;
                q.offer(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];

                    for (int d = 0; d < 4; d++){
                        int nx = x + dx[d], ny = y + dy[d];
                        if(nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                        if (visited[nx][ny] || board[nx][ny] != board[x][y]) continue;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return cnt;
    }
}

