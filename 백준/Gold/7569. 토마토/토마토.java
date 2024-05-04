import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Main {

	static int[] dr = { 0, 1, 0, -1, 0, 0 };
	static int[] dc = { -1, 0, 1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[][][] box;
	static int N;
	static int M;
	static int H;
	static int cnt;
	static Queue<tomato> q;

	static class tomato {
		int x, y, z;

		public tomato(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		q = new LinkedList<tomato>();

		M = sc.nextShort();
		N = sc.nextInt();
		H = sc.nextInt();

		box = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					box[i][j][k] = sc.nextInt();

					if (box[i][j][k] == 1) { // 토마토가 있는 지점 (1) 여러개 일수 있음. 전부 담으셈 Q에
						q.add(new tomato(i, j, k));
					}
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
			tomato t = q.poll(); // q 에서 poll해오는 것의 커맨드화

			int x = t.x;
			int y = t.y;
			int z = t.z;

			for (int d = 0; d < 6; d++) {
				int row = x + dr[d];
				int col = y + dc[d];
				int hei = z + dh[d];

				if (col < M && row < N && row >= 0 && col >= 0 && hei>=0 && hei<H) {
					if (box[hei][row][col] == 0) {
						q.add(new tomato(hei, row, col));

						// 움직이기 전 값에서 1을 더해줌. 이렇게 계속 더해
						box[hei][row][col] = box[z][x][y] + 1;
					}

				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						return -1;
					}

					result = Math.max(result, box[i][j][k]);
				}
				// 토마토가 만약 0, 하나라도 0인게 발견이 된다면, 안 익었다면 갈아 엎어

			}
		}
		// 걍 다 익어 있는데요?
		if (result == 1) {
			return 0;
		} else {
			return result - 1;
		}
	}
}