package lt.vcs.addresbook.storage.inxmlfile.test;

import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import lt.vcs.addresbook.storage.inxmlfile.InXmlFileAddressBookStorage;
import lt.vcs.addressbook.api.IAddresBookStorage;
import lt.vcs.addressbook.api.IAddresEntry;

public class TestInXMLFileAddressBookStorage {

	@Test
	public void test() throws JAXBException {
		IAddresBookStorage store = new InXmlFileAddressBookStorage("C:\\Users\\Andrius\\testAndStorage.xml");
		assertTrue(store.getAllEntries().size()>1);
		for (IAddresEntry e : store.getAllEntries()) {
			System.out.println(e.getName());
		}
	}

}
