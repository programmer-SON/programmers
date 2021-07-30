package Baduser;

import java.util.HashSet;
import java.util.Arrays;

class Solution {
    
    boolean uiVisited[];
    String store[];
    HashSet<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        uiVisited = new boolean[user_id.length];
        store = new String[banned_id.length];
        set = new HashSet<>();
        
        DFS(0,0,user_id, banned_id);
        return set.size();
    }
    
    public boolean WordCheck(String u, String b){
        if(u.length() != b.length()) return false;
        
        for(int i=0; i<u.length();i++){
            if(u.charAt(i) != b.charAt(i) && b.charAt(i) != '*') return false;
        }
        
        return true;
    }
    
    public String sortAns(){
       String[] temp = new String[store.length];
       String str = "";
        for(int i=0; i<store.length;i++){
            temp[i] = store[i];
        }
        
        Arrays.sort(temp);
                
        for(int i=0; i< store.length;i++){
             str += temp[i];
        }
        return str;
    }
    
    public void DFS(int biIdx, int n, String[] ui, String[] bi){
        if(n == bi.length){
            String str = sortAns();
            if(!set.contains(str)){
                set.add(str);
            }
            return;
        }
        
         for(int i=biIdx; i<bi.length;i++){
           for(int j=0; j<ui.length;j++){
           
               if(!uiVisited[j] && WordCheck(ui[j], bi[i])){
                   store[n] = ui[j];
                   uiVisited[j] = true;
                   DFS(i+1,n+1, ui, bi);
                   uiVisited[j] = false;
               }
           }
        }
    }
}
