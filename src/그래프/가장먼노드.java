package 그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 그래프 - 가장먼노드
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */

class 가장먼노드 {

	public static void main(String[] args) {

		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		int result = solution(n, edge);

		System.out.println(result);
	}

	public static int solution(int n, int[][] edge) {

		int answer = 0;

		boolean[] visited = new boolean[n + 1];
		List<ArrayList<Integer>> listGraph = new ArrayList<>();

		// == 그래프 노드별로 정보 연결할 준비.
		// 0,1,2,3,4,...n까지 기본 노드들을 만든다.
		for (int i = 0; i <= n; i++) {
			listGraph.add(new ArrayList<Integer>());
		}

		// == 그래프 연결
		// [1,2] 라면
		// listGraph.get(1).add(2) // 1번노드는 2와연결
		// listGraph.get(2).add(1) // 2번노드는 1과연결
		for (int i = 0; i < edge.length; i++) {
			listGraph.get(edge[i][0]).add(edge[i][1]);
			listGraph.get(edge[i][1]).add(edge[i][0]);
		}

		Queue<Integer> nextQ = new LinkedList<>();

		// == 1번부터 출발
		nextQ.offer(1);

		visited[1] = true;

		int size = 0;

		while (!nextQ.isEmpty()) {
			size = nextQ.size();
			// while문을 한번 돈다 -> 1번 깊이 들어간다.
			// 가장 멀리 있는 곳을 찾아야 하기때문에
			// while을 마지막에 돌았을때 도착하는 노드들의 개수 = size를 구하면된다.
			for (int i = 0; i < size; i++) {
				int cur = nextQ.poll();
				visited[cur] = true;
				// 해당 노드와 연결된 노드중 아직 방문하지 않는 노드를 방문한다.
				for (Integer node : listGraph.get(cur)) {
					if (visited[node] == false) {
						nextQ.offer(node); // 다음에 방문하도록 큐에 넣어준다.
						visited[node] = true;
					}
				}
			}

			answer = size;
		}

		return answer;
	}
}
