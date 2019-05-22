package postit.mockTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.mockito.stubbing.Answer;

import lombok.Data;
/*
 *
 *
 * @Date : 2019.05.17
 * @작성자    : 소지안
 * @설멍	 :
 *
 * 	지금 몸이 물 먹은 솜 같다.
 *https://lng1982.tistory.com/152
 *https://lng1982.tistory.com/152
 *https://lng1982.tistory.com/152
 *
 * */
public class MockitoTest {



	/*
	 * verify 테스트
	 * */
	@Test
	public void verifyTest() {

		@SuppressWarnings("unchecked")
		List<String> testMock = mock(ArrayList.class);
		testMock.add("1");
		testMock.add("2");
		testMock.add("3");

		// add() 가 최소한 1번 이상 호출되었는지 검증
		verify(testMock, atLeastOnce()).add(anyString());

		// add() 가 최소한 3번 이상 호출되었는지 검증
		verify(testMock, atLeast(3)).add(anyString()); // 만약에 3을 5로 바꾸면 에러가 남!

		// add() 가 최대한 3번 이하 호출되었는지 검증
		verify(testMock, atMost(3)).add(anyString());

		// add() 가 3번 이하 호출되었는지 검증
		verify(testMock, times(3)).add(anyString());

		// add("1") 가 1번 호출되었는지 검증
		verify(testMock, times(1)).add("1");

		// add("2") 가 1번 호출되었는지 검증
		verify(testMock, times(1)).add("2");

		// add("3") 가 1번 호출되었는지 검증
		verify(testMock, times(1)).add("3");

		// add("4") 가 수행되지 않았는지를 검증
		verify(testMock, never()).add("4");

	}


	/*
	 * whenThenTest 테스트
	 * */
	@Test
	public void whenThenTest(){
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);

		// 만약 testMock.get("name1")를 호출하면 jian이라는 값을 return 한다는 의미
		// textMock.put("name1", "jian")을 한 것과 같은 의미로 생각하면 된다.

		when(testMock.get("name1")).thenReturn("jian1");
		when(testMock.get("name2")).thenReturn("jian2");
		when(testMock.get("name3")).thenReturn("jian3");

		assertThat("jian1", is(testMock.get("name1")));
		assertThat("jian2", is(testMock.get("name2")));
		assertThat("jian3", is(testMock.get("name3")));


	}


	/*
	 * whenThenthrowtest 테스트
	 * */
	@Test(expected = RuntimeException.class)
	public void whenThenthrowtest(){
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);

		// get("name4") 를 호출하면, RuntimeException 발생
		when(testMock.get("name4")).thenThrow(new RuntimeException());
		assertThat(testMock.get("name4"), is(RuntimeException.class));


	}



	/*
	 * whenThenanswer 테스트
	 * */
	@Test
	public void whenThenAnswerTest(){
		UserDAO userDAO = mock(UserDAO.class);

		when(userDAO.getUser("kyuId")).thenAnswer(new Answer<User>() {

			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserId("kyuId");
				user.setName("남규");
				user.setAge(32);
				return user;
			}
		});

		User user = userDAO.getUser("kyuId");

		//assertThat(null, is(user.getUserId()));
		assertThat("남규", is(user.getName()));
		assertThat(32, is(user.getAge()));
	}


}

class UserDAO {
	public User getUser(String userId) {
		return new User();
	}

	public Object getUserCnt() {
		// TODO Auto-generated method stub
		return null;
	}
}

@Data
class User {
	private String userId;
	private String name;
	private int age;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



}

class UserService {

	public AdminUser getUser(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

class AdminUser{
	private String userName;
	private int userAge;

	public void setUserName(String string) {
		this.userName = string;

	}

	public void setAge(int string) {
		this.userAge = string;

	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

}


