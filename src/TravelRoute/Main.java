import java.util.Collections;
import java.util.ArrayList;

class Solution {
    
    boolean visited[];
    ArrayList<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length]; 
        
        DFS("ICN","ICN",tickets,0);
        Collections.sort(answers);
        
        return answers.get(0).split(" ");
    }
    
    public void DFS(String start,String answer ,String[][] ti, int count){
 
        if(count == ti.length){
            answers.add(answer);
            return;
        }
        
        for(int i=0; i<ti.length;i++){
            if(!visited[i] && start.equals(ti[i][0])){
                visited[i] = true;
                DFS(ti[i][1], answer + " " + ti[i][1],ti,count+1);
                visited[i] = false;
            }
        }
        
    }
}