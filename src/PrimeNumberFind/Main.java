package PrimeNumberFind;

import java.util.HashSet;

public class Main {

	static boolean visiPrim[];
	static boolean visited[];
	static HashSet<Integer> hs;
	static int answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "011";
		String s1 = str.substring(0,0);
		String s2 = str.substring(1,3);
		System.out.println(s2);
		System.out.println(solution(str));
	}
	
    public static int solution(String numbers) {
        answer = 0;
        visiPrim = new boolean[10000000];
        visited = new boolean[numbers.length()];
        hs = new HashSet<>();
        visiPrim[0] = visiPrim[1] = true;
        
        EraTos();
        DFS(numbers,0,0);
        
        return answer;
    }
    
    public static void DFS(String nums,int idx,int tar) {
    	if(!visiPrim[tar] && !hs.contains(tar)) {
    		answer++;
    		hs.add(tar);
    	}
    	
    	if(nums.length() == idx) {
    		return;
    	}    	
    	
    	for(int i=0; i<nums.length();i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			DFS(nums, idx+1, tar * 10 + (nums.charAt(i) - '0'));
    			visited[i] = false;
    		}
    	}
    	
    }
    
    public static void EraTos() {
    	
    	for(int i=2;i<=9999999;i++) {
    		if(!visiPrim[i]) {
    			for(int j=i*2; j<=9999999; j+=i ) {
    				visiPrim[j] = true;
    			}
    		}
    	}    	
    }
}
