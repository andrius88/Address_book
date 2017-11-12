package lt.vcs.addressbook.api;

public class InputDataValidator {

	public static boolean isValidParamCount(int size, String[] args) {
		if(args.length == size) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidEmail(String email) {
		int length = email.length();
		if(length < 3 && length > 40) {
			return false;
		}
		if(email.contains("@") && !email.startsWith("@") && !email.endsWith("@")) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidMobPhone(String phoneNumber) {
		if(phoneNumber.startsWith("+") && phoneNumber.length() == 12) {
			char[] phoneNums = phoneNumber.toCharArray();
			boolean isValid = true;
			for(int i = 1; i < phoneNums.length; i++) {
				if(!Character.isDigit(phoneNums[i])) {
					isValid = false;
					break;
				}
			}
			if(isValid) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidName(String name) {
		if(name.length() > 2 && name.length() < 40) {
			char[] nameNums = name.toCharArray();
			boolean isValid = true;
			for(int i = 1; i < nameNums.length; i++) {
				if(!Character.isLetter(nameNums[i])) {
					isValid = false;
					break;
				}
			}
			if(isValid == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidId(String idIn){
		if(idIn.matches("\\d+")){
			//System.out.println("ID is ok " +idIn);
			return true;
		} else {
			return false;
		}
		
	}
		
}
