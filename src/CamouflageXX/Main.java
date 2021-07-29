package CamouflageXX;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length;i++) {
        	if(!map.containsKey(clothes[i][1])) {
        		map.put(clothes[i][1], 1);
        	}else {
        		map.put(clothes[i][1],map.get(clothes[i][1]) + 1);
        	}
        }
        
        for(String key : map.keySet()) {
        	answer *= map.get(key) + 1;
        }
        
        return answer-1;
    }
    
}
