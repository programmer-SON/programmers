package rankSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static HashMap<String, ArrayList<Integer>> map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String info[] = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String que[] = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		int[] ans = solution(info, que);
		for(int n : ans) {
			System.out.println(n);
		}
	}
	
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();      
        
        setMap();
        setScore(info);
        
        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
        	Collections.sort(entry.getValue());
        }
        
        
        for(int i=0; i<query.length;i++) {
        	String[] strs = query[i].split(" ");
        	
        	ArrayList<Integer> list = map.get(strs[0]+strs[2]+strs[4]+strs[6]);
        	System.out.println(strs[0]+strs[2]+strs[4]+strs[6]);
        	int score = Integer.valueOf(strs[7]);
        	
        	//System.out.println(score);
        	
        	int idx = Collections.binarySearch(list, score);
        	
        	int cnt = 0;
        	if(idx>=0) {
        		//cnt = list.size() - idx > 0 ? list.size()-idx : 0;
        		for(int a=idx-1; a>=0; a--) {
        			if(list.get(idx) - list.get(a) > 0) break;
        			else idx = a;
        		}
        		cnt = list.size()-idx;
        	}else {
        		cnt = list.size() + idx + 1;
        	}
        	
        	answer[i] = cnt;
        }
        
        
        return answer;
    }

    public static void setMap() {
    	String[] lan = {"cpp","java","python","-"};
    	String[] posi = {"backend","frontend","-"};
    	String[] car = {"junior","senior","-"};
    	String[] food = {"chicken", "pizza", "-"};
    	
    	for(int i=0; i<lan.length;i++) {
    		for(int j=0; j<posi.length;j++) {
    			for(int k=0; k<car.length;k++) {
    				for(int l=0;l<food.length;l++) {
    					map.put(lan[i]+posi[j]+car[k]+food[l], new ArrayList<>());
    				}
    			}
    		}
    	}    	
    }
    
    public static void setScore(String token[]) {
    	for(int i=0; i<token.length;i++) {
    		String[] strs = token[i].split(" ");
    		int val = Integer.parseInt(strs[4]);
    		map.get(strs[0]+strs[1]+strs[2]+strs[3]).add(val);
    		map.get(strs[0]+strs[1]+strs[2]+"-").add(val);
    		map.get(strs[0]+strs[1]+"-"+strs[3]).add(val);
    		map.get(strs[0]+"-"+strs[2]+strs[3]).add(val);
    		map.get("-"+strs[1]+strs[2]+strs[3]).add(val);
    		
    		map.get(strs[0]+strs[1]+"-"+"-").add(val);
    		map.get(strs[0]+"-"+strs[2]+"-").add(val);
    		map.get("-"+strs[1]+strs[2]+"-").add(val);
    		map.get(strs[0]+"-"+"-"+strs[3]).add(val);
    		map.get("-"+strs[1]+"-"+strs[3]).add(val);
    		map.get("-"+"-"+strs[2]+strs[3]).add(val);
    		
    		map.get(strs[0]+"-"+"-"+"-").add(val);
    		map.get("-"+strs[1]+"-"+"-").add(val);
    		map.get("-"+"-"+"-"+strs[3]).add(val);
    		map.get("-"+"-"+strs[2]+"-").add(val);
    		
    		map.get("-"+"-"+"-"+"-").add(val);
    		
    	}
    }
}
