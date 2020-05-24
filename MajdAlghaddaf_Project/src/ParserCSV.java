import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserCSV implements Parser{
	private ArrayList<Contact> contactInfo = new ArrayList<Contact>();

	// Parses a CSV file into an ArrayList contactInfo
	@SuppressWarnings("resource")
	@Override
	public void Parse() throws IOException
	{
		FileReader fileReader = new FileReader("E:\\Other\\Spring_2019_2020\\OOP1\\contactSheet.csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		bufferedReader.readLine(); // To skip the first row of the CSV file which is filled with titles
		while((line = bufferedReader.readLine()) != null)
		{
			String[] infoArray = line.split(",");
			if(infoArray[10].equals("Business"))
				{
				Contact c = new Contact(infoArray[0],infoArray[1],infoArray[3],infoArray[8],infoArray[9],"CSV",infoArray[10],
						infoArray[4],infoArray[5],infoArray[6]);
				contactInfo.add(c);
				}
			else if(infoArray[10].equals("Personal"))
			{
				Contact c = new Contact(infoArray[0],infoArray[1],infoArray[3],infoArray[8],infoArray[9],"CSV",infoArray[10],
						infoArray[2],Integer.parseInt(infoArray[7]));
				contactInfo.add(c);
			}
		}
	}


	// Returns an ArrayList filled with parsed data
	public ArrayList<Contact> GetContactInfo() {
		return this.contactInfo;
	}
}
