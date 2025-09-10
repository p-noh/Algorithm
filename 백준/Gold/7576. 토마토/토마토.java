import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] tomato;
    static int[][] days;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class T {
        int row;
        int col;
        public T(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];
        days = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                days[i][j] = -1;
            }
        }

        Queue<T> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tomato[i][j] == 1) {
                    q.offer(new T(i, j));
                    days[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()) {
            T curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];
                if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
                if(tomato[nextRow][nextCol] == -1) continue;
                if(days[nextRow][nextCol] != -1) continue;
                if(tomato[nextRow][nextCol] == 0) {
                    days[nextRow][nextCol] = days[curr.row][curr.col] + 1;
                    q.offer(new T(nextRow, nextCol));
                }
            }
        }

        int maxDay = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxDay = Math.max(days[i][j], maxDay);
                if(tomato[i][j] == 0 && days[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDay);

    }

    private static boolean checkInBox(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
