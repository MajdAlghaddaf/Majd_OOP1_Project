import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public  class Contact {
		// Common Attributes
		private String firstName;
		private String lastName;
		private String gender;
		private String country;
		private String city;
		private String dataSource;
		private String contactType;
		
		private PersonalContact personalContact;
		private BusinessContact businessContact;
		
		// Nested Classes
		private class PersonalContact
		{
			private String dateOfBirth;
			private int phoneNumber;
			
			private PersonalContact(String dateOfBirth, int phoneNumber) {
				this.dateOfBirth = dateOfBirth;
				this.phoneNumber = phoneNumber;
			}
		}
		
		private class BusinessContact
		{
			private String occupation;
			private String organization;
			private String email;
			private BusinessContact(String occupation, String organization, String email) 
			{
				this.occupation = occupation;
				this.organization = organization;
				this.email = email;
			}
		}
		
		// Getters and Setters
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDateOfBirth() {
			return personalContact.dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.personalContact.dateOfBirth = dateOfBirth;
		}
		public int getPhoneNumber() {
			return personalContact.phoneNumber;
		}
		public void setPhoneNumber(int phoneNumber) {
			this.personalContact.phoneNumber = phoneNumber;
		}
		public String getOccupation() {
			return businessContact.occupation;
		}
		public void setOccupation(String occupation) {
			this.businessContact.occupation = occupation;
		}
		public String getOrganization() {
			return businessContact.organization;
		}
		public void setOrganization(String organization) {
			this.businessContact.organization = organization;
		}
		public String getEmail() {
			return businessContact.email;
		}
		public void setEmail(String email) {
			this.businessContact.email = email;
		}
		public String getDataSource()
		{
			return dataSource;
		}
		public void setDataSource(String dataSource)
		{
			this.dataSource=dataSource;
		}
		public String getContactType() {
			return contactType;
		}
		public void setContactType(String contactType) {
			this.contactType = contactType;
		}
		
		// Adds the "Basic" information to a JTable
		public DefaultTableModel AddInformation(DefaultTableModel model, int number)
		{
			model.addRow(new Object[]{this.getFirstName(), this.getLastName(), this.getGender(),this.getCountry(),this.getCity(),this.getContactType(),this.getDataSource(),number});
			return model;
		}
		
		// Displays "Additional" information on a contact as a JTextArea
		public JTextArea showAdditionalInfo(JTextArea textArea)
		{
			if(this.getContactType().equals("Business"))
			{
				textArea.append("OCCUPATION: "+this.getOccupation()
						+ "\nORGANIZATON: "+this.getOrganization()
						+ "\nEMAIL: "+this.getEmail());
			}
			else if(this.getContactType().equals("Personal"))
			{
				textArea.append("Birthday: "+this.getDateOfBirth()
				+ "\nPhone Number: "+this.getPhoneNumber());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error - Quitting...","Goodbye!",JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			return textArea;
		}
		
		// Constructors
		public Contact(
				String firstName, String lastName, String gender, String country, String city, String dataSource, String contactType,
				String dateOfBirth, int phoneNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.country = country;
			this.city = city;
			this.dataSource=dataSource;
			this.contactType=contactType;
			this.personalContact = new PersonalContact(dateOfBirth, phoneNumber);
		}
		
		public Contact(
				String firstName, String lastName, String gender, String country, String city, String dataSource, String contactType,
				String occupation, String organization, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.country = country;
			this.city = city;
			this.dataSource=dataSource;
			this.contactType=contactType;
			this.businessContact = new BusinessContact(occupation, organization, email);
		}
		
}
