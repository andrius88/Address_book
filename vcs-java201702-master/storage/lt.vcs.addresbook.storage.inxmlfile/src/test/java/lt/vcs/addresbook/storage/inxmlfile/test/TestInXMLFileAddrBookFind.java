package lt.vcs.addresbook.storage.inxmlfile.test;

import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import lt.vcs.addresbook.storage.inxmlfile.InXmlFileAddressBookStorage;
import lt.vcs.addresbook.storage.inxmlfile.XmlAddresEntry;
import lt.vcs.addressbook.api.IAddresBookStorage;
import lt.vcs.addressbook.api.IAddresEntry;

public class TestInXMLFileAddrBookFind {

	@Test
	public void test() throws JAXBException {	
	IAddresBookStorage store = new InXmlFileAddressBookStorage("C:\\Users\\Andrius\\testAndStorage.xml");
	assertTrue(store.getAllEntries().size()>1);
	
	IAddresEntry newEntry = new XmlAddresEntry();
	newEntry.setId(1);
	newEntry.setName("nameA");
	newEntry.setEmail("name_a@vcs.com");
	newEntry.setMobilePhone("+23456789012");
	try {
		store.save(newEntry);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	};
	
	for (IAddresEntry e : store.getAllEntries()) {
		System.out.print(e.getId() + " ");
		System.out.print(e.getName() + " ");
		System.out.print(e.getEmail() + " ");
		System.out.println(e.getMobilePhone());
	}
}

	
	
	
}
