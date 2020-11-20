package ����_ť;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����/ť - ������
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

class ������ {

	public static void main(String[] args) {

//		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities = { 1, 1, 9, 1, 1, 1 };

//		int location = 2;
		int location = 0;

		int result = solution(priorities, location);

		System.out.println(result);
	}

	public static int solution(int[] priorities, int location) {

		int answer = 0;

		// �켱���� ť�� ����Ͽ� ����Ǯ��.
		// int�� priorityQueue ���� (�켱������ ���� ���� ������ ����)
		PriorityQueue<Integer> printer = new PriorityQueue<>(Collections.reverseOrder());

		// �켱���� ť�� ����� �߰�
		for (int priority : priorities) {
			printer.offer(priority);
		}

		while (!printer.isEmpty()) {

			for (int i = 0; i < priorities.length; i++) {
				// �켱������ ���� ���� ���� ���
				if (printer.peek() == priorities[i]) {
					// �켱������ ���� ���� ���� ����
					printer.poll();
					// ������ �μ�� ���� ++
					answer++;
					
					// ���� ��û�� ������ location�� ��� �� ���� answer�� ����
					if (location == i) {
						return answer;
					}
				}
			}
		}

		return answer;
	}
}
