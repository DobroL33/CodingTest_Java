import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int Num = sc.nextInt();
		for (int i=1; i<=Num; i++) {
			q.offer(i);
			
		}
		while(q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}
