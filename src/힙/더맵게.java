package 힙;

import java.util.PriorityQueue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 힙 - 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

class 더맵게 {

	public static void main(String[] args) {

		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		
		int K = 7;

		int result = solution(scoville, K);

		System.out.println(result);
	}

	public static int solution(int[] scoville, int K) {

		int answer = 0;
		
		// 우선순위 큐를 사용 (default : 낮은 숫자 순)
		PriorityQueue<Integer> scoville_pq = new PriorityQueue<>();
		
		// 우선순위 큐에 데이터를 입력
		for(int val : scoville) {
			scoville_pq.offer(val);
		}
		
		// 가장 덜 매운 음식이 기준 K 보다 작으면 반복
		while(scoville_pq.peek() < K) {
			
			// 문제의 제한사항에 따른 예외처리
			// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
            if(scoville_pq.size()==1) {
            	answer = -1;                                   
                break;
            }
			
			// 스코빌 지수가 가장 낮은 음식 두개의 값을 저장
			int food1 = scoville_pq.peek();
			scoville_pq.poll(); 
			int food2 = scoville_pq.peek();
			scoville_pq.poll(); 
			
			// 새로운 음식을 만듬
			// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
			int new_food = food1 + ( food2 * 2 );
			answer++;
			
			// 우선순위 큐에 새로운 음식을 추가
			scoville_pq.offer(new_food);
		}

		return answer;
	}
}
