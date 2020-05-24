import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		// Parse Data
		ParserCSV p1 = new ParserCSV();
		p1.Parse();
		
		ParserXML p2 = new ParserXML();
		p2.Parse();
		
		// Combine Data into one ArrayList
		ArrayList<Contact> contactInfo = new ArrayList<Contact>(p1.GetContactInfo());
		p2.MergeArray(contactInfo);
		
		// Welcome Message
		JOptionPane.showMessageDialog(null, "Welcome to Extroverted! \n" 
				+ "Please insert the name of the field followed by ':' and the search word \n"
				+ "Example: firstname:Majd \n"
				+ "If there is more than one field, seperate them by a ',' \n"
				+ "Example: firstname:Majd,lastname:Alghaddaf,country:Lebanon \n"
				+ "The available fields are the following: \n"
				+ "firstname/lastname/birthday/gender/occupation/organization/email/phonenumber/country/city/type/datasource \n"
				+ "Unfortunately, the program is case sensitive, so be careful! \n" , "Welcome!", JOptionPane.INFORMATION_MESSAGE );
		
		// Search & Display
		Searching s = new Searching();
		s.ConductBasicSearch(contactInfo);
		s.ConductAdditionalSearch();
	}
}
