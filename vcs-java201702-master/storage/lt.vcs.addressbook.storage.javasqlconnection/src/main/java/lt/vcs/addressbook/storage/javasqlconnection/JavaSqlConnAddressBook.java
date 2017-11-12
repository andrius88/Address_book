package lt.vcs.addressbook.storage.javasqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lt.vcs.addresbook.storage.inmemory.InMemoryAddressBook;
import lt.vcs.addressbook.api.IAddresEntry;

public class JavaSqlConnAddressBook extends InMemoryAddressBook{

	private Connection conn;
	
	public JavaSqlConnAddressBook(){
		try {
            // create our mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/address_book";
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "root", "sysop");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	@Override
	public List<IAddresEntry> getAllEntries() {
		List<IAddresEntry> list = new ArrayList<>();
		Statement st;
		 try {
	            st = conn.createStatement();
	            String sql = ("SELECT * FROM contacts;");
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	int id = rs.getInt("id");
	            	String name = rs.getString("name");
	            	String email = rs.getString("email");
	            	String mobile = rs.getString("mobilePhone");
	            	
	            	IAddresEntry entry = new JavaSqlConnAddressEntry(id, name, email, mobile);
	            	list.add(entry);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	}	
	
	
	@Override
	public void save(IAddresEntry entry) {
		String name = entry.getName();
		String email = entry.getEmail();
		String phone = entry.getMobilePhone();
		Statement statement;
		
		 try {
			 statement = conn.createStatement();
	         String sql ="INSERT INTO contacts (name, email, mobilePhone)" +
	            			 "VALUES ('" + name + "', '" + email + "', '" + phone + "')";
	         statement.executeUpdate(sql);
	     } catch (SQLException e) {
	            e.printStackTrace();
	     }
	}

	
	@Override
	public boolean removeEntryById(int removeId) {
		Statement statement;
		String sql;
		
		try {
			 statement = conn.createStatement();
	         sql = "DELETE FROM contacts WHERE id = " + removeId;
	         statement.executeUpdate(sql);
	         return true;
	     } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	     }
	}

	public boolean updateById(IAddresEntry entry){
		int idToModify = entry.getId();
		String name = entry.getName();
		String email = entry.getEmail();
		String phone = entry.getMobilePhone();
		Statement statement;
		String sql;
		
		try{
			statement = conn.createStatement();
	        sql = "UPDATE contacts SET name = '" + name + "', email = '" + email 
	        		+ "', mobilePhone = '" + phone + "' WHERE id = " + idToModify;
	        //System.out.println(sql);
	        statement.executeUpdate(sql);
	        return true;
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
		}
	}

	@Override 
	public List<IAddresEntry> findEntriesByName(String name) {
		List<IAddresEntry> list = new ArrayList<>();
		Statement st;
		 try {
	            st = conn.createStatement();
	            String sql = ("SELECT * FROM contacts WHERE name like '%" + name + "%'");
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	int id = rs.getInt("id");
	            	String name1 = rs.getString("name");
	            	String email = rs.getString("email");
	            	String mobile = rs.getString("mobilePhone");
	            	
	            	IAddresEntry entry = new JavaSqlConnAddressEntry(id, name1, email, mobile);
	            	list.add(entry);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public List<IAddresEntry> findEntriesByEmail(String email) {
		List<IAddresEntry> list = new ArrayList<>();
		Statement st;
		 try {
	            st = conn.createStatement();
	            String sql = ("SELECT * FROM contacts WHERE email like '%" + email + "%'");
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	int id = rs.getInt("id");
	            	String name1 = rs.getString("name");
	            	String email1 = rs.getString("email");
	            	String mobile = rs.getString("mobilePhone");
	            	
	            	IAddresEntry entry = new JavaSqlConnAddressEntry(id, name1, email1, mobile);
	            	list.add(entry);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public List<IAddresEntry> findEntryByPhone(String phone) {
		List<IAddresEntry> list = new ArrayList<>();
		Statement st;
		 try {
	            st = conn.createStatement();
	            String sql = ("SELECT * FROM contacts WHERE mobilePhone like '%" + phone + "%'");
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	int id = rs.getInt("id");
	            	String name1 = rs.getString("name");
	            	String email1 = rs.getString("email");
	            	String mobile = rs.getString("mobilePhone");
	            	
	            	IAddresEntry entry = new JavaSqlConnAddressEntry(id, name1, email1, mobile);
	            	list.add(entry);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public List<IAddresEntry> findEntryById(int idIn) {
		List<IAddresEntry> list = new ArrayList<>();
		Statement st;
		 try {
	            st = conn.createStatement();
	            String sql = ("SELECT * FROM contacts WHERE id = " + idIn);
	            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()){
	            	int id = rs.getInt("id");
	            	String name1 = rs.getString("name");
	            	String email1 = rs.getString("email");
	            	String mobile = rs.getString("mobilePhone");
	            	
	            	IAddresEntry entry = new JavaSqlConnAddressEntry(id, name1, email1, mobile);
	            	list.add(entry);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
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
	
}
