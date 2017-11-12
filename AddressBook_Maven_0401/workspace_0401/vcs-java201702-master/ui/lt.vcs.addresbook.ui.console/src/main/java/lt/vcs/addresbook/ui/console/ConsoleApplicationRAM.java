package lt.vcs.addresbook.ui.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

import lt.vcs.addresbook.storage.inmemory.InMemoryAddressBook;
//import lt.vcs.addresbook.storage.inxmlfile.InXmlFileAddressBookStorage;
import lt.vcs.addresbook.storage.inxmlfile.XmlAddresEntry;
import lt.vcs.addressbook.api.IAddresBookStorage;
import lt.vcs.addressbook.api.IAddresEntry;
import lt.vcs.addressbook.api.InputDataValidator;

public class ConsoleApplicationRAM {

	public static void main(String[] args) throws JAXBException {

		System.out.println("Wellcome to the Notebook app!");
		System.out.println("Please enter one of keywords: ");
		System.out.println("Help, Add, Show_all, find_by_Name, find_by_eMAIL"
				+ " find_by_PHone, find_by_ID, Edit, Remove or Quit");
		System.out.println("\nTo enter a new enry plyse type NAME EMAIL PHONE_NR");
		System.out.println("Entering data should be separated by one space charackter");
		// parameters[0] - command, parameters[1] - name, parameters[2] -
		// e-mail, parameters[3] - phone

		// AddressBook addressbook = new InFileAddressBook();
		// AddressBook addressbook = new InMemoryAddressBook();
		//IAddresBookStorage addressbook = new InXmlFileAddressBookStorage("C:\\Users\\Andrius\\_testAndStorage.xml");
		//IAddresBookStorage addressbook = new InXmlFileAddressBookStorage("..\\..\\testAndStorage.xml");
		
		IAddresBookStorage addressbook = new InMemoryAddressBook();

		Scanner in = new Scanner(System.in);
		while (true) {

			String line = in.nextLine();
			String[] parameters = line.split(" ");
			String command = parameters[0];

			if ("ADD".equalsIgnoreCase(command) || "A".equalsIgnoreCase(command)) {
				add(parameters, addressbook);
			} else if ("SHOW_ALL".equalsIgnoreCase(command) || "S".equalsIgnoreCase(command)) {
				showAll(parameters, addressbook);
			} else if ("FIND_BY_NAME".equalsIgnoreCase(command) || "N".equalsIgnoreCase(command)) {
				findByName(parameters, addressbook);
			} else if ("FIND_BY_PHONE".equalsIgnoreCase(command) || "PH".equalsIgnoreCase(command)) {
				findByMobNumber(parameters, addressbook);
			} else if ("FIND_BY_EMAIL".equalsIgnoreCase(command) || "MAIL".equalsIgnoreCase(command)) {
				findByEmail(parameters, addressbook);
			} else if ("FIND_BY_ID".equalsIgnoreCase(command) || "ID".equalsIgnoreCase(command)) {
				findById(parameters, addressbook);
			} else if ("EDIT".equalsIgnoreCase(command) || "E".equalsIgnoreCase(command)) {
				editById(parameters, addressbook);
			} else if ("REMOVE".equalsIgnoreCase(command) || "R".equalsIgnoreCase(command)) {
				removeById(parameters, addressbook);
			} else if ("HELP".equalsIgnoreCase(command) || "H".equalsIgnoreCase(command)) {
				System.out.println("Valid keyvords & shortcuts: \nHelp, Add, Show_all, find_by_Name, "
						+ "find_by_eMAIL, find_by_PHone, find_by_ID, Edit, Rremove " + "or Quit");
			} else if ("QUIT".equalsIgnoreCase(command) || "Q".equalsIgnoreCase(command)) {
				System.out.println("You entered \'Q\' or \'QUIT\'. The program is quiting");
				in.close(); // input string is closed
				break;
			} else {
				System.out.println("Command not recognized, please reentrer command");
			}
		}
	}

	public static void showAll(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(1, params)) {
			System.out.println("Perform showAll action");
			List<IAddresEntry> allList = (List<IAddresEntry>) addressbook.getAllEntries();
			pintList(allList);
		} else {
			System.out.println("ShowAll: Wrong number of parameters were passed");
		}
	}

	public static void add(String[] params, IAddresBookStorage addressbook) {

		if (InputDataValidator.isValidParamCount(4, params)) {
			String name = params[1];
			String email = params[2];
			String mobilePhone = params[3];

			if (!InputDataValidator.isValidName(name)) {
				System.out.println("Name is invalid");
			} else if (!InputDataValidator.isValidEmail(email)) {
				System.out.println("Email is invalid");
			} else if (!InputDataValidator.isValidMobPhone(mobilePhone)) {
				System.out.println("Mob phone is invalid");
			} else {
				IAddresEntry entry = new XmlAddresEntry();
				entry.setName(name);
				entry.setEmail(email);
				entry.setMobilePhone(mobilePhone);
				try {
					addressbook.save(entry);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println("add: add action was performed");
			}
		} else {
			System.out.println("add: Wrong number of parameters was passed");
		}
	}

	public static void removeById(String[] params, IAddresBookStorage addressbook) {
		String idInStr = "1"; // default value
		if (InputDataValidator.isValidParamCount(2, params)) {
			idInStr = params[1];
			try {
				// System.out.println("Remove ID is:" + idInStr);
				// if (InputDataValidator.isValidId(idInStr)){ // checks if ID is a number
				int removeId = Integer.parseInt(idInStr); // gets ID to remove
				boolean wasRemoved = false;

				try {
					wasRemoved = addressbook.removeEntryById(removeId);
				} catch (Exception e) {
					System.out.println("Exception ocured trying to removeById: " + removeId);
					e.printStackTrace();
				}

				if (wasRemoved) {
					System.out.println("Entry with ID:" + removeId + " was removed");
				} else {
					System.out.println("To remove Entry with ID: " + removeId + " was impossible");
					System.out.println("Please enter valid ID (Show_all command)");
				}
			} catch (NumberFormatException e) {
				System.err.println("removeById: wrong format of ID was entered, please retray");
				System.err.println("IndexOutOfBoundsException: " + e.getMessage());
			}
		} else {
			System.out.println("removeById: wrong number of parameters was passed");
		}
	}

	public static void findByName(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(2, params)) {
			String nameIn = params[1];
			if (!InputDataValidator.isValidName(nameIn)) {
				System.out.println("Name is invalid");
				System.out.println("Name has to have 3 charackers at least");
			} else {
				List<IAddresEntry> list = new ArrayList<IAddresEntry>();
				list = (List<IAddresEntry>) addressbook.findEntriesByName(nameIn);
				System.out.println("Lits by name was recieved and will be printed");
				pintList(list);
			}
		} else {
			System.out.println("Find_by_name: Wrong number of parameters was passed");
		}
	}

	public static void findByEmail(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(2, params)) {
			String emailIn = params[1];
			if (!InputDataValidator.isValidEmail(emailIn)) {
				System.out.println("Email is invalid");
				System.out.println("Email has to have 3 characters at least and contain '@' characker");
			} else {
				List<IAddresEntry> list = new ArrayList<IAddresEntry>();
				list = (List<IAddresEntry>) addressbook.findEntriesByEmail(emailIn);
				System.out.println("Lits by name was recieved and will be printed");
				pintList(list);
			}
		} else {
			System.out.println("Find_by_email: Wrong number of parameters was passed");
		}
	}

	public static void findByMobNumber(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(2, params)) {
			String phoneNoIn = params[1];
			if (!InputDataValidator.isValidMobPhone(phoneNoIn)) {
				System.out.println("Phone number is invalid.");
				System.out.println("Phone number has to start with '+' and conatin 12 digits");
			} else {
				List<IAddresEntry> list = new ArrayList<IAddresEntry>();
				list = addressbook.findEntryByPhone(phoneNoIn);
				System.out.println("Lits by name was recieved and will be printed");
				pintList(list);
			}
		} else {
			System.out.println("Find_by_phone: Wrong number of parameters was passed");
		}
	}

	public static void findById(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(2, params)) {
			String idInStr = params[1];
			if (!InputDataValidator.isValidId(idInStr)) { // checks is ID is a
															// number
				System.out.println("Id is invalid");
				System.out.println("Id has to some integer number existing in the list (Show_all command)");
			} else {
				int idInInt = Integer.parseInt(idInStr);
				List<IAddresEntry> list = new ArrayList<IAddresEntry>();
				list = addressbook.findEntryById(idInInt);
				// System.out.println("findById: Lits by ID was recieved and
				// will be printed");
				pintList(list);
			}
		} else {
			System.out.println("Find_by_ID: Wrong number of parameters was passed");
		}
	}

	public static void editById(String[] params, IAddresBookStorage addressbook) {
		if (InputDataValidator.isValidParamCount(5, params)) {
			String idInStr = params[1];
			String name = params[2];
			String email = params[3];
			String mobilePhone = params[4];

			if (!InputDataValidator.isValidId(idInStr)) { // checks if ID is a
															// number
				System.out.println("Id is invalid");
			} else if (!InputDataValidator.isValidName(name)) {
				System.out.println("Name is invalid");
			} else if (!InputDataValidator.isValidEmail(email)) {
				System.out.println("Email is invalid");
			} else if (!InputDataValidator.isValidMobPhone(mobilePhone)) {
				System.out.println("Mob phone is invalid");
			} else {
				int idInInt = Integer.parseInt(idInStr); // current ID as
															// integer
				if (addressbook.findEntryById(idInInt).size() > 0) {
					addressbook.findEntryById(idInInt).get(0).setName(name);
					addressbook.findEntryById(idInInt).get(0).setEmail(email);
					addressbook.findEntryById(idInInt).get(0).setMobilePhone(mobilePhone);

					try {
						addressbook.save();
						System.out.println("Edit_by_ID: edited entry was saved to file");
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("editById: Entry with ID:" + idInInt + " was modified");
				} else {
					System.out.println("editById: Entry with ID:" + idInInt + " was not found. No entry was modified");
				}
			}
		} else {
			System.out.println("Edit_by_ID: Wrong number of parameters was passed");
		}
	}

	public static void pintList(List<IAddresEntry> listIn) {
		System.out.println("List of entries:");
		System.out.println("Id \tName \tE-mail \tPhoneNo");
		for (IAddresEntry entr : listIn) {
			System.out.println(
					entr.getId() + "\t" + entr.getName() + "\t" + entr.getEmail() + "\t" + entr.getMobilePhone());
		}
	}

}
