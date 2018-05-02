package codes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReverseInt {

	/*2018-05-01
	 *
	 * reverseInt 메소드는 int형 n을 매개변수로 입력받습니다.
	n에 나타나는 숫자를 큰 것 부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
	예를들어 n이 118372면, 873211을 리턴하면 됩니다.
	n은 양의 정수입니다.*/

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println(">>숫자를 입력하세요. 예) 118372");
		int n;
		int[] reversed;

		while(true) {
			try {
				n = scanner.nextInt();
				if(n<=0) {
					System.out.println(">>양의 정수를 입력하세요");
					n = scanner.nextInt();

				}else {
				   reversed = reverseInt(n);
				   break;
				}
			}catch(InputMismatchException e) {
				System.out.println(">>문자를 입력할 수 없습니다. 양의 정수를 입력하세요");
				e.printStackTrace();
				scanner = new Scanner(System.in);
			}

		}
		scanner.close();

		System.out.print(">>>리턴값 : ");
		for(int c : reversed) {
			System.out.print(c);
		}


	}//end main()

	public static int[] reverseInt(int n) {
		String valueString = String.valueOf(n);
		int[] a = new int[valueString.length()];
	    int random;

		// 문자열을 잘라 숫자 배열에 넣기
		for(int i= 0; i < valueString.length(); i++) {
			a[i] = (int)valueString.charAt(i) -'0';
		}

		// 숫자 배열 안에서 큰것부터 작은 것 순으로 정렬하기
		for(int i= 0; i < a.length; i++) {

			for(int j =0; j < a.length-1; j++) {
				if(a[j] < a[j+1]) {
					random = a[j];
					a[j] = a[j+1];
					a[j+1] = random;
				}
			}

		}//end for


		return  a;
	}

}
