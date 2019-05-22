package postit.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *
 * 2019.05.22
 * Comparable 학습
 * 
 * https://cwondev.tistory.com/15
 * https://cwondev.tistory.com/15
 * https://cwondev.tistory.com/15
 * 
 */
public class SoccerPlayer2 {

	public static void main(String[] args){




		ArrayList<SoccerPlayer> playerList = new ArrayList<SoccerPlayer>();

		SoccerPlayer player1 = new SoccerPlayer("메시", "공격수", 23);
		SoccerPlayer player2 = new SoccerPlayer("호날두", "공격수", 25);
		SoccerPlayer player3 = new SoccerPlayer("줄라탄", "공격수", 26);
		SoccerPlayer player4 = new SoccerPlayer("박지성", "미드필더", 30);
		SoccerPlayer player5 = new SoccerPlayer("오스카", "미드필더", 21);
		SoccerPlayer player6 = new SoccerPlayer("기안", "공격수", 33);

		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		playerList.add(player6);

		//Collections.sort(playerList); implements 한 comparable 사용 시

		/*
		 * Comparable을 implements 하지 않고도 오브젝트의 특정 변수를 기준으로 정렬하는 방법은 있다.
		 * 이 때 사용하는 방법이 바로 Comparator이다.
		 * Comparator를 사용하면 정렬기준을 본인이 원하는대로 바꾸는 것이 가능하다.
		 * */

		Collections.sort(playerList, new Comparator<SoccerPlayer>() {

			@Override
			public int compare(SoccerPlayer p1, SoccerPlayer p2) {
				if(p1.getAge() > p2.getAge()){
					return 1;
				}else if(p1.getAge() < p2.getAge()){
					return -1;
				}else{
					return 0;
				}
//
			}

		});

		for(int i = 0; i < playerList.size(); i++){
			System.out.println("result >>" + playerList.get(i).getName() + ", " + playerList.get(i).getAge());
		}



	}

}
