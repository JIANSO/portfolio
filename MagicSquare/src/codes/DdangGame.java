package codes;

import java.util.Scanner;

public class DdangGame {

	/*땅따먹기 게임
	2018-05-01

	영희는 땅따먹기 게임에 푹 빠졌습니다. 땅따먹기 게임의 땅은 총 N행 4열로 나누어져 있고,
	모든 칸에는 점수가 쓰여 있습니다. 땅을 밟으면서 한 행씩 내려올 때,
	영희는 각 행의 4칸 중 1칸만 밟으면서 내려올 수 있습니다.
	땅따먹기 게임에는 같은 열을 연속해서 밟을 수가 없는 특수 규칙이 있습니다.
	즉, 1행에서 (5)를 밟았다면, 2행의 (8)은 밟을 수가 없게 됩니다.
	마지막 행까지 모두 내려왔을 때, 점수가 가장 높은 사람이 게임의 승자가 됩니다.
	여러분이 hopscotch 함수를 제작하여 영희가 최대 몇 점을 얻을 수 있는지 알려주세요.
	예를 들어
	1 2 3 5
	5 6 7 8
	4 3 2 1
	의 땅이 있다면, 영희는 각 줄에서 (5), (7), (4) 땅을 밟아 16점을 최고점으로 받을 수 있으며,
	hopscotch 함수에서는 16을 반환해주면 됩니다.
	행과 4열의 데이터는 직접 입력 받음.*/

	public static void main(String[] args) {

		//행과 4열의 데이터를 직접 입력받음
		int row;
		Scanner scanner = new Scanner(System.in);

		System.out.println(">> 행 수를 입력하세요");
		row = scanner.nextInt();
		int[][] data = new int[row][4];

		System.out.println(">> 땅에 점수들을 입력해주세요");
		for(int i =0; i < row; i++) {
			for(int J = 0; J < 4; J++) {
				data[i][J] = scanner.nextInt();
			}
		}

		//땅 출력
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < 4; y++) {
				System.out.print(data[x][y]+"   ");
			}
			System.out.print("\n\n");
		}


		System.out.println(">> 땅따먹기 게임 시작");
		int best;
		int spot = -1;

		for(int i =0; i < row; i++) {
			best = 0;
			for(int J = 0; J < 3; J++) {
				// 1) 가장 큰 수
				// 2) 다음 번엔 같은 열을 밟을 수 없음

				if(data[i][J] < data[i][J+1]) {
					if(spot == J+1) {
						best = data[i][J];
						spot = J;
						continue;

					}else if(data[i][J+1] > best){
						best = data[i][J+1];
						spot = J+1; //밟으면 안되는 열 값 저장

					}

				}else if(data[i][J] >= data[i][J+1]) {
					if(spot == J) {
						continue;

					}else if(data[i][J] > best){
						best = data[i][J];
						spot = J; //밟으면 안되는 열 값 저장

					}
				}

			}//end for(J)

			System.out.println("밟으면 안되는 열: " + spot + ", 가장 큰 수 : " + best);
		}//end for(i)









	}//end main()

}
