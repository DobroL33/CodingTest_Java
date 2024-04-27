import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물 지수 기록하기, 일차원 숫자 배열 => 각 친구들의 String + int 해쉬
        // 선물 기록 비교 배열 만들기, 2차원 숫자 배열, int[][]의 배열, i > j or i==j, 케이스 비교
        // [i][j] > [j][i] => cnt ++, 상대보다 많이 줬다 의미,
        // [i][j] == [j][i], if map.get [0] > map.get[1] => cnt ++, 선물 지수 비교해서 해당 친구보다 높으면 ++
        HashMap<String,Integer>map = new HashMap<>();
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];
        for(int i=0; i<friends.length; i++){
            map.put(friends[i],i);        
        }
        
        for(String str : gifts){        
            String[] cur = str.split(" ");
            // 문장 분리, 선물 준 친구(cur[0])의 선물 지수 ++, 받은 친구(cur[1]) --, 
            index[map.get(cur[0])]++;
            index[map.get(cur[1])]--;
            record[map.get(cur[0])][map.get(cur[1])]++;
        }
        int ans = 0;
        for(int i=0; i<friends.length; i++){
            int cnt = 0;
            for(int j=0; j<friends.length; j++){
                if(i==j) continue;
                // record => i to j > j to i의 기록 비교 및 증가
                if(record[i][j]>record[j][i]) cnt++;
                else if(record[i][j]==record[j][i] && index[i]>index[j]) cnt++;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}