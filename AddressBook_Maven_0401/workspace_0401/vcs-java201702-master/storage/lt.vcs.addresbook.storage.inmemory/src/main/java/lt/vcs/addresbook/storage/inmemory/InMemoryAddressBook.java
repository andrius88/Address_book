package lt.vcs.addresbook.storage.inmemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import lt.vcs.addressbook.api.IAddresBookStorage;
import lt.vcs.addressbook.api.IAddresEntry;

public class InMemoryAddressBook implements IAddresBookStorage {
	
	protected List<IAddresEntry> list = new ArrayList<>();
	
	private Comparator<IAddresEntry> compareByName = new Comparator<IAddresEntry>() {
		
		@Override
		public int compare(IAddresEntry o1, IAddresEntry o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	};
	

	@Override
	public void save(IAddresEntry entry) throws Exception{
		int newId = getIncrementedId();
		entry.setId(newId);
		list.add(entry);
		System.out.println("List size: " + list.size());
	}

	
	@Override
	public Collection<IAddresEntry> getAllEntries() {
		return list;
	}

	@Override
	public List<IAddresEntry> findEntryById(int idInInt) {
		List<IAddresEntry> returnedEntries = new ArrayList<>();
		for(IAddresEntry entry1 : list) {
			if(entry1.getId() == idInInt) {
				returnedEntries.add(entry1);
			}
		}
		return returnedEntries;
	}

	@Override
	public Collection<IAddresEntry> findEntriesByName(final String name) {
		
		//buves kodas
		/*List<IAddresEntry> returnedEntries = new ArrayList<>();
		for(IAddresEntry entry1 : list) {
			if(entry1.getName().contains(name)) {
				returnedEntries.add(entry1);
			}
		}*/
		
		//Naudojame https://commons.apache.org/proper/commons-collections/
		//AnalogiÅ�kai pamÄ—ginkite padayti ir su findEntriesByEmail
		//Cia panaudotos annonymous class 
		//placiau apie tai https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
		//jeigu kils klausimu ar naiÅ�kumÅ³ raÅ�ykite per slack arba bÅ«tinai klausikte kai susitiksime
		
		return CollectionUtils.select(list, new Predicate<IAddresEntry>() {
			@Override
			public boolean evaluate(IAddresEntry address) {
				return address.getName().contains(name);
			}
		});
	}


	@Override
	public Collection<IAddresEntry> findEntriesByEmail(String email) {
		List<IAddresEntry> returnedEntries = new ArrayList<>();
		for(IAddresEntry entry1 : list) {
			if(entry1.getEmail().contains(email)) {
				returnedEntries.add(entry1);
			}
		}
		return returnedEntries;
	}

	@Override
	public List<IAddresEntry> findEntryByPhone(String phoneNoIn) {
		List<IAddresEntry> returnedEntries = new ArrayList<>();
		for(IAddresEntry entry1 : list) {
			if(entry1.getMobilePhone().contains(phoneNoIn)) {
				returnedEntries.add(entry1);
			}
		}
		return returnedEntries;
	}

	@Override
	public boolean removeEntryById(int removeId) throws Exception {
		//List<IAddresEntry> returnedEntries = new ArrayList<>();
		boolean returnValue = false;
		for(IAddresEntry entry1 : list) {
			if(entry1.getId() == removeId) {
				list.remove(entry1);
				returnValue = true;
				break;
			} else {
				returnValue = false;
			}
		}
		return returnValue;
	}

	
	private int getIncrementedId() {
		int max = 0;
		if(list.size() > 0) {
			max = list.get(0).getId();
			for(IAddresEntry entr : list) {
				if(max < entr.getId()) {
					max = entr.getId();
				}
			}
		} 
		return max + 1;
	}


	@Override
	public void save() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override		// not necesary but requred by yhe Interface
	public List<IAddresEntry> findEntryById(String idInStr) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override		// not necesary but requred by yhe Interface
	public boolean updateById(IAddresEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
