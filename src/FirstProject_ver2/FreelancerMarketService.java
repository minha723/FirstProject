package FirstProject_ver2;

import java.util.*;

public class FreelancerMarketService {
	Scanner scan = new Scanner(System.in);
	Long cId = 0L, fId = 0L, pId = 0L;
	FreelancerMarketRepository fmr = new FreelancerMarketRepository();

	public void fsave() {
		System.out.print("아이디: ");
		String id = scan.next();
		if (!fmr.duplicateCheck(id)) {
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

	public void flogin() {
		boolean run = true;
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		Long fid = fmr.flogin(id, pw);
		if (fid != null) {
			System.out.println("로그인 성공!");
			while (run) {
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"1. 서비스 등록 | 2. 포인트 확인 | 3. 내 서비스 확인 | 4. 서비스 내용수정 | 5. 서비스 금액수정 | 6. 서비스 삭제 | 7. 판매한 상품보기 | 8. 상품 구매자에게 연락 | 9. 로그아웃");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------");
				System.out.print("메뉴 선택> ");
				int fsel = scan.nextInt();
				if (fsel == 1) {
					register(fid);
				} else if (fsel == 2) {
					pointCheck(fid);
				} else if (fsel == 3) {
					findProduct(fid);
				} else if (fsel == 4) {
					updateProduct(fid);
				} else if (fsel == 5) {
					updateProductPrice(fid);
				} else if (fsel == 6) {
					deleteProduct(fid);
				} else if (fsel == 7) {
					findHistory(fid);
				} else if (fsel == 8) {
					contact(fid);
				} else if (fsel == 9)
					run = false;
			}
		} else {
			System.out.println("로그인 실패!");
		}
	}

	public void register(Long fid) {
		psave(fid);
	}

	public void pointCheck(Long fid) {
		FreelancerDTO flancer = fmr.pointCheck(fid);
		System.out.println("현재 전문가님의 포인트는 " + flancer.getfPoint() + "원 입니다.");
	}

	public boolean findProduct(Long fid) {
		boolean result = false;
		List<ProductDTO> productList = fmr.findProduct(fid);
		if (productList.size() != 0) {
			for (ProductDTO p : productList) {
				System.out.println(p);
			}
			result = true;
		} else {
			System.out.println("등록하신 상품이 없습니다.");
		}
		return result;
	}

	public void updateProduct(Long fid) {
		if (findProduct(fid)) {
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

	public void updateProductPrice(Long fid) {
		if (findProduct(fid)) {
			System.out.print("수정하실 상품번호 선택: ");
			Long pid = scan.nextLong();
			System.out.print("변경하실 금액 입력: ");
			Long updatePrice = scan.nextLong();
			ProductDTO updateProduct = fmr.updateProductPrice(pid, updatePrice);
			if (updateProduct != null) {
				System.out.println("수정 후 등록된 상품에 금액은 '" + updateProduct.getpPrice() + "' 입니다");
			} else {
				System.out.println("수정이 불가합니다.");
			}
		}
	}

	private void deleteProduct(Long fid) {
		if (findProduct(fid)) {
			if (fid != null) {
				System.out.print("삭제하실 상품번호 입력: ");
				Long pid = scan.nextLong();
				ProductDTO updateProduct = fmr.updateProductPrice(pid);
				if (updateProduct != null) {
					System.out.println("선택하신 상품번호 " + pid + "가 삭제 되었습니다.");
				} else {
					System.out.println("선택하신 상품번호를 다시 확인해주세요.");
				}
			}
		}
	}

	private boolean findHistory(Long fid) {
		boolean result = false;
		List<HistoryDTO> historyList = fmr.findHistory(fid);
		if (historyList.size() != 0) {
			for (HistoryDTO h : historyList) {
				System.out.println(h);
			}
			result = true;
		} else {
			System.out.println("판매한 상품이 존재하지 않습니다.");
		}
		return result;
	}

	private void contact(Long fid) {
		if (findHistory(fid)) {
			System.out.print("연락하실 구매자 번호를 입력: ");
			Long cid = scan.nextLong();
			ClientDTO client = fmr.contact(cid);
			if (client != null) {
				System.out.println("선택하신 구매자님의 연락처는 " + client.getcMobile() + "입니다.");
			} else {
				System.out.println("구매자 번호를 확인 하세요.");
			}
		}
	}

	public void csave() {
		System.out.print("아이디: ");
		String id = scan.next();
		if (!fmr.cDuplicateCheck(id)) {
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

	public Long clogin() {
		boolean run = true;
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		Long cid = fmr.clogin(id, pw);
		if (cid != null) {
			System.out.println("로그인 성공!");
			while (run) {
				System.out.println(
						"----------------------------------------------------------------------------------------------");
				System.out.println("1. 잔여 포인트 확인 | 2. 포인트 구매 | 3. 서비스 검색 | 4. 서비스 결제 | 5. 구매한 서비스 | 6. 판매자 연락처 | 7. 로그아웃");
				System.out.println(
						"----------------------------------------------------------------------------------------------");
				System.out.print("메뉴 선택> ");
				int csel = scan.nextInt();
				if (csel == 1) {
					cPointCheck(cid);
				} else if (csel == 2) {
					depositPoint(cid);
				} else if (csel == 3) {
					searchProduct();
				} else if (csel == 4) {
					buyProduct(cid);
				} else if (csel == 5) {
					checkHistory(cid);
				} else if (csel == 6) {
					fContact(cid);
				} else if (csel == 7) {
					run = false;
				}
			}
		} else {
			System.out.println("로그인 실패!");
		}
		return cid;
	}

	public void cPointCheck(Long cid) {
		ClientDTO client = fmr.cPointCheck(cid);
		System.out.println("회원님의 잔여 포인트는 " + client.getcPoint() + "원 입니다.");
	}

	public void depositPoint(Long cid) {
		System.out.print("충전할 금액: ");
		Long money = scan.nextLong();
		ClientDTO client = fmr.depositPoint(cid, money);
		System.out.println("충전 후 잔여 포인트는 " + client.getcPoint() + "원 입니다");
	}
	public boolean searchProduct() {
		boolean result = false;
		System.out.print("찾고자 하는 상품이름: ");
		String pName = scan.next();
		List<ProductDTO> productList = fmr.searchProduct(pName);
		if (productList.size() > 0) {
			for (ProductDTO p : productList) {
				System.out.println(p);
				result = true;
			}
		} else {
			System.out.println("찾으시는 상품이 없습니다.");
		}
		return result;
	}

	
	public void buyProduct(Long cid) {
		if (searchProduct()) {
			System.out.print("구매하고자 하는 상품 번호 입력: ");
			Long pid = scan.nextLong();
			fmr.buyProduct(cid, pid);
		}
	}
	public boolean checkHistory(Long cid) {
		boolean result = false;
		List<HistoryDTO> historyList = fmr.checkHistory(cid);
		if (historyList.size() > 0) {
			for (HistoryDTO h : historyList) {
				System.out.println(h);
			}
			result = true;
		} else {
			System.out.println("구매내역이 없습니다.");
		}
		return result;
	}
	
	private void fContact(Long cid) {
		if (checkHistory(cid)) {
			System.out.print("연락하실 판매자 번호를 입력: ");
			Long fid = scan.nextLong();
			FreelancerDTO freelancer = fmr.fContact(fid);
			if (freelancer != null) {
				System.out.println("선택하신 판매자님의 전화번호: " + freelancer.getfMobile() + " 이메일: " + freelancer.getfEmail());
			} else {
				System.out.println("판매자 번호를 확인 하세요.");
			}
		}

	}


	public void manager() {
		boolean run = true;
		String mid = "robyn", mpw = "1234";
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		if (mid.equals(id) && mpw.equals(pw)) {
			System.out.println("로그인 성공!");
			while (run) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("1. 전문가 리스트 |2. 등록된 상품 확인 |3. 고객 리스트 |4. 결제된 상품 리스트 |5. 로그아웃");
				System.out.println("---------------------------------------------------------------------");
				System.out.print("메뉴 선택> ");
				int msel = scan.nextInt();
				if (msel == 1) {
					List<FreelancerDTO> freeList = fmr.findAllFree();
					if (freeList.size() > 0) {
						for (FreelancerDTO f : freeList) {
							System.out.println(f);
						}
					} else {
						System.out.println("등록된 전문가가 없습니다.");
					}
				}
				if (msel == 2) {
					List<ProductDTO> productList = fmr.findAllProduct();
					if (productList.size() > 0) {
						for (ProductDTO p : productList) {
							System.out.println(p);
						}
					} else {
						System.out.println("등록된 상품이 없습니다.");
					}
				}
				if (msel == 3) {
					List<ClientDTO> clientList = fmr.findAllClient();
					if (clientList.size() > 0) {
						for (ClientDTO c : clientList) {
							System.out.println(c);
						}
					} else {
						System.out.println("가입한 회원이 없습니다.");
					}
				}
				if (msel == 4) {
					List<HistoryDTO> historyList = fmr.findAllHistory();
					if (historyList.size() > 0) {
						for (HistoryDTO h : historyList) {
							System.out.println(h);
						}
					} else {
						System.out.println("판매 내역이 없습니다.");
					}
				}
				if (msel == 5) {
					run = false;
				}
			}
		} else {
			System.out.println("로그인 실패!");
		}
	}
}
