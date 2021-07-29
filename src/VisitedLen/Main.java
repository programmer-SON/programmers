package VisitedLen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Coor{
	int tmpX,tmpY,x,y;
	
	public Coor(int tmpX, int tmpY,int x,int y){
		this.tmpX = tmpX;
		this.tmpY = tmpY;
		this.x = x;
		this.y = y;
	}	

}


class Solution {
    
	int dirX[] = {-1,1,0,0};
	int dirY[] = {0,0,1,-1};
	boolean visited[][][][];
	
	public int solution(String dirs) {
        int answer = 0;
        int x = 5, y=5;
        //Set<Coor> set = new HashSet<>();
        
        visited = new boolean[11][11][11][11];
        
        for(int i=0; i<dirs.length();i++) {
        	char d = dirs.charAt(i);
        	int tmpX = x, tmpY = y;
        	
        	if(d == 'U') {
        		x += dirX[0]; y+=dirY[0];
        	}else if(d == 'D') {
        		x += dirX[1]; y+=dirY[1];
        	}else if(d == 'R') {
        		x += dirX[2]; y+=dirY[2];
        	}else {
        		x += dirX[3]; y+=dirY[3];
        	}
        	
        	if(x < 0 || y < 0 || x>=11 || y>=11) {
        		x = tmpX; y = tmpY;
        	}else if(!visited[tmpX][tmpY][x][y]) {
        		visited[tmpX][tmpY][x][y] = true;
        		visited[x][y][tmpX][tmpY] = true;
        		answer++;
        	}
        	
        	/*else if(!set.contains(new Coor(tmpX,tmpY,x,y))) {
        		set.add(new Coor(tmpX,tmpY,x,y));
        		set.add(new Coor(x,y,tmpX,tmpY));
        		answer++;
        	}*/
        }
        
        return answer;
    
	}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.solution("ULURRDLLU"));
	}

}
