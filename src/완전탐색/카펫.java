package ����Ž��;
import java.util.Arrays;

/*
 * ���α׷��ӽ� - �ڵ��׽�Ʈ ����� Kit
 * ����Ž�� - ī��
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
class ī�� {

	public static void main(String[] args) {

		int brown = 10;
		int yellow = 2;

		int[] result = solution(brown, yellow);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int brown, int yellow) {

		int[] answer = { 0 , 0 };
		
		// ������ ���̸� A, ������ ���̸� B��� �����Ͽ� �� ���̸� ���� �� �ִ� ������ ����
		// A + B = (brown + 4)/2;
		// (A - 2) * (B - 2) = yellow
		// ==> ab - 2b - 2a + 4 = yellow 
		// 	   ab - (2a+2b) = yellow - 4
		// 	   ab - 2(a+b) = yellow - 4   =   ab - 2((brown + 4)/2) = yellow - 4
		// A * B = yellow - 4 + 2((brown + 4)/2)   = (yellow - 4) + 2(A + B)
		
		// A + B �� ���ϴ� ����
		int Sum_AB = (brown + 4)/2;
		// A * B �� ���ϴ� ����
		int Mult_AB = (yellow - 4) + 2 * (Sum_AB);
		
		// A�� ������ ����, B�� ������ ����
		int A;
		int B;
		
		// �ݺ����� ���� ������ �����ϴ� A�� B�� ã��. ã���� �� ���� �����ϰ� break
		for(int i = 1; i < Sum_AB; i++) {
			
			// ������ ���̴� ������ ���̿� ���ų�, ������ ���̺��� ��� ������
			// ������ ���̴� �Ѻ��� �ּ� ���� 1���� �����ϰ�, A�� �ִ� ������ ����.
			A = Sum_AB - i;
			B = i;
			
//			System.out.println("A = "+A+", B = "+B);
//			System.out.println("(A * B) = "+(A * B));
//			System.out.println("Mult_AB = "+Mult_AB);
			
			// A + B ������ ���� A�� B�� ���� �����ϰ�
			// �� ���� �������� A * B ������ �����ϴ��� Ȯ��
			// �����ϸ� �� ���� answer�� �����ϰ� �ݺ��� break
			if( (A * B) == Mult_AB) {
				answer[0] = A;
				answer[1] = B;
				break;
			}
		}

		return answer;
	}
}
