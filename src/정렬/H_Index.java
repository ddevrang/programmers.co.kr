package 정렬;

import java.util.*;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 정렬 - H_Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */

class H_Index {

	public static void main(String[] args) {

		int[] citations = { 3, 0, 6, 1, 5 };

		int result = solution(citations);
		System.out.println(result);
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			int h_index = citations.length - i;

			if (citations[i] >= h_index) {
				answer = h_index;
				break;
			}
		}

		return answer;
	}
}