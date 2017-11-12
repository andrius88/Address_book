package lt.vcs.addresbook.storage.inxmlfile.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import lt.vcs.addresbook.storage.inxmlfile.XmlAddresBook;
import lt.vcs.addresbook.storage.inxmlfile.XmlAddresEntry;

public class AddressBookXMLMarsallerTest {

	@Test
	public void test() throws JAXBException {
		XmlAddresBook addresBook = new XmlAddresBook();

		XmlAddresEntry addres = new XmlAddresEntry();
		addres.setName("VardasA");
		addres.setMobilePhone("+37069823101");
		addres.setEmail("vardas.a@email.com");
		addres.setId(1);
		
		addresBook.getAddreses().add(addres);
		
		
		addres = new XmlAddresEntry();
		addres.setName("VardasB");
		addres.setMobilePhone("+37069823102");
		addres.setEmail("vardas.b@email.com");
		addres.setId(2);
		
		addresBook.getAddreses().add(addres);
		
		XmlAddresBook.class.getAnnotations();
		JAXBContext context = JAXBContext.newInstance(XmlAddresBook.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(addresBook, System.out);
        m.marshal(addresBook, new File("testAnd.xml"));
		
	}

}
