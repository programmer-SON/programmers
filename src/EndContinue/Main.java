package EndContinue;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int idx = 1;
        int personIdx = 2;
        int turn = 1;
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        //char start = temp.charAt(temp.length()-1);
        char endWord = words[0].charAt(words[0].length()-1);
       
        while(idx<words.length) {
        	char startWord = words[idx].charAt(0);
        	
        	if(startWord != endWord || set.contains(words[idx])) {
        		answer[0] = personIdx;
        		answer[1] = turn;
        		break;        	
        	}
        	
        	endWord = words[idx].charAt(words[idx].length()-1);;
        	set.add(words[idx]);
        	
        	if(personIdx+1 > n ) {
        		personIdx = 0;
        		turn++;
        	}
        	personIdx++;
        	idx++;
        }
        
        

        return answer;
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		String w[] = {
				"tank", "kick", 
				"know", "wheel", 
				"land", "dream", 
				"mother", "robot", 
				"tank"
		};
		sol.solution(n, w);
	}

}
