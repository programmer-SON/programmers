package GameMapShortestDist;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = 
			{
					{1,0,1,1,1},
					{1,0,1,0,1},
					{1,0,1,1,1},
					{1,1,1,0,1},
					{0,0,0,0,1}
			};
		System.out.println(solution(maps));
	}
	
    public static int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        answer = BFS(maps);
        
        return answer;
    }

    public static int BFS(int[][] maps) {
    	Queue<Node> que = new LinkedList<>();    	
    	boolean[][] visited = new boolean[N][M];
    	int dirX[] = {0,0,1,-1};
    	int dirY[] = {1,-1,0,0};
    	
    	que.add(new Node(0,0,1));
    	visited[0][0] = true;
    	
    	while(!que.isEmpty()) {
    		Node n = que.poll();
    		
    		if(n.x == N-1 && n.y == M-1) {
    			return n.cost;
    		}
    		
    		for(int i=0; i<4;i++) {
    			int dx = n.x + dirX[i];
    			int dy = n.y + dirY[i];
    			int cost = n.cost;
    			
    			if(dx < 0 || dx >= N || dy < 0 || dy >= M || visited[dx][dy] || maps[dx][dy] == 0) {
    				continue;
    			}
    			
    			que.add(new Node(dx,dy,cost+1));
    			visited[dx][dy] = true;
    		}
    	}
    	
    	return -1;
    }   
}

class Node{
	int x,y,cost;
	Node(int x,int y,int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

