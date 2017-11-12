package lt.vcs.addressbook.api;

import java.util.Collection;
import java.util.List;

public interface IAddresBookStorage {
	public void save(IAddresEntry entry) throws Exception;
	
	public void save() throws Exception;	// somehow it is necessary

	public Collection<IAddresEntry> getAllEntries();

	public Collection<IAddresEntry> findEntriesByName(String name);

	public Collection<IAddresEntry> findEntriesByEmail(String email);
	
	public List<IAddresEntry> findEntryByPhone(String phoneNoIn);
	
	public List<IAddresEntry> findEntryById(String idInStr);
	
	public List<IAddresEntry> findEntryById(int idInInt);	// neaisku ar reikalingas

	public boolean removeEntryById(int removeId) throws Exception;

	public boolean updateById(IAddresEntry entry);

	
}
