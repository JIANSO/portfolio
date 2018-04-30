package magic;

import java.util.Scanner;

public class Code_even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("정사각형 마방진 크기를 입력하세요.");
		int size = scanner.nextInt();

		int i, J;
		int k = 1;
		int a[][] = new int[size][size];


		// 조건 1) i=J 이면  k를 a[i][j]가 아닌 a[(size+1)-i][(size+1)-i]에 넣는다
		// 조건 2) J가 (size+1)-i 이면, a[i][j]가 아닌  a[j][i]에 넣는다

		for(i = 0; i <= size-1; i++){

			for(J = 0; J <= size-1; J++){
				if(i == J){
					a[(size-1)-i][(size-1)-i] = k;

				}else{
					if( J == ((size-1)-i)) {
						a[(size-1)-i][i] = k;

					}else{
						a[i][J] = k;

					}
				}


				k = k+1;

			}//end for(J)


		}//end for(i)



		//마방진 출력
		for(int x = 0; x <= size-1; x++) {
			for(int y = 0; y <= size-1; y++) {

				System.out.print(a[x][y]+"   ");
			}
			System.out.print("\n\n");

		}

	}

}
