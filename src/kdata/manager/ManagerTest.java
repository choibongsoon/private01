package kdata.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManagerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1:추가 ,2:출력,3:검색 ,4 : 수강신청 "
					+ "5:수강신청변경, 6 :수강신청리스트 7:성적입력 9:종료 ....");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("학번을 입력하세요");
				String snum = sc.next();
				sc.nextLine();
				System.out.println(snum + "  "+snum.length());
				if (snum.length()!=8) { 
					System.out.println("학번을 정확히 입력하세요");
					break;
				}
				System.out.println("학생의 이름을 입력하세요");
				String sname = sc.nextLine();
				System.out.println("학생의 성별을 입력하세요");
				String sex = sc.nextLine();
				try {
					int result = StudentManager.insert(new Student(snum,sname,sex));
					if(result==0) {
						System.out.println("NO~~~~~~~~");
					}else {
						System.out.println("성공!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("");
				break;
			case 2:
				try {
					List<Student> list = StudentManager.selectAll();
					for( int i = 0;i<list.size();i++ ) {
						System.out.println(list.get(i));
					}
					/*for (Student l:list) {
						System.out.println(l.getSname());
					}*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("");
				break;
				
			case 3:
				System.out.println("검색하려는 학생 이름을 검색하세요");
				sc.nextLine();
				try {
					Student result = StudentManager.selectOne(sc.next());
					if(result ==null) {
						System.out.println("이름을 확인하고 다시 입력하세요\n");
						break;
					}
					System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("");
				break;
			case 4:
				sc.nextLine();
				System.out.println("학번을 입력해주세요");
				String snum2 = sc.nextLine();
				System.out.println(snum2);
				System.out.println("수강하고자하는 강의의 과목코드를 입력하세요");
				String subjectCode = sc.nextLine();
				System.out.println(subjectCode);
				try {
					int result2 = SugangManager.apply(snum2, subjectCode);
					if(result2==0) {
						System.out.println("입력실패");
						break;
					}else {
						System.out.println("성공하였습니다.");
					} 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5://취소
				sc.nextLine();
				System.out.println("학번을 입력해주세요");
				String snum3 = sc.nextLine();
				System.out.println(snum3);
				System.out.println("취소하고자하는 강의의 과목코드를 입력하세요");
				String subjectCode2 = sc.nextLine();
				System.out.println(subjectCode2);
				try {
					int result2 = SugangManager.cancel(snum3, subjectCode2);
					if(result2==0) {
						System.out.println("취소실패");
						break;
					}else {
						System.out.println("성공하였습니다.");
					} 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6://리스트출력
				sc.nextLine();
				System.out.println("학번을 입력해주세요");
				String snum4 = sc.nextLine();
				System.out.println(snum4);
				try {
					List<Sugang> list = SugangManager.sugangList(snum4);
					if (list==null) {
						System.out.println("데이터가 없습니다");
					}
					for( int i = 0;i<list.size();i++ ) {
						System.out.println(list.get(i));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("");
				break;
			case 7://성적입력
				sc.nextLine();
				System.out.println("성적 입력할 학생의 학번을 입력하세요");
				String snum5 = sc.nextLine();
				System.out.println("과목의 코드를 입력하세요");
				String subjectCode4 = sc.nextLine();
				System.out.println("성적을 입력하세요");
				int grade = sc.nextInt();
				
				int result=0;
				try {
					result = SugangManager.inputGrade(snum5,subjectCode4,grade);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result==0) {
					System.out.println("NO~~~~~~~~");
				}else {
					System.out.println("성공!");
				}
				System.out.println("");
				break;
			case 9: 
				System.out.println("종료합니다\n");
				return;
			default : 
				System.out.println("다시 입력하세요\n");

				break;
			}
		}
	}

}
