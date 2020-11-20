package ��;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �� - ���߿켱����ť
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */

class ���߿켱����ť {

	public static void main(String[] args) {

		String[] operations = { "I 7", "I 5", "I -5", "D -1" };

		int[] result = solution(operations);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] operations) {

		int[] answer = { 0, 0 };

		// �켱����ť�� ������������ ����(�ִ���)
		PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
		// �켱����ť�� ������������ ����(�ּ���)
		PriorityQueue<Integer> MinPQ = new PriorityQueue<>();

		for (String a : operations) {
			// ������ �������� split �Ͽ� ����
			String[] operation = a.split(" ");

			// ��ɾ I�� �����ϴ� ��� ť�� �־��� ���ڸ� ����
			if (operation[0].equals("I")) {
				MaxPQ.add(Integer.parseInt(operation[1]));
				MinPQ.add(Integer.parseInt(operation[1]));
			}

			// ��ɾ D�� �����ϴ� ���
			// operation[1] ���� 1�� ��� ť���� �ִ��� ����
			// operation[1] ���� -1�� ��� ť���� �ּڰ��� ����
			if (operation[0].equals("D")) {
				if (!MaxPQ.isEmpty() || !MinPQ.isEmpty()) {
					if (operation[1].equals("1")) {
						int max = MaxPQ.peek();
						MaxPQ.remove(max);
						MinPQ.remove(max);

					} else {
						int min = MinPQ.peek();
						MaxPQ.remove(min);
						MinPQ.remove(min);
					}
				}
			}

		}

		// ��� ������ ó���� �� ť�� ������� ������ [�ִ�, �ּڰ�]�� return
		if (!MaxPQ.isEmpty() || !MinPQ.isEmpty()) {
			answer[0] = MaxPQ.peek();
			answer[1] = MinPQ.peek();
		}

		return answer;
	}
}
