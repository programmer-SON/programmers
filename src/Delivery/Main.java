package Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int vertex, dist;

	Node(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node target) {
		// TODO Auto-generated method stub
		return this.dist > target.dist ? 1 : -1;
	}

}

class Solution {
	List<Node> map[];
	int time[];

	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		map = new ArrayList[N + 1];
		time = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
			time[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < road.length; i++) {
			int start = road[i][0];
			int next = road[i][1];
			int dist = road[i][2];
			map[start].add(new Node(next, dist));
			map[next].add(new Node(start, dist));
		}

		Dijkstra(1);

		for (int i = 1; i <= N; i++) {
			if (time[i] <= K)
				answer++;
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(time[i]);
		}

		return answer;
	}

	void Dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		time[start] = 0;

		while (!pq.isEmpty()) {
			int current = pq.peek().vertex;
			int curTime = pq.poll().dist;

			if (time[current] < curTime)
				continue;

			for (int i = 0; i < map[current].size(); i++) {
				int next = map[current].get(i).vertex;
				int nextTime = map[current].get(i).dist + curTime;

				if (time[next] > nextTime) {
					time[next] = nextTime;
					pq.add(new Node(next, time[next]));
				}

			}
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
