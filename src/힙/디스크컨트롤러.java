package 힙;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 힙 - 디스크컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

class 디스크컨트롤러 {

	public static void main(String[] args) {

		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

		int result = solution(jobs);

		System.out.println(result);
	}

	public static int solution(int[][] jobs) {

		int answer = 0;
		int task_time_total = 0; // 전체 작업 수행시간
		int end_time = 0; // 진행 중인 작업의 수행을 마친 시점의 시간
		int task_index = 0; // 작업 배열의 진행 중 작업 인덱스
		int task_count = 0; // 수행을 완료한 요청의 갯수(while문 반복조건)

		// 요청시간을 기준으로 작업 배열을 오름차순 정렬함
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// 소요시간을 기준으로 우선순위 큐를 오름차순 정렬함
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// 요청이 모두 수행될 때까지 반복
		while (task_count < jobs.length) {

			// 모든 작업이 수행되지 않았고,
			// 진행중인 작업이 완료된 시점까지 들어온 모든 요청을 우선순위 큐에 넣음
			while (task_index < jobs.length && jobs[task_index][0] <= end_time) {
				pq.add(jobs[task_index]);
				task_index++;
			}

			// 우선순위 큐에 작업이 존재하는 경우, 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			if (!pq.isEmpty()) {
				int[] work = pq.poll();
				task_time_total += end_time - work[0] + work[1];
				end_time += work[1];
				task_count++;

				// 우선순위 큐가 비어있다면 현재 시점 이후에 다시 요청이 들어올 예정이므로
				// end_time을 이후 작업 요청시간으로 맞춰줌
			} else {
				end_time = jobs[task_index][0];
			}
		}

		// 평균시간을 계산 (전체 작업 소요 시간 / 전체 작업의 갯수)
		answer = (int) Math.floor(task_time_total / jobs.length);

		return answer;
	}
}
