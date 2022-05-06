package FirstProject_ver3;

public class ProductDTO {
	private Long pId;
	private Long fId;
	private String pName;
	private String pDesc;
	private Long pPrice;
	private double star;

	ProductDTO() {

	}

	public ProductDTO(Long pId, Long fId, String pName, String pDesc, Long pPrice, double pStar) {
		this.pId = pId;
		this.fId = fId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.star = pStar;
	}

	@Override
	public String toString() {
		return "ProductDTO [상품번호=" + pId + ", 전문가번호=" + fId + ", 상품이름=" + pName + ", 상품설명=" + pDesc + ", 가격="
				+ pPrice + ", 별점=" + String.format("%.2f", star) + "]";
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

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

}
