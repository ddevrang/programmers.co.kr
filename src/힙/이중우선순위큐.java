package 힙;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 힙 - 이중우선순위큐
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */

class 이중우선순위큐 {

	public static void main(String[] args) {

		String[] operations = { "I 7", "I 5", "I -5", "D -1" };

		int[] result = solution(operations);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] operations) {

		int[] answer = { 0, 0 };

		// 우선순위큐를 내림차순으로 정렬(최대힙)
		PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
		// 우선순위큐를 오름차순으로 정렬(최소힙)
		PriorityQueue<Integer> MinPQ = new PriorityQueue<>();

		for (String a : operations) {
			// 공백을 기준으로 split 하여 저장
			String[] operation = a.split(" ");

			// 명령어가 I로 시작하는 경우 큐에 주어진 숫자를 삽입
			if (operation[0].equals("I")) {
				MaxPQ.add(Integer.parseInt(operation[1]));
				MinPQ.add(Integer.parseInt(operation[1]));
			}

			// 명령어가 D로 시작하는 경우
			// operation[1] 값이 1인 경우 큐에서 최댓값을 삭제
			// operation[1] 값이 -1인 경우 큐에서 최솟값을 삭제
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

		// 모든 연산을 처리한 후 큐가 비어있지 않으면 [최댓값, 최솟값]을 return
		if (!MaxPQ.isEmpty() || !MinPQ.isEmpty()) {
			answer[0] = MaxPQ.peek();
			answer[1] = MinPQ.peek();
		}

		return answer;
	}
}
