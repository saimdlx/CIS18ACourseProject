import java.util.*;


interface UserInterface {
	
	void outputMenu();
	void createTicket(RepairTicket n);
	void viewTicket(RepairTicket x);
	
}

class RepairTicket {
	
	String issue; 
	String deviceType;
	String MM;
	String DD;
	private String email;
	
	
	RepairTicket() {
		issue = "N/A";
		deviceType = "N/A";
		email = "N/A";
		MM = "N/A";
		DD = "N/A";
	}
	
	RepairTicket(String i, String dT, String userEmail, String month, String day) {
		issue = i;
		deviceType = dT;
		email = userEmail;
		MM = month;
		DD = day;
	}
	
	public void setIssue(String i) {
		issue = i;
	}
	public void setDeviceType(String dtype) {
		deviceType = dtype;
	}
	public void setEmail(String sEmail) {
		email = sEmail;
	}
	public void setDay(String sDay) {
		DD = sDay;
	}
	public void setMonth(String sMonth) {
		MM = sMonth;
	}
	
	public String getIssue() {
		return issue;
	}
	public String getDevice() {
		return deviceType;
	}
	public String getEmail() {
		return email;
	}
	public String getDay() {
		return DD;
	}
	public String getMonth() {
		return MM;
	}
	
}

class R2RSolutions implements UserInterface{

	public static void main(String[] args) {
		
		Scanner manageMenu = new Scanner(System.in);	//Scanner object to swallow user input
		RepairTicket dynTix = new RepairTicket();		//declaring RepairTicket object to be used and mutated in program
		R2RSolutions UI = new R2RSolutions();			//declaring class object to accomodate for interface methods
		int getInput = 0;
		UI.outputMenu();
		System.out.print("\nEnter option: ");
		getInput = manageMenu.nextInt();
		while (getInput != 0) {							//Exit code is 0, so keep running while Scanner reads non-zero.
			if (getInput > 2) {
				System.out.println("Input invalid! Select from the given options, please");
			}
			switch(getInput) {
				case 1:
				UI.createTicket(dynTix);
				break;
				case 2:
				UI.viewTicket(dynTix);
				break;
			}
			
			UI.outputMenu();
			System.out.print("\nEnter option: ");
			getInput = manageMenu.nextInt();
			
		}
		
		System.out.println("Goodbye!");
		
	}
	
	@Override
	public void outputMenu() {
		
		
		System.out.println("  ___  ___ ___  ___      _      _   _             ");
		System.out.println(" | _ \\|_  ) _ \\/ __| ___| |_  _| |_(_)___ _ _  ___");
		System.out.println(" |   / / /|   /\\__ \\/ _ \\ | || |  _| / _ \\ ' \\(_-<");
		System.out.println(" |_|_\\/___|_|_\\|___/\\___/_|\\_,_|\\__|_\\___/_||_/__/");
		System.out.println("                                                   ");
		System.out.println();
		System.out.println("Welcome to R2R \"Right 2 Repair\" Solutions!");
		System.out.println("Please select from the given options:");
		System.out.println("[0] - Exit Program");
		System.out.println("[1] - Submit New Ticket");
		System.out.println("[2] - View Ticket ");
		
	}
	
	
	@Override
	public void createTicket(RepairTicket n) {
		
		Scanner ticketScanner = new Scanner(System.in);
		String[] devices = {"[1] Tablet", "[2] Phone", "[3] Computer", "[4] Unspecified/Other"};
		String[] issues = {"[1] Internal/OS Error" , "[2] External/Hardware Error", "[3] Damaged from Elements", "[4] Unspecified/Other"};
		int handleInt = 0;
		String handleString = "";
		
		
		System.out.println("Option 1 Selected!, Please answer the following questions.");
		for (int i = 0 ; i < devices.length ; i++) {System.out.println(devices[i]);}
		System.out.print("\nEnter Device Type: ");
		handleInt = ticketScanner.nextInt();
		ticketScanner.nextLine();
		n.setDeviceType(devices[handleInt - 1]);
		
		
		for (int i = 0 ; i < issues.length ; i++) {System.out.println(issues[i]);}
		System.out.print("\nEnter Issue Type: " );
		handleInt = ticketScanner.nextInt();
		ticketScanner.nextLine();
		n.setIssue(issues[handleInt - 1]);
		
		
		System.out.print("\nEnter Email for further contact: ");
		handleString = ticketScanner.nextLine();
		n.setEmail(handleString);
		
		System.out.println("\nLastly, please enter the Day and Month of your intended visit: ");
		System.out.print("DD: ");
		handleString = ticketScanner.nextLine();
		n.setDay(handleString);
		
		System.out.print("MM: ");
		handleString = ticketScanner.nextLine();
		n.setMonth(handleString);
		
	}
	
	
	@Override
	public void viewTicket(RepairTicket x) {
		
		System.out.println("Option 2 Selected!, Here's your current Repair Ticket:");
		System.out.println("Email: " + x.getEmail());
		System.out.println("Device: " + x.getDevice());
		System.out.println("Issue: " + x.getIssue());
		System.out.println("Visit Date: " + x.getDay() + "/" + x.getMonth());
	
	}
}
