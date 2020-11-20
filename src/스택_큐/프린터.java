package 스택_큐;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 스택/큐 - 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

class 프린터 {

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

		// 우선순위 큐를 사용하여 문제풀이.
		// int형 priorityQueue 선언 (우선순위가 높은 숫자 순으로 정렬)
		PriorityQueue<Integer> printer = new PriorityQueue<>(Collections.reverseOrder());

		// 우선순위 큐에 대기목록 추가
		for (int priority : priorities) {
			printer.offer(priority);
		}

		while (!printer.isEmpty()) {

			for (int i = 0; i < priorities.length; i++) {
				// 우선순위가 가장 높은 값인 경우
				if (printer.peek() == priorities[i]) {
					// 우선순위가 가장 높은 값을 제거
					printer.poll();
					// 문서의 인쇄된 순서 ++
					answer++;
					
					// 내가 요청한 문서의 location인 경우 그 순서 answer를 리턴
					if (location == i) {
						return answer;
					}
				}
			}
		}

		return answer;
	}
}
