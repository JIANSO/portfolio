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
public class NumberK {


	public static int array[] = {1,5,2,6,3,7,4};
	public static int commnads[][] = {{2,5,3},{4,4,1},{1,7,3}};

	public static int newArray[] = new int[3];
	public static List<Integer> list_for_sort = new ArrayList<Integer>();

	public static void main(String args[]){


		int[] result = solution();
		for(int s : result){
			System.out.println("result >>  " + s);
		}



	}

	static int[] solution(){
		int order = 0;
		for(int[] i : commnads){

			int first_element = i[0];
			int last_element = i[1];

			for(int k = first_element - 1 ; k < last_element; k++){
				list_for_sort.add(array[k]);

			}

			Collections.sort(list_for_sort);
			int third_element = i[2];
			newArray[order] = list_for_sort.get(third_element-1);

			list_for_sort.clear(); /* clear로 완료 ㅡㅡ*/
			order++;

		}
		return newArray;
	}




}


