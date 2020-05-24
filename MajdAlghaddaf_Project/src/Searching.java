import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Searching 
{
	private ArrayList<Contact> contactInfoFiltered = new ArrayList<Contact>();
	
	// Filters given ArrayList based on user input
	public ArrayList<Contact> HandleUserInput(ArrayList<Contact> contactInfo)

	{
		String userInput = JOptionPane.showInputDialog("Input:");
		String[] seperatedByComma = userInput.split(",");
		for(int i=0;i<seperatedByComma.length;i++)
		{
			String[] seperatedBySpace = seperatedByComma[i].split(":");
			switch(seperatedBySpace[0].toLowerCase())
			{
			
			case "firstname":
				for(Contact c:contactInfo)
				{
					if(!c.getFirstName().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "lastname":
				for(Contact c:contactInfo)
				{
					if(!c.getLastName().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "birthday":
				for(Contact c:contactInfo)
				{
					if(!c.getDateOfBirth().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "gender":
				for(Contact c:contactInfo)
				{
					if(!c.getGender().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "occupation":
				for(Contact c:contactInfo)
				{
					if(!c.getOccupation().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "organization":
				for(Contact c:contactInfo)
				{
					if(!c.getOrganization().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "email":
				for(Contact c:contactInfo)
				{
					if(!c.getEmail().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "phonenumber":
				for(Contact c:contactInfo)
				{
					if(!(c.getPhoneNumber() == (Integer.parseInt(seperatedBySpace[1]))))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "country":
				for(Contact c:contactInfo)
				{
					if(!c.getCountry().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "city":
				for(Contact c:contactInfo)
				{
					if(!c.getCity().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "type":
				for(Contact c:contactInfo)
				{
					if(!c.getContactType().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			case "datasource":
				for(Contact c:contactInfo)
				{
					if(!c.getDataSource().equalsIgnoreCase(seperatedBySpace[1]))
					{
						contactInfoFiltered.remove(c);				}
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Could not find any matches","Goodbye!",JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
		if(contactInfoFiltered.size()<=0)
		{
			JOptionPane.showMessageDialog(null, "Could not find any matches","Goodbye!",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		return contactInfoFiltered;
	}

	// Searches and displays basic parsed data based on user input
	public void ConductBasicSearch(ArrayList<Contact> contactInfo)
	{
		boolean continueSearch = true;
		while(continueSearch)
		{
			// Search for contact info based on user input
			contactInfoFiltered = new ArrayList<Contact>(contactInfo);
			contactInfoFiltered = HandleUserInput(contactInfo);
			contactInfo = new ArrayList<Contact>(contactInfoFiltered);
			
			// Display filtered contact info
			JTable table = new JTable
					(new DefaultTableModel(new Object[]{"FIRSTNAME", "LASTNAME","GENDER", "CITY","COUNTRY", "CONTACT TYPE","DATA SOURCE","NUMBER"}, 0));
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(Contact c:contactInfoFiltered)
			{
				model = c.AddInformation(model,contactInfoFiltered.indexOf(c)+1);
			}
			//Create and set up the window.
	        JFrame frame = new JFrame("Contact Info");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setPreferredSize(new Dimension(1600,1000));

	        //Add contents to the window.
	        frame.add(table);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
			
			
			// Check if user would like to initiate another search
			int additionalSearchOption = JOptionPane.showConfirmDialog
					(null,
					"Would you like to initiate another search based on the displayed information?",
					"Filter Search", 
					JOptionPane.YES_NO_OPTION);
			if(additionalSearchOption == JOptionPane.YES_OPTION)
			{
				continue;
			}
			else if(additionalSearchOption == JOptionPane.NO_OPTION)
			{
				continueSearch = false;
			}
		}
	}

	// Searches and displays additional parsed data based on user input
	public void ConductAdditionalSearch()
	{
		boolean continueSearch = true;
		while(continueSearch)
		{
			// Checks if the user would like to retrieve additional information
			int additionalSearchOption = JOptionPane.showConfirmDialog
					(null,
					"Would you like to retrieve additional information on one of the contacts? (Yes/No)", 
					"Additional Information",
					JOptionPane.YES_NO_OPTION);
			
			// YES_OPTION
			if(additionalSearchOption == JOptionPane.YES_OPTION)
			{
				String userInput = JOptionPane.showInputDialog("Please choose the number of the contact on which you'd like to receive additional information");
				if(!isNumeric(userInput) || Integer.parseInt(userInput) >= contactInfoFiltered.size()+1 || Integer.parseInt(userInput) <= 0)
				{
					JOptionPane.showMessageDialog(null, "Error - Quitting...","Goodbye!",JOptionPane.PLAIN_MESSAGE);
					return;
				}
				// Setting up JTextArea
				JTextArea textArea = new JTextArea(20, 20);
				textArea.setEditable(false);
				
				// Showing additional info on the selected contact
				int numberOfContact = Integer.parseInt(userInput) - 1;
				textArea = contactInfoFiltered.get(numberOfContact).showAdditionalInfo(textArea);
				
				//Create and set up the window.
		        JFrame frame = new JFrame("Additional Information");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        //Add contents to the window.
		        frame.add(textArea);

		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
			}
			
			// NO_OPTION
			else if(additionalSearchOption == JOptionPane.NO_OPTION)
			{
				continueSearch = false;
				JOptionPane.showMessageDialog(null, "Quitting...","Goodbye!",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	// Checks if a given string is numeric
	public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
}
