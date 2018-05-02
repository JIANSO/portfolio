package magic;

import java.util.Scanner;

public class CeasarCode {


	/*시저 암호
	 * 2018-05-01

	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
	A를 3만큼 밀면 D가 되고 z를 1만큼 밀면 a가 됩니다.
	공백은 수정하지 않습니다.
	보낼 문자열 s와 얼마나 밀지 알려주는 n을 입력받아 암호문을 만드는 caesar 함수를 완성해 보세요.
	“a B z”, 4를 입력받았다면 “e F d”를 리턴합니다.*/

	public static void main(String[] args) {

		String valueString;
		int pushNum;
		Scanner scanner = new Scanner(System.in);

		// 1단계 : 입력
		System.out.println(">>보낼 문자열을 입력하세요. 예)a B z");
		valueString = scanner.nextLine(); // 보낼 문자열

		System.out.println(">>얼마나 밀지 숫자를 입력하세요.");
		while(true) {
		    try{
		    	pushNum = scanner.nextInt(); //얼마나 밀지 알려주는 n
		    	break;

		    }catch(Exception e){
		    	System.out.println(">>숫자를 입력해야 합니다. 다시 입력하세요");
		    	scanner = new Scanner(System.in);

		    }
		}
		scanner.close();


		// 2단계 : 입력받은 문자열에 숫자만큼 밀기 적용
		// 대문자 65 ~ 90, 소문자 97 ~ 122
		char alpha[] = valueString.toCharArray();
		int ascii;
		int gap;

		//String splitValue[] = valueString.split(" ");
		for(int i =0; i < alpha.length; i++) {
			if(alpha[i] == ' ') {

			}else {
				ascii = (int)alpha[i];
				if(64 < ascii && ascii < 91) {
					//대문자
					ascii = ascii + pushNum;
					if(90 < ascii) {
						while(true){
							gap = ascii - 90;
							ascii = 64 + gap;
							if(64 < ascii && ascii < 91){
								break;
							}
						}
					}
				}else if(96 < ascii && ascii < 123) {
					//소문자
					ascii = ascii + pushNum;
					if(122 < ascii) {
						while(true){
							gap = ascii - 122;
							ascii = 96 + gap;
							if(96 < ascii && ascii < 123){
								break;
							}
						}
					}
				}

				alpha[i] = (char)ascii;
			}

		}


	    String returnV = String.valueOf(alpha);
	    System.out.println(">>>리턴 암호문  : " + returnV);



	}

}
