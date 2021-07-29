package PeopleTakePic;

import java.util.HashMap;
import java.util.Map;

public class Main {

	static String[] d;
	static Map<Character, Integer> map;
	static boolean[] visited;
	static int answer;
	static int[] position;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 2;
		String[] datas = {"N~F=0", "R~T>2"};
		
		System.out.println(solution(n,datas));
	}
	
    public static int solution(int n, String[] data) {
        
        d = data;
        answer = 0;
        map = new HashMap<>();
        visited = new boolean[8];
        position = new int[8];
        
        // {A, C, F, J, M, N, R, T}
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
        DFS(0);       
        
        return answer;
    }
    
    public static void DFS(int idx) {
    	if(idx == 8 ) {
    		if(CheckPosition()) {
    			answer++;
    		}
    		return;
    	}
    	
    	
    	for(int i=0; i<8;i++) {
    		if(!visited[i]) {
	    		visited[i] = true;
	    		position[idx] = i;
	    		DFS(idx+1);
	    		visited[i] = false;
    		}
    	}
    }
    
    public static boolean CheckPosition() {
    	
    	int a,b;
    	int difference = 0;
    	int result;
    	char op;
    	
    	for(String str : d) {
    		a = position[map.get(str.charAt(0))];
    		b = position[map.get(str.charAt(2))];
    		op = str.charAt(3);
    		result = str.charAt(4) - '0' + 1;
    		
    		difference = Math.abs(a-b);
    		
    		if(op == '=' && difference != result) {
    			return false;
    		}else if(op == '>' && difference <= result) {
    			return false;
    		}else if(op == '<' && difference >= result) {
    			return false;
    		}    		    		
    	}
    	    	
    	return true;
    }
    
    

}
