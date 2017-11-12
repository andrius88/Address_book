package lt.vcs.addresbook.storage.inxmlfile;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lt.vcs.addressbook.api.IAddresEntry;

@XmlRootElement(name = "addresBook")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAddresBook {
	
	@XmlElement(name="addres",type=XmlAddresEntry.class)
	private List<IAddresEntry> addreses = new ArrayList<IAddresEntry>();

	public List<IAddresEntry> getAddreses() {
		return addreses;
	}
	
	public void setAddreses(List<IAddresEntry> addreses) {
		this.addreses = addreses;
	}
}
