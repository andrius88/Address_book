package lt.vcs.addresbook.storage.inmemory;

import lt.vcs.addressbook.api.IAddresEntry;

public class AddresInMemory implements IAddresEntry {

	private int id;
	private String name;
	private String email;
	private String mobilePhone;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getMobilePhone() {
		return mobilePhone;
	}

	@Override
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
