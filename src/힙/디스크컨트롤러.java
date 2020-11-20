package ��;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �� - ��ũ��Ʈ�ѷ�
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

class ��ũ��Ʈ�ѷ� {

	public static void main(String[] args) {

		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

		int result = solution(jobs);

		System.out.println(result);
	}

	public static int solution(int[][] jobs) {

		int answer = 0;
		int task_time_total = 0; // ��ü �۾� ����ð�
		int end_time = 0; // ���� ���� �۾��� ������ ��ģ ������ �ð�
		int task_index = 0; // �۾� �迭�� ���� �� �۾� �ε���
		int task_count = 0; // ������ �Ϸ��� ��û�� ����(while�� �ݺ�����)

		// ��û�ð��� �������� �۾� �迭�� �������� ������
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// �ҿ�ð��� �������� �켱���� ť�� �������� ������
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// ��û�� ��� ����� ������ �ݺ�
		while (task_count < jobs.length) {

			// ��� �۾��� ������� �ʾҰ�,
			// �������� �۾��� �Ϸ�� �������� ���� ��� ��û�� �켱���� ť�� ����
			while (task_index < jobs.length && jobs[task_index][0] <= end_time) {
				pq.add(jobs[task_index]);
				task_index++;
			}

			// �켱���� ť�� �۾��� �����ϴ� ���, ���� ��û �� ���� ����ð��� ª�� ��û���� ����
			if (!pq.isEmpty()) {
				int[] work = pq.poll();
				task_time_total += end_time - work[0] + work[1];
				end_time += work[1];
				task_count++;

				// �켱���� ť�� ����ִٸ� ���� ���� ���Ŀ� �ٽ� ��û�� ���� �����̹Ƿ�
				// end_time�� ���� �۾� ��û�ð����� ������
			} else {
				end_time = jobs[task_index][0];
			}
		}

		// ��սð��� ��� (��ü �۾� �ҿ� �ð� / ��ü �۾��� ����)
		answer = (int) Math.floor(task_time_total / jobs.length);

		return answer;
	}
}
