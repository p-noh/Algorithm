import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // 나이트 이동
        int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
        int[] dy = { 1,  2, -1, -2, 2, 1,-2,-1};

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            if (sx == tx && sy == ty) { // 시작=목표
                sb.append(0).append('\n');
                continue;
            }

            int[][] dist = new int[l][l];
            for (int i = 0; i < l; i++) Arrays.fill(dist[i], -1);

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sx, sy});
            dist[sx][sy] = 0;

            Q : while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                    if (dist[nx][ny] != -1) continue;

                    dist[nx][ny] = dist[x][y] + 1;  // 방문&거리 갱신 먼저
                    if (nx == tx && ny == ty) {
                        sb.append(dist[nx][ny]).append('\n');
                        break Q; // while 탈출
                    }
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.print(sb);
    }
}
