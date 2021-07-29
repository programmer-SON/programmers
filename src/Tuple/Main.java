package Tuple;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "{{2,1,3},{2},{2,1},{2,1,3,4}}";
		/*System.out.println(str.replaceAll("[{}]", ""));
		
		String[] tmp = str.replaceAll("[{}]", " ").trim().split(" ,");
		//System.out.println(str.replaceAll("[{}]", " ").trim().split(" ,"));
		for(String s : tmp) {
			System.out.println(s);
		}
		System.out.println();
		Arrays.sort(tmp, (a,b)->(a.length()-b.length()));
		
		for(String s : tmp) {
			System.out.println(s);
		}*/
		
		int arrs[] = solution(str);
		for(int n : arrs) {
			System.out.println(n);
		}
		
	}
    public static int[] solution(String s) {
        int[] answer;
        String strs[] = s.replaceAll("[{}]", " ").trim().split(" ,");
        answer = new int[strs.length];
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(strs,(a,b)->(a.length() - b.length()));
        int i = 0;
        
        for(String str : strs) {
        	for(String st : str.split(",")) {
        		int num = Integer.parseInt(st.trim());
        		if(hs.contains(num)) {
        			continue;
        		}
        		hs.add(num);
        		answer[i++] = num;
        	}
        }
        
        
        return answer;
    }

}
