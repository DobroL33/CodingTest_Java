import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Main {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][] box;
	static int N;
	static int M;
	static int cnt;
	static Queue<tomato> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		q = new LinkedList<tomato>();

		M = sc.nextShort();
		N = sc.nextInt();

		box = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				box[r][c] = sc.nextInt();
				if (box[r][c] == 1) { // 토마토가 있는 지점 (1) 여러개 일수 있음. 전부 담으셈 Q에
					q.add(new tomato(r, c));
				}
			}
		}
		System.out.println(BFS());
	}

	// 헷갈렸던 부분. DFS 쓸 땐, int r, int c를 습관처럼 썼으니 당연히 필요하다 생각했음.
	// 없이 쓰려면 어떻게 해야하나? 아무거나 써서는 안되고, 배웠던 거처럼 queue 에서 뽑아서 써야됨
	// tomato 라는 queue 에서 뽑아서 쓰려면 약자로 쓸 수 있게 만들어주자 ex tomato t ==> 블라블라
	// q.poll 해가지고 뽑아서 쓰고, 그걸 row화, col화 해서 써버리는거. 나머지는
	public static int BFS() {
		while (!q.isEmpty()) {
			tomato t = q.poll();

			int x = t.x;
			int y = t.y;

			for (int d = 0; d < 4; d++) {
				int row = x + dr[d];
				int col = y + dc[d];

				if (col < M && row < N && row >= 0 && col >= 0) {
					if (box[row][col] == 0) {
						q.add(new tomato(row, col));

						// 움직이기 전 값에서 1을 더해줌. 이렇게 계속 더해					
						box[row][col] = box[x][y] + 1;
					}

				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 토마토가 만약 0, 하나라도 0인게 발견이 된다면, 안 익었다면 갈아 엎어
				if (box[i][j] == 0) {
					return -1;
				}

				result = Math.max(result, box[i][j]);
			}
		}
		// 걍 다 익어 있는데요?
		if (result == 1) {
			return 0;
		} else {
			return result - 1;
		}

	}

	static class tomato {
		int x, y;

		public tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}