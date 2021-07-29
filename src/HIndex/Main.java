package HIndex;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 0, 6, 1, 5};
		System.out.println(solution(arr));
	}

    public static int solution(int[] citations) {
        int answer = 0;
        
        
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
        	int maxi = citations.length -i;
        	if(citations[i] >= maxi) {
        		answer = maxi;
        		break;
        	}
        }
        
        return answer;
    }
}
