package lt.vcs.addressbook.storage.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

public class JavaxAddressBookReadTestAnd {

	//AddresEntryDao addressEntry = new AddresEntryDao();
	//List<AddresEntryDao> addressEntryList = new ArrayList();
	
	@Test
	public void test() {
	
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    EntityManager entitymanager = emfactory.createEntityManager();
    
    AddresEntryDao addressEntry = entitymanager.find(AddresEntryDao.class, 1201);

    System.out.println("employee ID = " + addressEntry.getId( ));
    System.out.println("employee NAME = " + addressEntry.getName( ));
    System.out.println("employee EMAIL = " + addressEntry.getEmail( ));
    System.out.println("employee PHONE = " + addressEntry.getMobilePhone( ));
    
	}

}
