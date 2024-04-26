import java.io.*;
import java.util.*;

public class Main {	
    static int R, C, distance;
    static char[][] map;
    static int[][] check;
    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
    	
    	Scanner sc= new Scanner(System.in);

    	R = sc.nextInt();
    	C = sc.nextInt();

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = sc.next().toCharArray();
        }        

        distance = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    distance = Math.max(distance, BFS(i, j));
                }
            }
        }

        System.out.println(distance);

    }


    static int BFS(int r, int c) {

        check = new int[R][C];

        int d = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        check[r][c] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            d = Math.max(d, check[now[0]][now[1]]);

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (map[nr][nc] == 'W' || check[nr][nc] != 0) {
                    continue;
                }

                check[nr][nc] = check[now[0]][now[1]] + 1;
                queue.add(new int[] { nr, nc });

            }
        }

        return d-1;
    }

}