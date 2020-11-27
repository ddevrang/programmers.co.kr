package �׷���;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �׷��� - ����ճ��
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */

class ����ճ�� {

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

		// == �׷��� ��庰�� ���� ������ �غ�.
		// 0,1,2,3,4,...n���� �⺻ ������ �����.
		for (int i = 0; i <= n; i++) {
			listGraph.add(new ArrayList<Integer>());
		}

		// == �׷��� ����
		// [1,2] ���
		// listGraph.get(1).add(2) // 1������ 2�Ϳ���
		// listGraph.get(2).add(1) // 2������ 1������
		for (int i = 0; i < edge.length; i++) {
			listGraph.get(edge[i][0]).add(edge[i][1]);
			listGraph.get(edge[i][1]).add(edge[i][0]);
		}

		Queue<Integer> nextQ = new LinkedList<>();

		// == 1������ ���
		nextQ.offer(1);

		visited[1] = true;

		int size = 0;

		while (!nextQ.isEmpty()) {
			size = nextQ.size();
			// while���� �ѹ� ���� -> 1�� ���� ����.
			// ���� �ָ� �ִ� ���� ã�ƾ� �ϱ⶧����
			// while�� �������� �������� �����ϴ� ������ ���� = size�� ���ϸ�ȴ�.
			for (int i = 0; i < size; i++) {
				int cur = nextQ.poll();
				visited[cur] = true;
				// �ش� ���� ����� ����� ���� �湮���� �ʴ� ��带 �湮�Ѵ�.
				for (Integer node : listGraph.get(cur)) {
					if (visited[node] == false) {
						nextQ.offer(node); // ������ �湮�ϵ��� ť�� �־��ش�.
						visited[node] = true;
					}
				}
			}

			answer = size;
		}

		return answer;
	}
}
