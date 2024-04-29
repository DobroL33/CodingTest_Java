import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<attacks.length; i++) {
			map.put(attacks[i][0], attacks[i][1]);
		}
		
		// 몬스터 공격 마지막 시간이 중요
        int atk = 0;
		int last = attacks[attacks.length-1][0];
		int max = health;
		int cnt = 0;
		int time = 0;
		
		while(last>time && health>0) {
            // 피격 관련
            time++;
            if(attacks[atk][0] == time){
                cnt=0;
                atk++;
                health-= map.get(time);
            }
            else{
                if(cnt<bandage[0])health += bandage[1];
                else{
                    health += (bandage[2] + bandage[1] );
                    cnt =0;
                }
                if (health>max) health = max;
                
            }
            cnt++;
        }
            if(health <= 0) return -1;
            else return health;
    }
}