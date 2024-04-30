import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 횟수
		int Num = sc.nextInt(); // 금액
		
		int []change = new int [T]; // 나눠줄 금액들
		
		for(int tc=T-1; tc>=0; tc--) {
			change[tc] = sc.nextInt();			
		}
		int cnt=0;
		for(int i=0; i<T; i++) {
			cnt += Num / change[i];
			Num = Num % change[i];
		}
		System.out.println(cnt);
	}
}
