
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map = new int [25][25]; // 5 to 25 최대가 25라고 !!
	static int[] apart = new int[25*25]; // 단지 카운트는 섬 개수처럼 담아짐, 아파트 개수만 따로 담아줄 배열만 있으면 되는거잖아
	static boolean[][] check = new boolean [25][25];
	static int N;
	static int town = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 하나 배웠다 !!

		map = new int[N][N];
		check = new boolean[N][N];
		

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					town++;
					DFS(i, j);
				}
			}
		}
		Arrays.sort(apart);
		System.out.println(town);

		for (int k = 0; k < apart.length; k++) {
			if (apart[k] == 0) {
			} else {
				System.out.println(apart[k]);
			}
		}

	}

	static void DFS(int r, int c) {

		check[r][c] = true;
		apart[town]++;

		for (int d = 0; d < 4; d++) {

			int row = r + dr[d];
			int col = c + dc[d];

			if (col < N && row < N && row >= 0 && col >= 0) {
				if (map[row][col] == 1 && !check[row][col]) {

					DFS(row, col);
				}
			}
		}
	}
}