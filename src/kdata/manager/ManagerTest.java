package kdata.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManagerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1:�߰� ,2:���,3:�˻� , 4:���� ....");
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
				System.out.println("�����մϴ�\n");
				return;
			default : 
				System.out.println("�ٽ� �Է��ϼ���\n");

				break;
			}
		}
	}

}
