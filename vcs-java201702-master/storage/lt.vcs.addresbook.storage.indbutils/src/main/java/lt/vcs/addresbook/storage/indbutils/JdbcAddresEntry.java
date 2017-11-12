package lt.vcs.addresbook.storage.indbutils;

import lt.vcs.addressbook.api.IAddresEntry;

public class JdbcAddresEntry implements IAddresEntry {

	private int addresId;
	private String name;
	private String email;
	private String mobilePhone;
	
	public void setAddresId(int addresId) {
		this.addresId = addresId;
	}
	public int getAddresId() {
		return addresId;
	}
	public int getId() {
		return addresId;
	}
	public void setId(int id) {
		this.addresId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
}
