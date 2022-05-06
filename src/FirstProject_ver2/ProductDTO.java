package FirstProject_ver2;

public class ProductDTO {
	private Long pId;
	private Long fId;
	private String pName;
	private String pDesc;
	private Long pPrice;
	
	ProductDTO(){
		
	}

	public ProductDTO(Long pId, Long fId, String pName, String pDesc, Long pPrice) {
		this.pId = pId;
		this.fId = fId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public Long getpPrice() {
		return pPrice;
	}

	public void setpPrice(Long pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "ProductDTO [pId=" + pId + ", fId=" + fId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPrice="
				+ pPrice + "]";
	}
	
}
