import java.util.*;

class Road{
    int x,y,cost,dir;
    
    Road(int x, int y, int cost, int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;        
    }
}


class Solution {
    
    int dirX[] = {0,0,1,-1};
    int dirY[] = {1,-1,0,0};
    int ans = Integer.MAX_VALUE;
    int costMap[][];
    
    public int solution(int[][] board) {
        //int answer = 0;
        costMap = new int[board.length][board.length];
        for(int i=0; i<board.length;i++){
            Arrays.fill(costMap[i],Integer.MAX_VALUE);
        }
        
        BFS(board);
        return ans;
    }
    
    public void BFS(int[][] board){
        Queue<Road> que = new LinkedList<>();
        que.add(new Road(0,0,0,-1));
        
        while(!que.isEmpty()){
            Road r = que.poll();
            
            if(r.x == board.length-1 && r.y == board.length-1){
                ans = Math.min(ans,r.cost);
                continue;
            }
            
            for(int d=0; d<4;d++){
                int dx = dirX[d] + r.x;
                int dy = dirY[d] + r.y;
                int cost = 0;
                if(dx < 0 || dx >= board.length || dy < 0 || dy >= board.length || board[dx][dy] == 1) continue;
                
                if(r.dir == -1 || r.dir == d){
                    cost = r.cost + 100;
                }else{
                    cost = r.cost + 600;
                }
                
                if(costMap[dx][dy] >= cost){
                    costMap[dx][dy] = cost;
                    que.add(new Road(dx,dy,cost,d));
                }
            }           
        }
    }
}
