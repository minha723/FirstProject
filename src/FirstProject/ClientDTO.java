package FirstProject;

public class ClientDTO {
	private Long cId;
	private String cMemberId;
	private String cName;
	private String cPw;
	private String cMobile;
	private String cEmail;
	private Long cPoint;

	ClientDTO() {

	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcMemberId() {
		return cMemberId;
	}

	public void setcMemberId(String cMemberId) {
		this.cMemberId = cMemberId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcMobile() {
		return cMobile;
	}

	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public Long getcPoint() {
		return cPoint;
	}

	public void setcPoint(Long cPoint) {
		this.cPoint = cPoint;
	}

	@Override
	public String toString() {
		return "ClientDTO [cId=" + cId + ", cMemberId=" + cMemberId + ", cName=" + cName + ", cPw=" + cPw + ", cMobile="
				+ cMobile + ", cEmail=" + cEmail + ", cPoint=" + cPoint + "]";
	}

	public ClientDTO(Long cId, String cMemberId, String cName, String cPw, String cMobile, String cEmail, Long cPoint) {
		this.cId = cId;
		this.cMemberId = cMemberId;
		this.cName = cName;
		this.cPw = cPw;
		this.cMobile = cMobile;
		this.cEmail = cEmail;
		this.cPoint = cPoint;
	}
	
}
