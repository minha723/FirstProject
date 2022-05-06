package FirstProject_ver2;

public class HistoryDTO {
	private Long cId;
	private Long fId;
	private Long pId;
	private String createdTime;
	private String pName;

	HistoryDTO(){
		
	}

	public HistoryDTO(Long cId, Long fId, Long pId, String createdTime, String pName) {
		super();
		this.cId = cId;
		this.fId = fId;
		this.pId = pId;
		this.createdTime = createdTime;
		this.pName = pName;
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
		return "HistoryDTO [cId=" + cId + ", fId=" + fId + ", pId=" + pId + ", createdTime=" + createdTime + ", pName="
				+ pName + "]";
	}
	

}
