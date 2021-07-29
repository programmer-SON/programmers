package SkillTree;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++) {
        	String trees = skill_trees[i];
        	String word[] = trees.split("");
        	int cnt = 0;
        	boolean flag = true;
        	
        	for(int j=0; j<word.length;j++) {
        		if(cnt < skill.indexOf(word[j])) {
        			flag = false;
        			break;
        		}else if(cnt == skill.indexOf(word[j])) {
        			cnt++;
        		}
        	}
        	
        	if(flag) answer++;
        }
        
        

        
        return answer;        
    }
}



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
