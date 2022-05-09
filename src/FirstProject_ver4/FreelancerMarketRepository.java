package FirstProject_ver4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FreelancerMarketRepository {
	static List<ClientDTO> clientList = new ArrayList<>();
	static List<FreelancerDTO> freeList = new ArrayList<>();
	static List<ProductDTO> productList = new ArrayList<>();
	static List<HistoryDTO> historyList = new ArrayList<>();
	static List<HistoryDTO> historyStarList = new ArrayList<>();
	static List<ProductDTO> deleteProductList = new ArrayList<>();

	Long hId = 0L;
	
	public boolean save(FreelancerDTO freelancer) {
		return freeList.add(freelancer);
	}

	public Long flogin(String id, String pw) {
		Long fid = null;
		for (FreelancerDTO f : freeList) {
			if (id.equals(f.getfMemberId()) && pw.equals(f.getfPw())) {
				fid = f.getfId();
			}
		}
		return fid;
	}

	public boolean psave(ProductDTO product) {
		return productList.add(product);
	}

	public FreelancerDTO pointCheck(Long fid) {
		FreelancerDTO flancer = null;
		for (FreelancerDTO f : freeList) {
			if (fid.equals(f.getfId())) {
				flancer = f;
			}
		}
		return flancer;
	}

	public List<ProductDTO> findProduct(Long fid) {
		List<ProductDTO> findProductList = new ArrayList<>();
		for (ProductDTO p : productList) {
			if (fid.equals(p.getfId())) {
				findProductList.add(p);
			}
		}
		return findProductList;
	}

	public ProductDTO updateProduct(Long fid, Long pid, String updateContents) {
		ProductDTO updateP = null;
		for (ProductDTO p : productList) {
			if (pid.equals(p.getpId()) && fid.equals(p.getfId())) {
				p.setpDesc(updateContents);
				updateP = p;
			}
		}
		return updateP;
	}

	public boolean csave(ClientDTO client) {
		return clientList.add(client);
	}

	public Long clogin(String id, String pw) {
		Long cid = null;
		for (ClientDTO c : clientList) {
			if (id.equals(c.getcMemberId()) && pw.equals(c.getcPw())) {
				cid = c.getcId();
			}
		}
		return cid;
	}

	public ClientDTO cPointCheck(Long cid) {
		ClientDTO client = null;
		for (ClientDTO c : clientList) {
			if (cid.equals(c.getcId())) {
				client = c;
			}
		}
		return client;
	}

	public ClientDTO depositPoint(Long cid, Long money) {
		ClientDTO client = null;
		for (ClientDTO c : clientList) {
			if (cid.equals(c.getcId())) {
				c.setcPoint(c.getcPoint() + money);
				client = c;
			}
		}
		return client;
	}

	public List<ProductDTO> searchProduct(String pName) {
		List<ProductDTO> sProduct = new ArrayList<>();
		for (ProductDTO p : productList) {
			if (pName.equals(p.getpName())) {
				sProduct.add(p);
			}
		}
		return sProduct;
	}

	public ProductDTO buyProduct(Long cid, Long pid) {
		ProductDTO product = null;
		Long fid = null, pPrice = null;
		for (ProductDTO p : productList) {
			if (pid.equals(p.getpId())) {
				fid = p.getfId();
				pPrice = p.getpPrice();
				String pName = p.getpName();
				product = p;
				for (ClientDTO c : clientList) {
					if (cid.equals(c.getcId())) {
						if (c.getcPoint() > pPrice) {
							c.setcPoint(c.getcPoint() - pPrice);
							for (FreelancerDTO f : freeList) {
								if (fid.equals(f.getfId())) {
									f.setfPoint(f.getfPoint() + pPrice);
								}
							}
							HistoryDTO history = new HistoryDTO(++hId, cid, fid, pid, createTime(), pName);
							historyStarList.add(history);
							historyList.add(history);
							System.out.println("구매 성공!");
						} else {
							System.out.println("잔액이 부족합니다.");
						}
					}
				}
			}
		}
		return product;
	}

	private String createTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		String createdDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss"));
		return createdDate;
	}

	public List<HistoryDTO> checkHistory(Long cid) {
		List<HistoryDTO> history1 = new ArrayList<>();
		for (HistoryDTO h : historyList) {
			if (cid.equals(h.getcId())) {
				history1.add(h);
			}
		}
		return history1;
	}

	public boolean duplicateCheck(String id) {
		boolean check = false;
		for (FreelancerDTO f : freeList) {
			if (id.equals(f.getfMemberId())) {
				check = true;
			}
		}
		return check;
	}

	public boolean cDuplicateCheck(String id) {
		boolean check = false;
		for (ClientDTO c : clientList) {
			if (id.equals(c.getcMemberId())) {
				check = true;
			}
		}
		return check;
	}

	public ProductDTO updateProductPrice(Long fid, Long pid, Long updatePrice) {
		ProductDTO updateP = null;
		for (ProductDTO p : productList) {
			if (pid.equals(p.getpId()) && fid.equals(p.getfId())) {
				p.setpPrice(updatePrice);
				updateP = p;
			}
		}
		return updateP;
	}

	public ProductDTO deleteProduct(Long fid, Long pid) {
		ProductDTO deleteP = null;
		for (int i = 0; i < productList.size(); i++) {
			if (pid.equals(productList.get(i).getpId())&& fid.equals(productList.get(i).getfId())) {
				deleteP = productList.get(i);
				deleteProductList.add(productList.get(i));
				productList.remove(i);
			}
		}
		return deleteP;
	}

	public List<HistoryDTO> findHistory(Long fid) {
		List<HistoryDTO> history = new ArrayList<>();
		for (HistoryDTO h : historyList) {
			if (fid.equals(h.getfId())) {
				history.add(h);
			}
		}
		return history;
	}

	public ClientDTO contact(Long cid) {
		ClientDTO client = null;
		for (ClientDTO c : clientList) {
			if (cid.equals(c.getcId())) {
				client = c;
			}
		}
		return client;
	}

	public FreelancerDTO fContact(Long fid) {
		FreelancerDTO freelancer = null;
		for (FreelancerDTO f : freeList) {
			if (fid.equals(f.getfId())) {
				freelancer = f;
			}
		}
		return freelancer;
	}

	public List<FreelancerDTO> findAllFree() {
		return freeList;
	}

	public List<ProductDTO> findAllProduct() {
		return productList;
	}

	public List<ClientDTO> findAllClient() {
		return clientList;
	}

	public List<HistoryDTO> findAllHistory() {
		return historyList;
	}

	public boolean inputStar(Long hid, double star, Long cid) {
		boolean result = false;
		Long pid = 0L;
		for(HistoryDTO h: historyList) {
			if(hid.equals(h.gethId()) && cid.equals(h.getcId())) {
				pid = h.getpId();
			}
		}
		for (ProductDTO p : productList) {
			if (pid.equals(p.getpId()) && p.getStar() == 0) {
				p.setStar(star);
				result = true;
			} else if (pid.equals(p.getpId()) && p.getStar() != 0) {
				p.setStar((p.getStar() + star) / 2);
				result = true;
			}
		}
		return result;
	}

	public void deleteList(Long hid) {
		for (int i = 0; i < historyStarList.size(); i++) {
			if (hid.equals(historyStarList.get(i).gethId())) {
				historyStarList.remove(i);
			}
		}
	}

	public List<HistoryDTO> checkStarHistory(Long cid) {
		List<HistoryDTO> history1 = new ArrayList<>();
		for (HistoryDTO h : historyStarList) {
			if (cid.equals(h.getcId())) {
				history1.add(h);
			}
		}
		return history1;
	}

	public List<ProductDTO> deleteProductList() {
		return deleteProductList;
	}

}
