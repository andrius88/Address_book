package lt.vcs.addressbook.storage.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lt.vcs.addressbook.api.IAddresEntry;

@Entity
@Table(name="address")
public class AddresEntryDao implements IAddresEntry {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int addresId=1;
	
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="mobilePhone")
	private String mobilePhone;
	
	public void setAddresId(int addresId) {
		this.addresId = addresId;
	}
	public int getAddresId() {
		return addresId;
	}
	@Override
	public int getId() {
		return addresId;
	}
	@Override
	public void setId(int id) {
		this.addresId = id;
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
