package 완전탐색;
import java.util.Arrays;

/*
 * 프로그래머스 - 코딩테스트 고득점 Kit
 * 완전탐색 - 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
class 카펫 {

	public static void main(String[] args) {

		int brown = 10;
		int yellow = 2;

		int[] result = solution(brown, yellow);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int brown, int yellow) {

		int[] answer = { 0 , 0 };
		
		// 가로의 길이를 A, 세로의 길이를 B라고 가정하여 각 길이를 구할 수 있는 수식을 세움
		// A + B = (brown + 4)/2;
		// (A - 2) * (B - 2) = yellow
		// ==> ab - 2b - 2a + 4 = yellow 
		// 	   ab - (2a+2b) = yellow - 4
		// 	   ab - 2(a+b) = yellow - 4   =   ab - 2((brown + 4)/2) = yellow - 4
		// A * B = yellow - 4 + 2((brown + 4)/2)   = (yellow - 4) + 2(A + B)
		
		// A + B 를 구하는 수식
		int Sum_AB = (brown + 4)/2;
		// A * B 를 구하는 수식
		int Mult_AB = (yellow - 4) + 2 * (Sum_AB);
		
		// A는 가로의 길이, B는 세로의 길이
		int A;
		int B;
		
		// 반복문을 돌려 수식이 성립하는 A와 B를 찾음. 찾으면 그 값을 저장하고 break
		for(int i = 1; i < Sum_AB; i++) {
			
			// 가로의 길이는 세로의 길이와 같거나, 세로의 길이보다 길기 때문에
			// 세로의 길이는 한변의 최소 값인 1부터 시작하고, A는 최대 값부터 시작.
			A = Sum_AB - i;
			B = i;
			
//			System.out.println("A = "+A+", B = "+B);
//			System.out.println("(A * B) = "+(A * B));
//			System.out.println("Mult_AB = "+Mult_AB);
			
			// A + B 수식을 통해 A와 B의 값을 설정하고
			// 그 값을 기준으로 A * B 수식이 성립하는지 확인
			// 성립하면 그 값을 answer에 저장하고 반복문 break
			if( (A * B) == Mult_AB) {
				answer[0] = A;
				answer[1] = B;
				break;
			}
		}

		return answer;
	}
}
