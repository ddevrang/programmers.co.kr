package ����_ť;

import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����/ť - ��ɰ���
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */

class ��ɰ��� {

	public static void main(String[] args) {

		int[] progresses = { 93, 30, 55 };
//		int[] progresses = { 95, 90, 99, 99, 80, 99 };

		int[] speeds = { 1, 30, 5 };
//		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		int[] result = solution(progresses, speeds);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		// �� �۾��� �����µ� �ɸ��� ����
		int[] Working_days = new int[progresses.length];

		// ������ �� �� ��
		int distribute_day = 0;
		// �ڿ� �ִ� ����� �տ� �ִ� ��ɰ� �Բ� �������� Ȯ���ϱ� ���� ����
		int max = 0;

		for (int i = 0; i < progresses.length; i++) {
			// �� �۾��� �����µ� �ɸ��� ���ڸ� ����
			// ������ �������� �ʴ� ��� �۾��� �Ϸ���� ���� ���̹Ƿ�, �۾����� +1�� ���ش�.
			if ((100 - progresses[i]) % speeds[i] == 0) {
				Working_days[i] = (100 - progresses[i]) / speeds[i];
			} else {
				Working_days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
			}

			// �ڿ� �ִ� ����� �տ� �ִ� ��ɰ� �Բ� �������� Ȯ��
			// ���� max������ ũ�� �Բ� ������ �� �����Ƿ� ������ Ƚ���� ++
			// �׸��� �� ���� ���ο� max������ ����
			if (Working_days[i] > max) {
				distribute_day++;
				max = Working_days[i];
			}
		}

		// ������ �� �� ���� size�� return�� �迭�� ����.
		int[] answer = new int[distribute_day];
		int answer_index = 0;

		// ���ÿ� ������ ����
		int distribute_count = 1;

		for (int i = 0; i < Working_days.length; i++) {

			// ��, �ڿ� ����� ���Ͽ� ���� ���ߵ� ���� ���¶�� ���ÿ� �����ϱ� ����
			for (int j = i + 1; j < Working_days.length; j++) {

				// ���� ��� ������ �� ������� break
				if (Working_days[i] < Working_days[j])
					break;

				// ���ÿ� �����ϴ� ���� ++
				distribute_count++;
				// ���ÿ� ������ ����� �ǳ� ��.
				i++;
			}

			// ���ÿ� �����ϴ� ������ return �� �迭�� �Է�
			answer[answer_index] = distribute_count;
			// �迭 index++
			answer_index++;
			// distribute_count �� �ʱ�ȭ
			distribute_count = 1;

		}

		return answer;
	}
}
