package lt.vcs.addressbook.storage.javasqlconnection;

import lt.vcs.addressbook.api.IAddresEntry;

public class JavaSqlConnAddressEntry implements IAddresEntry {

	private int addresId;
	private String name;
	private String email;
	private String mobilePhone;
	
	
	public JavaSqlConnAddressEntry(int idIn, String nameIn, String emailIn, String mobileIn){
		this.addresId = idIn;
		this.name = nameIn;
		this.email = emailIn;
		this.mobilePhone = mobileIn;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.mobilePhone = email;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getId() {
		return addresId;
	}

	@Override
	public void setId(int id) {
		this.addresId = id;
	}

}
