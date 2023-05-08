package member1;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Member1DTO dto = new Member1DTO();
		Member1DTO dto = null;
		int num,age=0;
		String name=null;
		MemberService1 ms = new MemberService1();
		
		while(true) {
			System.out.println("1.저장");
			System.out.println("2.검색");
			System.out.println("3.종료");
			System.out.print(">>> ");
			num = input.nextInt();
			switch(num) {
			case 1: 
				System.out.print("이름 : ");
				name = input.next();
				
				if(ms.checkUser(name)) {
					System.out.println("중복된 회원입니다");
					break;
				}
				System.out.print("나이 : ");
				age = input.nextInt();
				
				dto = new Member1DTO();
				dto.setName(name); dto.setAge(age);
				
				ms.save(dto);
				
				break;
			case 2: 
				System.out.print("이름: ");
				name = input.next();
				
				if(ms.checkUser(name)==false) {
					System.out.println("존재하지 않는 사용자입니다");
					break;
				}
				
				dto = ms.getMember(name);
				System.out.println("이름: "+dto.getName());
				System.out.println("나이: "+dto.getAge());
				break;
			case 3:
				System.out.println("프로그램 종료");
				System.exit(1);
			}
		}
		
	}
}
