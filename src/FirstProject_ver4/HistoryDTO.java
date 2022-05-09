package FirstProject_ver4;

public class HistoryDTO {
	private Long hId;
	private Long cId;
	private Long fId;
	private Long pId;
	private String createdTime;
	private String pName;

	HistoryDTO(){
		
	}


	public HistoryDTO(Long hId, Long cId, Long fId, Long pId, String createdTime, String pName) {
		super();
		this.hId = hId;
		this.cId = cId;
		this.fId = fId;
		this.pId = pId;
		this.createdTime = createdTime;
		this.pName = pName;
	}


	public Long gethId() {
		return hId;
	}


	public void sethId(Long hId) {
		this.hId = hId;
	}


	public Long getcId() {
		return cId;
	}


	public void setcId(Long cId) {
		this.cId = cId;
	}


	public Long getfId() {
		return fId;
	}


	public void setfId(Long fId) {
		this.fId = fId;
	}


	public Long getpId() {
		return pId;
	}


	public void setpId(Long pId) {
		this.pId = pId;
	}


	public String getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	@Override
	public String toString() {
		return "HistoryDTO [주문번호 =" + hId + " 고객번호=" + cId + ", 전문가번호=" + fId + ", 상품번호=" + pId + ", 결제된 시간=" + createdTime + ", 상품이름="
				+ pName + "]";
	}
	

}
