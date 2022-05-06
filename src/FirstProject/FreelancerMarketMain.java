package FirstProject;

import java.util.Scanner;

public class FreelancerMarketMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FreelancerMarketService fms = new FreelancerMarketService();
		boolean run = true;
		while (run) {
			int sel = 0;
			System.out.println("------------------------------");
			System.out.println("1. 전문가서비스| 2.고객서비스 | 3. 종료");
			System.out.println("------------------------------");
			System.out.print("메뉴 선택> ");
			sel = scan.nextInt();
			if (sel == 1) {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("1. 전문가 등록| 2. 서비스 등록 | 3. 포인트 확인 | 4. 내 서비스 확인 | 5. 서비스 수정");
				System.out.println("-------------------------------------------------------------------");
				System.out.print("메뉴 선택> ");
				int fsel = scan.nextInt();
				if (fsel == 1) {
					fms.fsave();
				} else if (fsel == 2) {
					fms.register();
				} else if (fsel == 3) {
					fms.pointCheck();
				} else if (fsel == 4) {
					fms.findProduct();
				} else if (fsel == 5) {
					fms.updateProduct();
				}
			} else if (sel == 2) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("1. 회원가입|2.잔여 포인트 확인 |3. 포인트 구매 |4. 서비스 검색 |5.서비스 결제 |6.구매한 서비스");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.print("메뉴 선택> ");
				int csel = scan.nextInt();
				if (csel == 1) {
					fms.csave();
				} else if (csel == 2) {
					fms.cPointCheck();
				} else if (csel == 3) {
					fms.depositPoint();
				} else if (csel == 4) {
					fms.searchProduct();
				} else if (csel == 5) {
					fms.buyProduct();
				} else if (csel == 6) {
					fms.checkHistory();
				}
			} else if (sel == 3) {
				run = false;
			}
		}
	}
}
