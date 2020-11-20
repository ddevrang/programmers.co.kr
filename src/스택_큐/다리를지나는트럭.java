package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 스택/큐 - 다리를지나는트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

class 다리를지나는트럭 {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		int result = solution(bridge_length, weight, truck_weights);

		System.out.println(result);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// 다리를 건너는데 누적된 총 시간
		int total_time = 0;

		// 다리를 건너고 있는 트럭이 다리를 모두 지나는 시간(예상시간개념)
		int[] spend_time = new int[truck_weights.length];

		// 다리를 건너지 않은 첫번째 트럭
		int truck_idx = 0;

		Queue<Integer> Bridge = new LinkedList<Integer>();

		while (true) {
			// 다리를 건너는 트럭이 존재하고, 다리를 건너는 트럭이 다리를 완전히 건넜다면
			if (!Bridge.isEmpty() && spend_time[Bridge.peek()] == total_time) {
				// 도착한 버스 제거
				weight += truck_weights[Bridge.poll()];
			}

			// 다리를 건너지않은 트럭이 존재하고, 다리의 무게가 견딜 수 있다면
			if (truck_idx < truck_weights.length && truck_weights[truck_idx] <= weight) {
				// 대기하는 트럭을 추가
				Bridge.add(truck_idx);
				// 다리를 건너고 있는 트럭이 다리를 모두 건넜을 때의 예상시간
				// 현재시간 + 다리 길이(트럭이 다리를 건너는데 걸리는 시간과 같음)
				spend_time[truck_idx] = total_time + bridge_length;
				// 다리가 견딜 수 있는 무게에서 트럭의 무게를 차감
				weight -= truck_weights[truck_idx];
				// 대기하는 트럭의 index를 ++
				truck_idx++;
			}

			// 1초 증가
			total_time++;

			// 모든 트럭이 다 지나가면 종료
			if (Bridge.isEmpty())
				break;
		}

		return total_time;
	}
}
