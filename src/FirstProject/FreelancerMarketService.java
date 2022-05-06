package FirstProject;

import java.util.*;

public class FreelancerMarketService {
	Scanner scan = new Scanner(System.in);
	Long cId = 0L, fId = 0L, pId = 0L;
	FreelancerMarketRepository fmr = new FreelancerMarketRepository();

	public void fsave() {
		System.out.print("아이디: ");
		String id = scan.next();
		if(!fmr.duplicateCheck(id)) {
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("비밀번호: ");
			String pw = scan.next();
			System.out.print("전화번호: ");
			String mobile = scan.next();
			System.out.print("이메일: ");
			String email = scan.next();
			Long fPoint = 0L;
			FreelancerDTO freelancer = new FreelancerDTO(++fId, id, name, pw, mobile, email, fPoint);
			if (fmr.save(freelancer)) {
				System.out.println("전문가 등록 완료");
			} else {
				System.out.println("전문가 등록 실패");
			}
		} else {
			System.out.println("중복된 아이디 값이 존재합니다.");
		}
	}

	private void psave(Long fid) {
		System.out.print("상품이름: ");
		String pName = scan.next();
		scan.nextLine();
		System.out.print("상품설명: ");
		String pDesc = scan.nextLine();
		System.out.print("상품가격: ");
		Long pPrice = scan.nextLong();
		ProductDTO product = new ProductDTO(++pId, fid, pName, pDesc, pPrice);
		if (fmr.psave(product)) {
			System.out.println("상품 등록 완료");
		} else {
			System.out.println("상품 등록 실패");
		}
	}

	public void register() {
		Long fid = flogin();
		if (fid != null) {
			psave(fid);
		} else {
			System.out.println("아이디 또는 비밀번호가 틀려요");
		}
	}

	public void pointCheck() {
		Long fid = flogin();
		if (fid != null) {
			FreelancerDTO flancer = fmr.pointCheck(fid);
			System.out.println("현재 전문가님의 포인트는 " + flancer.getfPoint() + "원 입니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 틀려요");
		}
	}

	public Long findProduct() {
		Long fid = flogin();
		if (fid != null) {
			List<ProductDTO> productList = fmr.findProduct(fid);
			for (ProductDTO p : productList) {
				System.out.println(p);
			}
			return fid;
		} else {
			System.out.println("아이디 또는 비밀번호가 틀려요");
			return null;
		}
	}

	public void updateProduct() {
		Long fid = findProduct();
		if (fid != null) {
			System.out.print("수정하실 상품번호 선택: ");
			Long pid = scan.nextLong();
			scan.nextLine();
			System.out.print("수정하실 내용 입력: ");
			String updateContents = scan.nextLine();
			ProductDTO updateProduct = fmr.updateProduct(pid, updateContents);
			if (updateProduct != null) {
				System.out.println("수정 후 등록된 상품에 대한 설명은 '" + updateProduct.getpDesc() + "' 입니다");
			} else {
				System.out.println("수정이 불가합니다.");
			}
		} 
	}

	private Long flogin() {
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		Long fid = fmr.flogin(id, pw);
		return fid;
	}

	public void csave() {
		System.out.print("아이디: ");
		String id = scan.next();
		if(!fmr.cDuplicateCheck(id)) {
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("비밀번호: ");
			String pw = scan.next();
			System.out.print("전화번호: ");
			String mobile = scan.next();
			System.out.print("이메일: ");
			String email = scan.next();
			Long cPoint = 0L;
			ClientDTO client = new ClientDTO(++cId, id, name, pw, mobile, email, cPoint);
			if (fmr.csave(client)) {
				System.out.println("회원 가입 완료");
			} else {
				System.out.println("회원 가입 실패");
			}
		} else {
			System.out.println("중복된 아이디 값이 존재합니다.");
		}
	}

	public void cPointCheck() {
		Long cid = clogin();
		if (cid != null) {
			ClientDTO client = fmr.cPointCheck(cid);
			System.out.println("회원님의 잔여 포인트는 " + client.getcPoint() + "원 입니다.");
		} else {
			System.out.println("아이디 또는 비밀번호 확인필요");
		}
	}

	private Long clogin() {
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		Long cid = fmr.clogin(id, pw);
		return cid;
	}

	public void depositPoint() {
		Long cid = clogin();
		if (cid != null) {
			System.out.print("충전할 금액: ");
			Long money = scan.nextLong();
			ClientDTO client = fmr.depositPoint(cid, money);
			System.out.println("충전 후 잔여 포인트는 " + client.getcPoint() + "원 입니다");
		} else {
			System.out.println("아이디 또는 비밀번호 확인 필요");
		}
	}

	public void searchProduct() {
		System.out.print("찾고자 하는 상품이름: ");
		String pName = scan.next();
		List<ProductDTO> productList = fmr.searchProduct(pName);
		for (ProductDTO p : productList) {
			System.out.println(p);
		}
	}

	public void buyProduct() {
		Long cid = clogin();
		if (cid != null) {
			searchProduct();
			System.out.print("구매하고자 하는 상품 번호 입력: ");
			Long pid = scan.nextLong();
			fmr.buyProduct(cid, pid);
		} else {
			System.out.println("아이디 또는 비밀번호 확인 필요");
		}
	}

	public void checkHistory() {
		Long cid = clogin();
		if (cid != null) {
			List<HistoryDTO> historyList = fmr.checkHistory(cid);
			for (HistoryDTO h : historyList) {
				System.out.println(h);
			}
		}
	}

}
