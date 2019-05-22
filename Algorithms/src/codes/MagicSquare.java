package codes;

import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("정사각형 마방진 크기를 입력하세요.");
		int size;

		size = scanner.nextInt();
		int a[][] = new int[size][size];

		int i,j,k,J, nmg;


		if(size%2 == 0){
			//짝수 마방진
			// 조건 1) i=J 이면  k를 a[i][j]가 아닌 a[(size+1)-i][(size+1)-i]에 넣는다
			// 조건 2) J가 (size+1)-i 이면, a[i][j]가 아닌  a[j][i]에 넣는다
			k = 1;

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
		}else{
			//홀수 마방진

			i = 0;
			j = size/2;
			int maxK = (int)Math.pow(size, 2);

			for(k = 1; k <= maxK; k++) {
				a[i][j] = k;
				nmg = k - k/size * size;

				if(nmg == 0) {
					i++;
					continue;
				}

				i--;
				j++;

				if(i<0) {
					i = size-1;
				}
				if(j> size-1) {
					j = 0;
				}

			}//end for
		}


		scanner.close();

		//마방진 출력
		for(int x = 0; x <= size-1; x++) {
			for(int y = 0; y <= size-1; y++) {

				System.out.print(a[x][y]+"   ");
			}
			System.out.print("\n\n");

		}


	}

}
