package kdata.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManagerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1:�߰� ,2:���,3:�˻� ,4 : ������û "
					+ "5:������û����, 6 :������û����Ʈ 7:�����Է� 9:���� ....");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("�й��� �Է��ϼ���");
				String snum = sc.next();
				sc.nextLine();
				System.out.println(snum + "  "+snum.length());
				if (snum.length()!=8) { 
					System.out.println("�й��� ��Ȯ�� �Է��ϼ���");
					break;
				}
				System.out.println("�л��� �̸��� �Է��ϼ���");
				String sname = sc.nextLine();
				System.out.println("�л��� ������ �Է��ϼ���");
				String sex = sc.nextLine();
				try {
					int result = StudentManager.insert(new Student(snum,sname,sex));
					if(result==0) {
						System.out.println("NO~~~~~~~~");
					}else {
						System.out.println("����!");
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
				System.out.println("�˻��Ϸ��� �л� �̸��� �˻��ϼ���");
				sc.nextLine();
				try {
					Student result = StudentManager.selectOne(sc.next());
					if(result ==null) {
						System.out.println("�̸��� Ȯ���ϰ� �ٽ� �Է��ϼ���\n");
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
				System.out.println("�й��� �Է����ּ���");
				String snum2 = sc.nextLine();
				System.out.println(snum2);
				System.out.println("�����ϰ����ϴ� ������ �����ڵ带 �Է��ϼ���");
				String subjectCode = sc.nextLine();
				System.out.println(subjectCode);
				try {
					int result2 = SugangManager.apply(snum2, subjectCode);
					if(result2==0) {
						System.out.println("�Է½���");
						break;
					}else {
						System.out.println("�����Ͽ����ϴ�.");
					} 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5://���
				sc.nextLine();
				System.out.println("�й��� �Է����ּ���");
				String snum3 = sc.nextLine();
				System.out.println(snum3);
				System.out.println("����ϰ����ϴ� ������ �����ڵ带 �Է��ϼ���");
				String subjectCode2 = sc.nextLine();
				System.out.println(subjectCode2);
				try {
					int result2 = SugangManager.cancel(snum3, subjectCode2);
					if(result2==0) {
						System.out.println("��ҽ���");
						break;
					}else {
						System.out.println("�����Ͽ����ϴ�.");
					} 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6://����Ʈ���
				sc.nextLine();
				System.out.println("�й��� �Է����ּ���");
				String snum4 = sc.nextLine();
				System.out.println(snum4);
				try {
					List<Sugang> list = SugangManager.sugangList(snum4);
					if (list==null) {
						System.out.println("�����Ͱ� �����ϴ�");
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
			case 7://�����Է�
				sc.nextLine();
				System.out.println("���� �Է��� �л��� �й��� �Է��ϼ���");
				String snum5 = sc.nextLine();
				System.out.println("������ �ڵ带 �Է��ϼ���");
				String subjectCode4 = sc.nextLine();
				System.out.println("������ �Է��ϼ���");
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
					System.out.println("����!");
				}
				System.out.println("");
				break;
			case 9: 
				System.out.println("�����մϴ�\n");
				return;
			default : 
				System.out.println("�ٽ� �Է��ϼ���\n");

				break;
			}
		}
	}

}
