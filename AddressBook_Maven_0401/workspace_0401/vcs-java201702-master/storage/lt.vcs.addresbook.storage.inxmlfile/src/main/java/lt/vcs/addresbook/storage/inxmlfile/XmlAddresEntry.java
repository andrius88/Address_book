package lt.vcs.addresbook.storage.inxmlfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lt.vcs.addressbook.api.IAddresEntry;

@XmlRootElement(name="addres")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAddresEntry implements IAddresEntry {
	@XmlAttribute(name="id")
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute(name="phone")
	private String mobilePhone;
	@XmlAttribute
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
