package 완전탐색;

import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 완전탐색 - 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */

class 모의고사 {

	public static void main(String[] args) {

		int[] answers = { 1, 2, 3, 4, 5 };
//		int[] answers = { 1, 3, 2, 4, 2 };

		int[] result = solution(answers);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] answers) {

		// 수포자 1,2,3번의 찍는 방식
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// 수포자 1,2,3번의 정답 갯수
		int[] correct_cnt = { 0, 0, 0 };

		// 가장 많이 맞춘 수포자의 정답 갯수
		int max = 0;

		// 가장 많이 맞춘 수포자의 수(동점인 경우 여러명)
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

		// 가장 많이 맞춘 수포자의 정답 갯수를 구하기
		for (int i = 0; i < correct_cnt.length; i++) {
			if (max < correct_cnt[i]) {
				max = correct_cnt[i];
			}
		}

		// max 값을 가진 사람이 몇명인지 확인
		for (int i = 0; i < correct_cnt.length; i++) {
			if (max == correct_cnt[i]) {
				max_cnt++;
			}
		}

		// max_cnt의 갯수를 기준으로 배열을 생성
		int[] answer = new int[max_cnt];
		// 배열에 값을 넣기위한 index
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
