package FirstProject_ver4;

public class FreelancerDTO {
	private Long fId;
	private String fMemberId;
	private String fName;
	private String fPw;
	private String fMobile;
	private String fEmail;
	private Long fPoint;
	
	FreelancerDTO(){
		
	}

	public FreelancerDTO(Long fId, String fMemberId, String fName, String fPw, String fMobile, String fEmail,
			Long fPoint) {
		super();
		this.fId = fId;
		this.fMemberId = fMemberId;
		this.fName = fName;
		this.fPw = fPw;
		this.fMobile = fMobile;
		this.fEmail = fEmail;
		this.fPoint = fPoint;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getfMemberId() {
		return fMemberId;
	}

	public void setfMemberId(String fMemberId) {
		this.fMemberId = fMemberId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfPw() {
		return fPw;
	}

	public void setfPw(String fPw) {
		this.fPw = fPw;
	}

	public String getfMobile() {
		return fMobile;
	}

	public void setfMobile(String fMobile) {
		this.fMobile = fMobile;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public Long getfPoint() {
		return fPoint;
	}

	public void setfPoint(Long fPoint) {
		this.fPoint = fPoint;
	}

	@Override
	public String toString() {
		return "FreelancerDTO [전문가번호=" + fId + ", 전문가아이디=" + fMemberId + ", 전문가이름=" + fName + ", 전문가비밀번호=" + fPw
				+ ", 전문가전화번호=" + fMobile + ", 전문가이메일=" + fEmail + ", 전문가포인트=" + fPoint + "]";
	}
	
}
