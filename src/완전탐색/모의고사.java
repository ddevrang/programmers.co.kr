package ����Ž��;

import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����Ž�� - ���ǰ��
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */

class ���ǰ�� {

	public static void main(String[] args) {

		int[] answers = { 1, 2, 3, 4, 5 };
//		int[] answers = { 1, 3, 2, 4, 2 };

		int[] result = solution(answers);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] answers) {

		// ������ 1,2,3���� ��� ���
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// ������ 1,2,3���� ���� ����
		int[] correct_cnt = { 0, 0, 0 };

		// ���� ���� ���� �������� ���� ����
		int max = 0;

		// ���� ���� ���� �������� ��(������ ��� ������)
		int max_cnt = 0;

		for (int i = 0; i < answers.length; i++) {
//        	System.out.println("i = "+i);
//        	System.out.println("answers = "+answers[i]);
//        	System.out.println("student1 = "+student1[i%5]);
			if (answers[i] == student1[i % 5]) {
				correct_cnt[0]++;
			}
			if (answers[i] == student2[i % 8]) {
				correct_cnt[1]++;
			}
			if (answers[i] == student3[i % 10]) {
				correct_cnt[2]++;
			}
		}

		// ���� ���� ���� �������� ���� ������ ���ϱ�
		for (int i = 0; i < correct_cnt.length; i++) {
			if (max < correct_cnt[i]) {
				max = correct_cnt[i];
			}
		}

		// max ���� ���� ����� ������� Ȯ��
		for (int i = 0; i < correct_cnt.length; i++) {
			if (max == correct_cnt[i]) {
				max_cnt++;
			}
		}

		// max_cnt�� ������ �������� �迭�� ����
		int[] answer = new int[max_cnt];
		// �迭�� ���� �ֱ����� index
		int idx = 0;

//        System.out.println("correct_cnt = "+Arrays.toString(correct_cnt));

		for (int i = 0; i < correct_cnt.length; i++) {
//        	System.out.println("max = "+max);
//        	System.out.println("correct_cnt[i] = "+correct_cnt[i]);
			if (max == correct_cnt[i]) {
				answer[idx] = i + 1;
				idx++;
			}
		}

		return answer;
	}
}
