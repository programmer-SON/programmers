package NumberGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;        
        
        Integer ia[] = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer ib[] = Arrays.stream(B).boxed().toArray(Integer[]::new);
        
        Arrays.sort(ia,Collections.reverseOrder());
        Arrays.sort(ib,Collections.reverseOrder());
        
        
        int j=0;
        for(int i=0;i<ia.length;i++) {
        	if(ia[i] < ib[j]) {
        		answer++;
        		j++;
        	}
        }
        
        return answer;
        
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
