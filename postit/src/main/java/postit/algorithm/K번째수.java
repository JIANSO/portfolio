package postit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 *
 * 2019.05.22
 * 자료구조 알고리즘 > 정렬
 *
 *
 * */
public class K번째수 {

	/*
	 * 1. array 배열을 만드는 입력 기능 작성
	 * 2. commands 2차원 배열을 만드는 입력 기능 작성
	 * 3. commnds 배열에서 순차로 원소 1개를 뽑은 뒤 > command 배열에서 0 번째 원소와 1번째 원소로 array 배열을 추출하고 > array를 정렬한 뒤 > command 배열의 2번째 원소로 array 의 그 값 수 계산 > 리턴
	 *
	*/

	public static int array[] = {1,5,2,6,3,7,4};
	public static int commnads[][] = {{2,5,3},{4,4,1},{1,7,3}};
	public static int newArray[] = {};
	public static List<Integer> list_for_sort = new ArrayList<Integer>(); /* sort 때문에 선언했는데 사용 안 할듯 싶다. */

	public static void main(String args[]){

		//	makeArray();

		for(int[] i : commnads){
			//	System.out.println("i  >> " + i[0]);
			//	newArray = array.clone(); /*오후 2시 3분, 실패다 ㅠㅠ 복사하고 하면 안된다. 배열의 길이까지 복사되 ㅠ 그니까 앞으로 복사할 때는 ArrayList에 한 다음 ㅠㅠ */
			//	int number = 0;
			/*
			 * ! 배열을 배열로 복사했었는데, 그러지 말고, 그냥  list에 복사하고 sort 한 뒤 배열로 옮겨담자. 관련된 것 주석처리하기.
			 */
			int first_element = i[0];
			int last_element = i[1];

			for(int k = first_element - 1 ; k < last_element; k++){
				/* 1.array 배열 추출  */
				//newArray[number] = array[k];
				//System.out.println("k >>" + k);
				//System.out.println("newArray[number] >> " + newArray[number]);
				//number++;

				list_for_sort.add(array[k]);

			}

			//  System.out.println(last_element);

			//	Arrays.sort(newArray);



			//	int third_number = i[2];

			//int result = newArray[third_number];

			//System.out.println(" result >>  " + result);

			/* 2.array 배열 정렬
			int length = newArray.length;
			while(true){

				int first_newArray_element = newArray[0];


				! 배열을 배열로 복사했었는데, 그러지 말고, 그냥  list에 복사하고 sort 한 뒤 배열로 옮겨담자. 관련된 것 주석처리하기.
				length--;
				if(length == 0){
					return;
				}
			}*/

			/*?? 이거 뭐지. 사용법 알아봐야겠다. 			 *
			 * 헛 근데 Arrays.sort 라는 것 발견 ㅠㅠ
			 * 다시 취소 취소
			 *
			 **/
			Comparator com = new Comparator() {

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			};

			//list_for_sort.sort(com);

			Collections.sort(list_for_sort);
			int third_element = i[2];
			for(int test : list_for_sort){
				System.out.println("test :: " + test);
			}
			System.out.println("result :: " + list_for_sort.get(third_element-1) + ",  third_element_order >> " + third_element);

			System.out.println("---------------------------------------------------");
			list_for_sort.clear(); /* clear로 완료 ㅡㅡ*/

		}



	}


	private static int[] makeArray() {

		return array;
	}



}
