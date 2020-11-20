package ��;

import java.util.PriorityQueue;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * �� - �� �ʰ�
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

class ���ʰ� {

	public static void main(String[] args) {

		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		
		int K = 7;

		int result = solution(scoville, K);

		System.out.println(result);
	}

	public static int solution(int[] scoville, int K) {

		int answer = 0;
		
		// �켱���� ť�� ��� (default : ���� ���� ��)
		PriorityQueue<Integer> scoville_pq = new PriorityQueue<>();
		
		// �켱���� ť�� �����͸� �Է�
		for(int val : scoville) {
			scoville_pq.offer(val);
		}
		
		// ���� �� �ſ� ������ ���� K ���� ������ �ݺ�
		while(scoville_pq.peek() < K) {
			
			// ������ ���ѻ��׿� ���� ����ó��
			// ��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return
            if(scoville_pq.size()==1) {
            	answer = -1;                                   
                break;
            }
			
			// ���ں� ������ ���� ���� ���� �ΰ��� ���� ����
			int food1 = scoville_pq.peek();
			scoville_pq.poll(); 
			int food2 = scoville_pq.peek();
			scoville_pq.poll(); 
			
			// ���ο� ������ ����
			// ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
			int new_food = food1 + ( food2 * 2 );
			answer++;
			
			// �켱���� ť�� ���ο� ������ �߰�
			scoville_pq.offer(new_food);
		}

		return answer;
	}
}
