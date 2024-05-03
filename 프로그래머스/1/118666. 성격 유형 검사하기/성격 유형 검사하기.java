import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String[]sample = {"RT", "CF", "JM", "AN"};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<sample.length; i++) {
        	map.put(sample[i],4);
        }
        
        for(int i=0; i<survey.length; i++) {
 
        	// AN인지 NA인지 구분해서 점수를 매기기, 다르면 반대로 점수 매겨주기
        	String origin = survey[i];
        	String[] str = survey[i].split("");
        	Arrays.sort(str);
        	String copy = str[0]+str[1];        	
        	
            if (origin.equals(copy)) {
                int value = 4-choices[i];
                int cur = map.containsKey(origin) ? map.get(origin) : 0;
                map.put(origin, cur += value);
            } else {
                int value = choices[i]-4;
                int cur = map.containsKey(copy) ? map.get(copy) : 0;
                map.put(copy, cur += value);
            }
        	
        }   
        String answer = "";
        for (int i = 0; i < 4; i++) {
            String[] str = sample[i].split("");
            if (map.get(sample[i]) >= 4) {
                answer += str[0];
            } else {
                answer += str[1];
            }
        }
        return answer;
    }
}