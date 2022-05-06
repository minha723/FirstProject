package FirstProject_ver3;

import java.util.Scanner;

public class FreelancerMarketMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FreelancerMarketService fms = new FreelancerMarketService();
		boolean run = true;
		while (run) {
			int sel = 0;
			System.out.println("---------------------------------------------");
			System.out.println("1. 전문가서비스 | 2. 고객서비스 | 3. 관리자 모드 | 4. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("메뉴 선택> ");
			sel = scan.nextInt();
			if (sel == 1) {
				System.out.println("--------------------------");
				System.out.println("1. 전문가 등록 | 2. 전문가 로그인");
				System.out.println("--------------------------");
				System.out.print("메뉴 선택> ");
				int fsel = scan.nextInt();
				if (fsel == 1) {
					fms.fsave();
				} else if (fsel == 2) {
					fms.flogin();
				}
			} else if (sel == 2) {
				System.out.println("---------------------");
				System.out.println("1. 회원가입 | 2. 고객 로그인");
				System.out.println("---------------------");
				System.out.print("메뉴 선택> ");
				int csel = scan.nextInt();
				if (csel == 1) {
					fms.csave();
				} else if (csel == 2) {
					fms.clogin();
				}
			} else if (sel == 3) {
				fms.manager();
			} else if (sel == 4)
				run = false;
		}
		scan.close();
	}
}
