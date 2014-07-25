package java56.vo;

public class Member {
	protected int       no;
	protected String    name;
	protected String    password;
	protected String    email;
	protected String    tel;
	protected char      valid;
	protected String	photoPath;

	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", tel=" + tel + ", valid=" + valid
				+ ", photoPath=" + photoPath + "]";
	}
	public int getNo() {
		return no;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public char getValid() {
		return valid;
	}
	public void setValid(char valid) {
		this.valid = valid;
	}


}
