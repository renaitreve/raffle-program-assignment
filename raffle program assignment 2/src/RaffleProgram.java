import java.awt.Font;
import java.util.Random;

// 

// The name RaffleProgram was chosen for this class as it accurately reflects
// the program's function, facilitating easier raffles by combining an RNG
// and a system for inputting entries, and was chosen over different names such as
// "RaffleGenerator" or "TicketNumberGenerator".

// This class was included as the code would not run without it.

public class RaffleProgram {

	// The following object member variables and arrays are declared in the class
	// as they are used in multiple methods throughout the program.
	// This is to ensure that the right variable/array can be referred to in the off
	// chance that there similarly named variables/arrays in individual methods.

	// The general justification for the use of int data types and int type arrays
	// are as follows:

	// The int data type was used over a double or a float because whole numbers are
	// being stored over decimal numbers (which double and float are best used for).
	// Because IDs, ticket numbers, the number of current/max number of participants
	// (which also determine the length of the arrays and how ticket numbers are
	// allocated) and the values which are used to navigate arrays are typically and
	// more appropriately stored as whole numbers, the int data type was used.

	// This justification applies for the following int type variables:
	// maxRaffleParticipants, currentRaffleParticipants,
	// id, i, ticketNo, foundIndex, ticketPull, searchID, numValidInputs

	// Similarly, the int type array was used over a normal int variable
	// as multiple IDs and ticket numbers are being recorded and stored,
	// rather than just one ticket number or one ID.

	// This justification applies for the following int type arrays:
	// ids[], ticketNos[], longerTicketNos[]

	// The int data type and arrays were chosen over String data type, a
	// non-primitive data type, because Strings are best suited for storing 
	// a sequence of characters, not solely numbers.

	// The general justification for the use of String data types and String type
	// arrays are as follows:

	// The String data type was chosen over numerical data types (like int or
	// double) because they are best fit to store inputs comprising of characters 
	// like both letters and numbers, and are not solely a true/false statement 
	// (which would be covered by booleans). As usernames contain characters, obtaining 
	// a row from the table/inputing into and searching for information in the table
	// and inputs in text fields yield a collection of characters, 
	// the String data type was used.

	// This justification applies for the following String type variables:
	// selectedRow, username, participantInput, searchTerm, ticketNoField

	// Similarly, the String type array was used over a normal String variable
	// as multiple usernames are being stored and recorded, rather than just
	// one username, or it contains a series of characters when taken from the table
	// to be split into their respective data forms.

	// This justification applies for the following String type arrays: usernames[],
	// participantDetails[], longerUsernames[]

	// The general justification for the use of boolean data types and boolean type
	// arrays are as follows:

	// The boolean data type was chosen to store information about whether the
	// participant is a member or not a member of the group/game/website hosting the raffle
	// because it is a true or false/yes or no statement, meaning that the String data type 
	// or a numerical data type like int or float would not be appropriate.

	// This justification applies for the following boolean data type variable:
	// isMember

	// Similarly, a boolean data type array was used over a boolean variable as
	// the membership information of multiple people are being inputed and stored.

	// This justification applies for the following boolean data type arrays:
	// memberInfo[]

	// The identifier name 'gtMain' was chosen over another identifier name like
	// raffleSheet as it is the primary window where most of the program's functions occur, 
	// and is also an appropriate identifier for indicating that it is invoking GTerm functions.
	
	// This justification applies for all instances where "this.gtMain" is called

	private GTerm gtMain;

	// The identifier name 'gtEdit' was chosen over another identifier name like
	// editScreen as it is a secondary window where users can edit the information
	// inputed into the table, and is also an appropriate identifier for indicating that it
	// is invoking GTerm functions.
	
	// This justification applies for all instances where "this.gtEdit" is called

	private GTerm gtEdit;

	// The identifier name 'gtWinner' was chosen over another identifier name like
	// winnerScreen as it is a tertiary window that shows the winner of the raffle
	// in an easily shareable way (by taking a photo or screenshot to share), and is
	// also an appropriate identifier for indicating that it is invoking GTerm functions.
	
	// This justification applies for all instances where "this.gtWinner" is called

	private GTerm gtWinner;

	// The identifier name 'maxRaffleParticipants' was chosen over another
	// identifier name like maxNumberofRaffleParticipants to be more concise, as well 
	// as to indicate that this is the value which determines the maximum number of inputs 
	// that can be stored by the program at any one time.
	
	// This justification applies for all instances where "this.maxRaffleParticipants" is called

	private int maxRaffleParticipants;

	// The identifier name 'currentRaffleParticipants' was chosen over another
	// identifier name like CurrentNumberofRaffleParticipants to be more concise, 
	// as well as to indicate that this is the value which determines the current amount of participants 
	// that have been inputed in the program so far, and therefore how many participants 
	// are part of the raffle at any one time.
	
	// This justification applies for all instances where "this.currentRaffleParticipants" is called

	private int currentRaffleParticipants;

	// The identifier name 'usernames' was chosen over another identifier name like
	// usernamesOfParticipants to be more concise, as well as to show that this array
	// stores all of the usernames of the participants entered into the table and the raffle.
	
	// This justification applies for all instances where "this.usernames" is called

	private String[] usernames;

	// The identifier name 'ids' was chosen over another identifier name like
	// idsOfParticipants to be more concise, as well as to show that this array stores 
	// all of the ids of the participants entered into the table, and consequently into the raffle.
	
	// This justification applies for all instances where "this.ids" is called

	private int[] ids;

	// The identifier name 'memberInfo' was chosen over another identifier name like
	// signedUpInfo as it is more clear that the user is either a member of the group/game or not,
	// rather than saying whether they have signed up to be a member or not.
	// It was also named this way to show that this array stores the membership information 
	// of the participants entered into the table.
	
	// This justification applies for all instances where "this.memberInfo" is called

	private boolean[] memberInfo;

	// The identifier name 'ticketNos' was chosen over another identifier name like
	// ticketNumbers to be more concise, as well as to show that this array
	// stores all of the ticket numbers allocated to the participants as they are
	// entered into the table.
	
	// This justification applies for all instances where "this.ticketNos" is called

	private int[] ticketNos;

	// The constructor was named RaffleProgram to align with the class of the same
	// name as there is no other choice without causing an error in the code.
	// This constructor has no return statement as it is primarily used in the initialisation 
	// of the object member variables above, which are declared in the class.
	
	// As a constructor was a requirement for the criteria, the program could not be
	// formed without one.

	public RaffleProgram() {

		this.gtMain = new GTerm(655, 600);

		// gtEdit and gtWinner are given null values rather than GTerm windows in the
		// constructor unlike gtMain as these two windows do not need to be open 
		// when the program is first run and only when the methods that require those windows
		// are called upon later on.

		this.gtEdit = null;
		this.gtWinner = null;

		// maxRaffleParticipants was chosen to determine the length of the arrays
		// over currentRaffleParticipants as it better reflects how many participants
		// can be inputed into the program in the future rather than how many
		// participants are currently present in the program. A purposefully low number
		// for maxRaffleParticipants was chosen as upcoming code will make it so that
		// the length of the arrays are determined by how many inputs are needed by the user
		// rather than being hard-coded.

		this.maxRaffleParticipants = 1;
		this.currentRaffleParticipants = 0;

		this.usernames = new String[this.maxRaffleParticipants];
		this.ids = new int[this.maxRaffleParticipants];
		this.memberInfo = new boolean[this.maxRaffleParticipants];
		this.ticketNos = new int[this.maxRaffleParticipants];

		this.gtMain.setBackgroundColor(234, 180, 144);
		this.gtMain.setXY(30, 20);
		this.gtMain.setFontSize(25);
		this.gtMain.setFontColor(255, 255, 255);
		this.gtMain.print("BELLE'S RAFFLE PROGRAM!");
		this.gtMain.setFontSize(12);
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.setFontSize(14);
		this.gtMain.print("Participant details: ");
		this.gtMain.setFontSize(12);
		this.gtMain.setFontColor(0, 0, 0);
		this.gtMain.addTextField("", 150);
		this.gtMain.print(" ");
		this.gtMain.addButton("Add", this, "addParticipantFromEntry");
		this.gtMain.addButton("Search participant ID", this, "searchParticipantFromEntry");
		this.gtMain.println("");
		this.gtMain.setXY(432, 90);
		this.gtMain.addButton("Show all participants", this, "refreshTable");
		this.gtMain.setXY(30, 80);
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.addTable(590, 300, "Username\tID\tMember of game?\tTicket Number");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.setXY(48, 440);
		this.gtMain.addButton("Edit selected", this, "editSelectedParticipant");
		this.gtMain.addButton("Remove selected", this, "removeSelectedParticipant");
		this.gtMain.addButton("Check if selected is the winner!", this, "checkIfWinningParticipant");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.setXY(30, 480);
		this.gtMain.setFontColor(255, 255, 255);
		this.gtMain.println("------------------------------------------------------------------------------------");
		this.gtMain.println("");
		this.gtMain.setXY(25, 515);
		this.gtMain.setFontColor(0, 0, 0);
		this.gtMain.addButton("Generate a random ticket number", this, "generateRandomTicketNo");
		this.gtMain.print(" ");
		this.gtMain.addTextField("", 50);
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.println("");
		this.gtMain.println("");

	}

	// This method created out of necessity, as it is invoked by a button
	// made for editing inputs was created in the constructor.
	// This method was named "editSelectedParticipant" as it better reflects its
	// function as being responsible for editing the information about a participant 
	// selected in the table.

	// As this is a void method, it has no return statement as it doesn't return a value.

	// The above justification can be applied to subsequent void methods.

	public void editSelectedParticipant() {

		// 'SelectedRow' was declared and assigned in their respective methods
		// as the value of 'selectedRow' could change between methods
		// rather than being a consistent value that is referred to throughout.

		// The name "selectedRow" was used because it reflects how a row is selected
		// from a table, and is a more concise way of saying "selectedParticipantDetails"

		// The logic of the following if statement is as follows:

		// If the selected row in the table does contain information within it, the rest
		// of the statement will run. If there is no row selected, an error message will run.
		
		// This is because a participant's details can't be edited if no participant
		// is selected in the first place.

		// This if statement was placed near the start of the code block to act as a
		// check on the input before proceeding with the rest of the code.

		// This above justification can be applied to future instances where selectedRow
		// is used when selecting a row from a table, and the logic of the if statement
		// in the variable's use when acting as a check.

		String selectedRow = this.gtMain.getSelectedRowFromTable(0);
		if (selectedRow != null) {

			// The logic of the nested if statement is as follows:

			// If there is an existing window of gtEdit open, it will close it. This is to
			// make sure there won't be duplicate editing windows open to confuse users as 
			// to which entry is being adjusted.

			if (this.gtEdit != null)
				this.gtEdit.close();

			// This window was initialised here formally as this window only needs to be
			// open when this method is invoked rather than being open from the start of the program.

			this.gtEdit = new GTerm(370, 260);

			this.gtEdit.setBackgroundColor(229, 175, 139);
			this.gtEdit.setFontSize(25);
			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.setXY(30, 20);
			this.gtEdit.print("BELLE'S ENTRY EDITOR");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.println("");
			this.gtEdit.println("");
			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.setFontSize(15);

			// This string was named participantDetails over another name like participantInput
			// as it best describes that the string contains information about the participant which 
			// is to be split from the selectedRow variable.

			// The above justification is applicable for subsequent usage of the variable
			// name.

			String[] participantDetails = selectedRow.split("\t");

			// The identifier name 'id' was chosen over another choice like userID as it is
			// more concise and more closely aligns with its plural counterpart (ids[]).

			// This justification can also be applied to other instances where 'id' is used.

			// The use of temporary strings like the below example were excluded for brevity 
			// unless specified otherwise:

			// String idTemp = participantDetails[1];
			// int id = Integer.parseInt(idTemp);

			// Instead, the string input received from the user or from the table was parsed
			// directly and consequently stored as an int value.

			// The above justification about temporary strings is applicable to other int
			// and boolean variables that are parsed and stored directly from a string.

			int id = Integer.parseInt(participantDetails[1]);

			// 'i' was chosen as the identifier name as it is easy to recognise in its
			// function as a variable that can be used to traverse through arrays using 
			// a specific point of reference.

			// The above justification can also be applied in other instances where 'i'
			// is used as the variable to navigate arrays in other methods.

			// The method 'getParticipantIndexByID' was invoked here rather repeating the
			// code that is contained in the method, where i acts as a point of reference using
			// the ID number to identify which element in the array is being edited.

			// The above justification can also be used in other instances where 
			// the getParticipantIndexByID method is invoked.

			int i = getParticipantIndexByID(id);

			this.gtEdit.print("Username:      ");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.setFontSize(12);

			// The following text fields are pre-filled with the arrays at position i, which
			// is determined by the above method, so it's easy to reference which element is being adjusted.

			this.gtEdit.addTextField(this.usernames[i], 100);
			this.gtEdit.println("");
			this.gtEdit.println("");
			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.setFontSize(15);
			this.gtEdit.print("ID:            ");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.setFontSize(12);
			this.gtEdit.addTextField("" + this.ids[i], 100);
			this.gtEdit.println("");
			this.gtEdit.println("");
			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.setFontSize(15);
			this.gtEdit.print("Member info:   ");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.setFontSize(12);
			this.gtEdit.addTextField("" + this.memberInfo[i], 100);
			this.gtEdit.setFontColor(255, 255, 255);
			this.gtEdit.println("");
			this.gtEdit.println("");
			this.gtEdit.setFontColor(0, 0, 0);
			this.gtEdit.addButton("Update", this, "updateParticipant");

		} else
			this.gtMain.showErrorDialog("Please select a participant to edit!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for updating the participant in the edit window.
	
	// This method was named "updateParticipant" as it better reflects its
	// function as being responsible for updating the information
	// of the participant selected in the table.

	public void updateParticipant() {

		// This int value was used to act as a check on the entries coming from
		// the edit window, which is represented by various if statements.
		// This int value was declared and initialised here as it is only used
		// in this code block.

		// The name numValidInputs was chosen over nullInputCheck as the int value
		// is used both to see whether the text field has a null value and to see
		// whether a number is a positive or a negative, not just the former.

		int numValidInputs = 0;

		// The name 'username' over 'name' or participantName as username is more commonly associated 
		// with online monikers as one would use for a game or website,
		// as well as matching with its plural counterpart usernames[].

		// This justification can also be applied to other instances where 'username' is used.

		String username = this.gtEdit.getTextFromEntry(0);

		// The logic of the following if statements is as follows:
		
		// If the username is blank or the ID is less than 0 (and is a negative number,
		// then 1 will be added to numValidInputs, because they are incorrect inputs.
		
		// If numValidInput is not equal to 0, an error message will play.
		
		// This if statement was included to act as a check on the inputs as the user must input 
		// details correctly before the rest of the code proceeds, and was thus placed near the start
		// of the code block.

		if (!username.isBlank())
			numValidInputs += 1;

		int id = Integer.parseInt(this.gtEdit.getTextFromEntry(1));
		int i = getParticipantIndexByID(id);
		if (id < 0)
			numValidInputs += 1;

		// The identifier name 'isMember' was chosen over 'memberTrueFalse'
		// to be more concise, and an easier way of saying whether the participant
		// is a member of the group/website or not. It also relates to its plural counterpart, being memberInfo[]

		// This justification can also be applied to other instances where 'isMember' is used.

		boolean isMember = Boolean.parseBoolean(this.gtEdit.getTextFromEntry(2));

		// The identifier name 'ticketNo' was chosen over 'ticketNumber' mostly
		// to be concise and to indicate the number assigned to each participant,
		// representing their ticket number for the raffle,
		// It also matches its plural counterpart ticketNos[].

		// This justification can also be applied to other instances where 'ticketNo' is used.

		int ticketNo = this.currentRaffleParticipants;

		if (numValidInputs != 0) {

			// The logic of the following if statement is as follows:
			
			// If there is a participant with a matching ID as determined in the getParticipantIndexByID method, 
			// 'i' will have a value that is greater or equal to 0.
			
			// The array value that is in i will then updated according to the values taken
			// from the text fields above.
			
			// If there is no matching ID, then a new participant will be added with that ID
			// number to the table.

			if (i >= 0) {
				this.usernames[i] = username;
				this.ids[i] = id;
				this.memberInfo[i] = isMember;
			} else

				// The method 'addParticipant' was invoked here rather repeating the code that is contained 
				// in the method, where a new participant is being added to the table/array if their ID 
				// does not match with existing IDs in the table.
				
				// The parameters from that method are also used here, which allows for inputs
				// of the same data type from this method (which are also similarly named
				// for consistency) to be used in the function.

				// The above justification is applicable for subsequent uses of addParticipant.

				addParticipant(username, id, isMember, ticketNo);

			// The method 'refreshTable' was invoked here rather repeating the code that is contained in the method, 
			// where all of the rows of the table and the information contained within them are presented.

			// The above justification is applicable for subsequent uses of refreshTable.

			refreshTable();

		} else
			this.gtMain.showErrorDialog("Please make sure you input the participants details correctly!");
	}

	// This method was created to reduce repetition of code when a participant's information is added into the arrays.
	// The parameters were chosen as they are all of the data types relevant to information about the participant
	// and are data types that are called upon by many other statements in the code.

	// The name 'addParticipant' was used because it still describes the function  of the method without 
	// confusing it with the other adding method, where participants are added in initially rather than being added 
	// or adjusted via the edit functions.

	public void addParticipant(String username, int id, boolean isMember, int ticketNo) {

		// The logic of the following if statement is as follows:
		
		// If the ID is a negative number, it shows an error dialogue, as a user's ID cannot be negative.
		// If the ID is a positive number, it proceeds with the rest of the code.

		// The above justification is applicable when an id is being compared to 0
		// as a way of determining whether it is a positive or negative number.

		if (id < 0) {
			this.gtMain.showErrorDialog("IDs cannot be negative! Please input a positive ID.");
		} else {

			// The identifier name 'foundIndex' was used as it is the number returned from
			// the getParticipantIndexByID method, and refers to whether a participant
			// can be found by their ID number.

			// The above justification can be referred to when foundIndex is used in subsequent methods.

			int foundIndex = getParticipantIndexByID(id);

			// The logic of the following if statement is as follows:
			// If there is no matching ID determined in the getParticipantIndexByID method,
			// foundIndex will return a value that is less than 0, which will thus cause the
			// information (obtained in the method in which addParticipant is invoked)
			// that matches the data type of the parameters to be placed into their respective arrays.

			if (foundIndex < 0) {
				this.usernames[this.currentRaffleParticipants] = username;
				this.ids[this.currentRaffleParticipants] = id;
				this.memberInfo[this.currentRaffleParticipants] = isMember;
				this.ticketNos[this.currentRaffleParticipants] = ticketNo;
				this.currentRaffleParticipants += 1;

				// The method 'expandArray' was invoked here rather repeating the code that is contained 
				// in the method, where longer arrays are created and the old values of the current array are placed.

				// The above justifications can be used for other instances where this method is invoked.

				expandArray();
			}

		}
	}

	// This method was created out of necessity, as it is invoked by a button
	// made for adding the participants into the table in the main window.

	// This method was named "addParticipantFromEntry" as it better reflects its function as 
	// the first instance where participants are added into the table from the text field in the main window.

	public void addParticipantFromEntry() {

		String participantInput = this.gtMain.getTextFromEntry(0);

		// participantInput was initialised and declared in this code block as it is specific
		// only to this code block rather than being referred to elsewhere.

		// The name 'participantInput' was used over another name like participantDetails
		// because the string refers to information being inputed for the first time,
		// and to distinguish it from when the information is called back on when
		// selecting a row from a table.

		// The logic of the following if statements is as follows:
		
		// If there is information in the text field, then the rest of the code will run.
		// If the text field is blank, an error message will show. This is because there
		// needs to be information in the text field for it to be included into a table.

		// This if statement was placed here to act as a check on the entry (or lack thereof) 
		// before progressing further.

		if (participantInput != null) {
			String participantDetails[] = participantInput.split(",");

			// The logic of the following if statement is as follows:
			
			// If the string array has a length that is not equal to three (that is, the input 
			// did not have/ all three components of username, id, and a true/false answer) 
			// then it will trigger an error message.

			// This if statement was placed here, near the start of the code block, to act as a check 
			// on the entry before running the rest of the code

			if (participantDetails.length != 3) {
				this.gtMain
						.showErrorDialog("Please input participant details in the form of username,id,memberOfGame?");
			}

			int id = Integer.parseInt(participantDetails[1]);

			if (id < 0) {
				this.gtMain.showErrorDialog("IDs cannot be negative! Please input a positive ID.");
			} else {

				int foundIndex = getParticipantIndexByID(id);

				// The logic of the following if statement is as follows:
				
				// If there is no matching ID determined in the getParticipantIndexByID method,
				// foundIndex will return a value that is less than 0, which will thus cause the information
				// to be inputed into the table as a row and then added into the arrays
				// through the addParticipant methods.
				
				// If foundIndex returns with a match, a value greater than 0 is given, meaning
				// that an error message will be triggered.
				// This check was added to make sure that duplicate IDs are not inputed into the table
				// via the main entry.

				if (foundIndex < 0) {
					String username = participantDetails[0];
					boolean isMember = Boolean.parseBoolean(participantDetails[2]);

					// Ticket numbers, in this case, are determined by how many entrants
					// there are in the raffle. As an array starts its count from 0,
					// a +1 was added so that the ticket number would show "1" rather than "0"
					// for the first person entered into the table, "2" for the second participant
					// and so on.

					int ticketNo = this.currentRaffleParticipants + 1;
					this.gtMain.addRowToTable(0, username + "\t" + id + "\t" + isMember + "\t" + ticketNo);
					this.gtMain.setTextInEntry(0, "");
					addParticipant(username, id, isMember, ticketNo);
					refreshTable();
				} else
					this.gtMain.showErrorDialog("There's already a participant with the ID " + id);
			}
		} else
			this.gtMain.showErrorDialog("Please input participant details in the form of username,id,memberOfGame?");
	}

	// This method was created to reduce the duplication of code, as it extends the
	// length of the array to accommodate for as many inputs as the user needs by copying older values
	// into newer arrays with a longer length.

	// The identifier name 'expandArray' was used because the code gives the effect
	// that the lengths of the arrays are being expanded and increased.

	public void expandArray() {

		// This logic of this while statement is as follows:

		// As currentRaffleParticipants refers to how many elements are currently
		// in the array, and maxRaffleParticipants refers to how many elements
		// the array can contain, when currentRaffleParticipants starts to become
		// greater than or equal to maxRaffleParticipants in length, then
		// maxRaffleParticipants will increase by 1 until it is larger
		// than currentRaffleParticipants.
		
		// MaxRaffleParticipants is expanded enough for one new entry to be inputed
		// before the method is called upon again with every entry.

		while (this.currentRaffleParticipants >= this.maxRaffleParticipants) {
			this.maxRaffleParticipants += 1;

			// The "longer" arrays are declared and initialised only in this code block
			// as they are only pertinent to when current arrays are being placed
			// into arrays with a larger length to accommodate for more entries.
			// Their names were chosen as they refer to being an array with
			// more space to hold both past and future inputs.

			String[] longerUsernames = new String[this.maxRaffleParticipants];
			int[] longerIDs = new int[this.maxRaffleParticipants];
			boolean[] longerMemberInfo = new boolean[this.maxRaffleParticipants];
			int[] longerTicketNos = new int[this.maxRaffleParticipants];

			// The logic of the following while statement is as follows:
			
			// as i increases from 0 (or the first position in the arrays),
			// the older values from the previous array are copied into the new array.

			int i = 0;
			while (i < this.currentRaffleParticipants) {
				longerUsernames[i] = this.usernames[i];
				longerIDs[i] = this.ids[i];
				longerMemberInfo[i] = this.memberInfo[i];
				longerTicketNos[i] = this.ticketNos[i];
				i += 1;

			}

			// These assignment statements were included to re-use
			// the names of the older arrays for the newer, longer arrays
			// so it can be referred to in other methods.

			this.usernames = longerUsernames;
			this.ids = longerIDs;
			this.memberInfo = longerMemberInfo;
			this.ticketNos = longerTicketNos;
		}
	}

	// This method created out of necessity, as it is invoked by a button
	// made for generating a random ticket number from the current pool
	// of ticket numbers.

	// This method was named "generateRandomTicketNo" as it better reflects its
	// function for picking a random ticket number, rather than just picking
	// a random number if the name "randomNumberGenerator" was used.

	public int generateRandomTicketNo() {

		// The Random class was declared and initiliased in this code block
		// as it is not used in any other method.

		// The name "rng" was chosen as it is an easily recognisable name
		// that reflects the random nature of how the ticket number
		// will be chosen.

		Random rng = new Random();

		// The logic of the following if statement is as follows:
		// As ticket numbers are determined by the number of raffle participants
		// whose details are added into the array, if there are no raffle participants,
		// running this method (by pressing the associated button) will return with an error message.

		if (this.currentRaffleParticipants <= 0)
			this.gtMain.showErrorDialog("Please input participant details before generating a ticket number!");

		// To reflect how ticket numbers are generated when participants
		// are entered into the table, a +1 was added to the ticket number
		// so it would show "1" rather than "0" so that the number pulled
		// would match participant ticket numbers.

		this.ticketNos[0] = rng.nextInt(this.currentRaffleParticipants) + 1;

		// The name "ticketPull" was chosen as it best reflects what ticket number is
		// pulled from the existing pool of ticket numbers.

		int ticketPull = ticketNos[0];

		// A text field specifically for the random ticket number was created
		// and used here over a showMessageDialog both to satisfy the criteria
		// and for a better appearance.

		this.gtMain.setTextInEntry(1, "" + ticketPull);

		// As this method is not a void, but rather returns an int value
		// in the form of "ticketPull", a return value was necessary.

		return ticketPull;

	}

	// This method created out of necessity, as it is invoked by a button
	// made for checking whether the participant is the winner after
	// a random ticket number is pulled.

	// This method was named "checkIfWinningParticipant" as it better reflects
	// how the method checks if the selected participant has the winning ticket,
	// as more of a formal confirmation of the results, than searching for
	// the winner.

	public void checkIfWinningParticipant() {

		// TicketNoField is an instance where a temporary string was used
		// to allow for a check on the input.

		// The name "ticketNoField" was used over an alternative like
		// "pulledTicketNo" to reduce confusion, as well as more accurately
		// describing that the value refers to the string contained in
		// the text field where the ticket number is generated.

		// The logic of the following if statement is as follows:

		// As this method is contingent on the winning ticket number being generated,
		// if a ticket number has yet to be drawn, then the rest of the code will
		// not run. This was placed near the top of the method to act as a check,
		// prompting the user to generate a random ticket number before checking to see
		// who the winner is.

		String ticketNoField = this.gtMain.getTextFromEntry(1);
		if (!ticketNoField.isBlank()) {

			// ticketPull was assigned in this code block even though a similar variable
			// name was used elsewhere as their usages are different, and are not
			// used in any other methods.

			// The name "ticketPull" to keep consistent with the variable name used
			// in the method where the random ticket number is generated from an existing
			// pool of ticket numbers.

			int ticketPull = Integer.parseInt(ticketNoField);
			String selectedRow = this.gtMain.getSelectedRowFromTable(0);
			if (selectedRow != null) {
				String selectedRowSplit[] = selectedRow.split("\t");
				String username = selectedRowSplit[0];
				int id = Integer.parseInt(selectedRowSplit[1]);
				boolean isMember = Boolean.parseBoolean(selectedRowSplit[2]);
				int ticketNo = Integer.parseInt(selectedRowSplit[3]);

				// The logic of the following if statements is as follows:

				// If the participant's ticket number is the same as
				// the ticket number generated, then a separate screen
				// will announce in a formal way (with included graphics)
				// that the selected participant is the winner.
				
				// If the selected participant is not the winner, a small
				// text field is created specifically to show that the selected participant
				// does not have the winning ticket number.
				// A text field was chosen over a showMessageDialog both to satisfy the criteria
				// and for a better appearance.

				if (ticketNo == ticketPull) {
					if (selectedRow != null) {

						// The logic of the following if statements is as follows:

						// If there is an existing window of gtWinner open, it will close it. This is to
						// make sure that the user is not confused as to who won the raffle if a new
						// ticket number was generated.

						if (this.gtWinner != null)
							this.gtWinner.close();

						// This window was initialised here formally as this window only needs to be
						// open when this method is invoked rather than being open from the start of the program, 
						// when the winner of the participant is being checked after a winning ticket
						// has been generated.

						this.gtWinner = new GTerm(400, 560);
						this.gtWinner.setBackgroundColor(229, 175, 139);
						this.gtWinner.setFontSize(15);
						this.gtWinner.setFontColor(255, 255, 255);
						this.gtWinner.setXY(46, 20);
						this.gtWinner.println("The winner is...");
						this.gtWinner.setFontSize(30);
						this.gtWinner.println(username + "!!!");
						this.gtWinner.setFontSize(15);
						this.gtWinner.println("Ticket number: " + ticketPull);
						this.gtWinner.println("");
						this.gtWinner.setFontSize(15);
						this.gtWinner.setFontStyle(Font.ITALIC);

						// The logic of the following if statements is as follows:
						
						// Different flavour text will be given depending on whether
						// the participant is a member of the game/website etc.,
						// as indicated by whether a true or false statement was inputted.
						// These were added as an added form of personalisation.

						if (isMember == true) {
							this.gtWinner.println("Thanks for being a member!!");
							this.gtWinner.println("");
						} else {
							this.gtWinner.println("Be sure to sign up soon!");
							this.gtWinner.println("");
						}

						// Similarly to the justification above, different flavour images were added for
						// personalisation, which vary depending on the user's ID number as indicated by
						// the vary conditions presented by the following if statements.
						
						// M.Y. Dungca, "Party Bunnies with Hats in Various Colours", unpublished, September 2020.

						if (id < 10000) {
							this.gtWinner.addImageIcon("partybunnyredhat.png");
						} else if ((id > 10000) && (id < 20000)) {
							this.gtWinner.addImageIcon("partybunnybluehat.png");
						} else if ((id > 20000) && (id < 30000)) {
							this.gtWinner.addImageIcon("partybunnytealhat.png");
						} else if ((id > 30000) && (id < 40000)) {
							this.gtWinner.addImageIcon("partybunnypinkhat.png");
						} else if ((id > 40000) && (id < 50000)) {
							this.gtWinner.addImageIcon("partybunnypastelorangehat.png");
						} else
							this.gtWinner.addImageIcon("partybunnygreenhat.png");
					}

				} else {
					this.gtMain.setXY(400, 515);
					this.gtMain.setFontColor(255, 255, 255);
					this.gtMain.addTextField("", 219);
					this.gtMain.setTextInEntry(2, username + " is not the winner.");
				}

			} else
				this.gtMain.showErrorDialog("Please select a participant to check!");

		} else
			this.gtMain.showErrorDialog("Please generate a random ticket number first before checking!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for removing a participant that is selected from the table/the array.

	// This method was named "removeSelectedParticipant" as it better reflects
	// how the method gives the illusion that it is removing an entry from the table
	// and is more intuitive to users than saying "overwriteSelectedParticipant"

	public void removeSelectedParticipant() {
		String selectedRow = this.gtMain.getSelectedRowFromTable(0);
		if (selectedRow != null) {
			String participantDetails[] = selectedRow.split("\t");

			// searchID was declared and initialised only in this code block as it is
			// only relevant and used in this code block.

			// The name "searchID" was used as it better shows how a number input
			// in the text field is being used to search the IDs array for a match.

			// The above justification for searchID is applicable for future instances
			// of its use.

			int searchID = Integer.parseInt(participantDetails[1]);

			int i = getParticipantIndexByID(searchID);

			// The logic of the following if statement and while statement is as follows:
			
			// If there is a matching ID, as determined by running the searchID through
			// the getParticipantIndexByID method, i will be assigned a value greater than
			// or equal to 0, which is the position from which the while statement can then proceed,
			// moving the values succeeding position i into position i's place.
			
			// This is represented by the +1s next to the arrays except ticketNos, which was removed as 
			// ticket numbers are determined by the amount of current participants, and moving the rest of
			// the values simply assigns it with the ticket number that was held by the participant
			// being removed.
			
			// As i can increase by 1 until the while loop is satisfied, a -1 was added
			// next to currentRaffleParticipants so that it doesn't reach values
			// that are too far into the array.

			if (i >= 0) {
				while (i < this.currentRaffleParticipants - 1) {
					this.usernames[i] = this.usernames[i + 1];
					this.ids[i] = this.ids[i + 1];
					this.memberInfo[i] = this.memberInfo[i + 1];
					this.ticketNos[i] = this.ticketNos[i];
					i += 1;
				}

				// As an element was overwritten, 1 was subtracted from the current number of participants 
				// to reflect this.
				
				this.currentRaffleParticipants -= 1;
				refreshTable();

			} else {
				this.gtMain.showErrorDialog("There's no participant with the ID " + searchID);
			}

		} else
			this.gtMain.showErrorDialog("Please select a participant to remove!");
	}

	// This method created out of necessity, as it is invoked by a button
	// made for searching for a participant based on their ID number.

	// This method was named "searchParticipantFromEntry" as it better reflects
	// how a user can input a number in the text field from the same text field
	// where participant details were entered.

	public void searchParticipantFromEntry() {

		// searchTerm was declared and initialised only in this code block as it is
		// only relevant and used in this code block.
		
		// searchTerm was the identifier name used to distinguish over 'searchID', as searchTerm is 
		// the input contained in the text field, which is a temporary string that is to be checked 
		// before being parsed into searchID.

		String searchTerm = this.gtMain.getTextFromEntry(0);

		// The logic of the following if statement is as follows:
		
		// if the searchTerm string is blank and contains no value, then an error message will be triggered. 
		// This was included so that the rest of the code will only run if there is an ID that is to be searched, 
		// acting as a check on the input.
		
		// This is also the reason why the if statement was placed near the start of the code block.

		if (!searchTerm.isBlank()) {
			int searchID = Integer.parseInt(searchTerm);
			this.gtMain.setTextInEntry(0, "");
			int i = getParticipantIndexByID(searchID);

			// If there is a participant with a matching ID as determined in the
			// getParticipantIndexByID methods, i will have a value that is greater or equal to 0.
			
			// The array values that is in position i will then be displayed in the first row of the table.
			// If there is no matching ID, then an error message will appear that says 
			// there is no matching searchID before refreshing the table.

			if (i >= 0) {
				this.gtMain.clearRowsOfTable(0);
				String participantDetails = this.usernames[i] + "\t" + this.ids[i] + "\t" + this.memberInfo[i] + "\t"
						+ this.ticketNos[i];
				this.gtMain.addRowToTable(0, participantDetails);
			} else {
				this.gtMain.showErrorDialog("There's no-one with the ID " + searchID);
				refreshTable();
			}
		} else
			this.gtMain.showErrorDialog("Please input a search term!");
	}

	// This method was created primarily to reduce duplication of code,
	// as it returns all of the inputed values in the tables after
	// an entry is added or edited or removed.

	// The identifier name 'refreshTable' was chosen over another name like
	// ShowAllRows as it more accurately reflects how the table is refreshed after changes are
	// made or if a search has changed what rows are being viewed.

	public void refreshTable() {
		this.gtMain.clearRowsOfTable(0);
		int i = 0;

		// This while statement works as follows:
		// The values inside each array at position i are added to the table as rows,
		// and with each increase of i by 1, the subsequent values are printed, and will continue to do so
		// until the value of i exceeds that of how many participants there are and their details to print.

		while (i < this.currentRaffleParticipants) {
			String participantDetails = this.usernames[i] + "\t" + this.ids[i] + "\t" + this.memberInfo[i] + "\t"
					+ this.ticketNos[i];
			this.gtMain.addRowToTable(0, participantDetails);
			i += 1;
		}
	}

	// This method was created primarily to reduce duplication of code,
	// as it works to find the position of the array elements
	// the user wants to edit, remove, add into newer arrays etc.

	// The identifier name 'getParticipantIndexByID' was chosen over another name
	// like getParticipantID as it more accurately reflects how it's not getting
	// any one ID specifically, but where a participant and their details is located
	// in the array  as determined by their ID.

	// The searchID parameter was chosen as it best refers to how a number
	// that represents the participant's ID is used to search for that participant
	// in the array. The ID was chosen specifically as the website/group could allow for
	// non-unique usernames to exist, but IDs tend to be unique.

	public int getParticipantIndexByID(int searchID) {

		int foundIndex = 0;

		// The logic of the following while and if statement is as follows:
		
		// The loop will continue to traverse through the array through the value
		// of foundIndex as it increases by one because the loop hasn't yet exceeded
		// the number of current participants in the raffle nor has it found
		// a match for the ID being searched.
		
		// The loop will stop once a match is found, or alternatively if foundIndex
		// exceeds the amount of current participants in the raffle, in which case
		// there was no match, and a value of -1 is given.

		while ((foundIndex < this.currentRaffleParticipants) && (this.ids[foundIndex] != searchID))
			foundIndex += 1;
		if (foundIndex >= this.currentRaffleParticipants)
			foundIndex = -1;

		// As this method is not a void, but rather returns an int value
		// in the form of "foundIndex", a return value was necessary.

		return foundIndex;
	}

	// This method was created out of necessity, and was declared as the main (and
	// static) method as the program would not run without it and could not be excluded.
	
	// An object was also created out of the main application class (RaffleProgram)
	// as stated by the specification, which is also necessary in making the program.
	
	// The name "rpObj" was used to create an object of RaffleProgram as the
	// initials "rp" is more concise than using the full name, while Obj refers to how the
	// class is being created into an object for the purpose of facilitating the code's
	// functionality.

	public static void main(String[] args) {
		RaffleProgram rpObj;
		rpObj = new RaffleProgram();
	}

}