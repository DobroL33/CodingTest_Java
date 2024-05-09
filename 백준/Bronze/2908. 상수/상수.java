import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int Num=0, tmp=0, cnt=0;
    	for(int i=0; i<2; i++) {
    		StringBuilder sb = new StringBuilder();
    		String[] str = sc.next().split("");
    		
    		for(int j=0;j<3;j++) {
    			sb = sb.append(str[2-j]);
    		}    		
    		Num = Integer.valueOf(sb.toString());    		
    		if(Num>tmp) 
    			tmp=Num;
    	}    
		if(Num>tmp) 
			System.out.println(Num);	
		else 
			System.out.println(tmp);
    }
}