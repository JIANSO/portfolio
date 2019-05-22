package postit.practice;

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
public class SoccerPlayer implements Comparable<SoccerPlayer> {

	private String name;
	private String position;
	private int age;

	public SoccerPlayer(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(SoccerPlayer player) {
		// TODO Auto-generated method stub
		return name.compareTo(player.getName());
	}

}
