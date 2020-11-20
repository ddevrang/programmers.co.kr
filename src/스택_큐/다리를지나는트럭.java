package ����_ť;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����/ť - �ٸ���������Ʈ��
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

class �ٸ���������Ʈ�� {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		int result = solution(bridge_length, weight, truck_weights);

		System.out.println(result);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// �ٸ��� �ǳʴµ� ������ �� �ð�
		int total_time = 0;

		// �ٸ��� �ǳʰ� �ִ� Ʈ���� �ٸ��� ��� ������ �ð�(����ð�����)
		int[] spend_time = new int[truck_weights.length];

		// �ٸ��� �ǳ��� ���� ù��° Ʈ��
		int truck_idx = 0;

		Queue<Integer> Bridge = new LinkedList<Integer>();

		while (true) {
			// �ٸ��� �ǳʴ� Ʈ���� �����ϰ�, �ٸ��� �ǳʴ� Ʈ���� �ٸ��� ������ �ǳԴٸ�
			if (!Bridge.isEmpty() && spend_time[Bridge.peek()] == total_time) {
				// ������ ���� ����
				weight += truck_weights[Bridge.poll()];
			}

			// �ٸ��� �ǳ������� Ʈ���� �����ϰ�, �ٸ��� ���԰� �ߵ� �� �ִٸ�
			if (truck_idx < truck_weights.length && truck_weights[truck_idx] <= weight) {
				// ����ϴ� Ʈ���� �߰�
				Bridge.add(truck_idx);
				// �ٸ��� �ǳʰ� �ִ� Ʈ���� �ٸ��� ��� �ǳ��� ���� ����ð�
				// ����ð� + �ٸ� ����(Ʈ���� �ٸ��� �ǳʴµ� �ɸ��� �ð��� ����)
				spend_time[truck_idx] = total_time + bridge_length;
				// �ٸ��� �ߵ� �� �ִ� ���Կ��� Ʈ���� ���Ը� ����
				weight -= truck_weights[truck_idx];
				// ����ϴ� Ʈ���� index�� ++
				truck_idx++;
			}

			// 1�� ����
			total_time++;

			// ��� Ʈ���� �� �������� ����
			if (Bridge.isEmpty())
				break;
		}

		return total_time;
	}
}
