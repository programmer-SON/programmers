import java.util.ArrayList;

class Solution {
    
    ArrayList<Character> oper = new ArrayList<>();
    ArrayList<Long> nums = new ArrayList<>();
    
    char operation[] = {'+','-','*'};
    int idxArr[] = new int[3];
    boolean visited[] = new boolean[3];
    
    long ans = 0;
    
    public long solution(String expression) {
        long answer = 0;
        
        String longStr = "";
        for(int i=0; i<expression.length();i++){
            char ep = expression.charAt(i);
            if(ep == '+' || ep == '-' || ep == '*'){
                oper.add(ep);
                nums.add(Long.parseLong(longStr));
                longStr="";
            }else{
                longStr += ep;
            }
        }
        
        nums.add(Long.parseLong(longStr));
        
        
        DFS(0);
        
        return ans;
    }    

    
    public void DFS(int n){
        if(n==3){
            Cal();
            return;
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                idxArr[n] = i;
                DFS(n+1);
                visited[i] = false;
            }
        }
    }
    
    public void Cal(){
       ArrayList<Character> op = new ArrayList<>();
       ArrayList<Long> num = new ArrayList<>();
       op.addAll(oper);
       num.addAll(nums); 
        
       for(int k=0; k<3;k++){
           char ch = operation[idxArr[k]];
           
           for(int i=0; i<op.size();i++){
                if(op.get(i) == ch){
                   long x = num.get(i);
                   long y = num.get(i+1);
                   long r = Result(x,y,ch);
                   num.remove(i);
                   num.remove(i);
                   op.remove(i);
                   num.add(i,r);
                   i--; 
                }
           }
       }
        
       ans = Math.max(ans, Math.abs(num.get(0))); 
    }
    
    public long Result(long x, long y, char ch){
        
        switch(ch){
            case '+' : return x+y;
            case '-' : return x-y;
        }
        return x*y;
    }
}