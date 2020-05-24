import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ParserXML implements Parser{

	private ArrayList<Contact> contactInfo = new ArrayList<Contact>();
	
	// Parses an XML file into an ArrayList contactInfo
	public void Parse() throws Exception{
		File fXmlFile = new File("E:\\\\Other\\\\Spring_2019_2020\\\\OOP1\\\\contactSheet.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("contact");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				if(eElement.getElementsByTagName("contacttype").item(0).getTextContent().equals("Personal"))
				{
					Contact c = new Contact(eElement.getElementsByTagName("firstname").item(0).getTextContent(),
							eElement.getElementsByTagName("lastname").item(0).getTextContent(),
							eElement.getElementsByTagName("gender").item(0).getTextContent(),
							eElement.getElementsByTagName("country").item(0).getTextContent(),
							eElement.getElementsByTagName("city").item(0).getTextContent(),
							"XML",
							eElement.getElementsByTagName("contacttype").item(0).getTextContent(),
							eElement.getElementsByTagName("birthday").item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName("phonenumber").item(0).getTextContent()));

					contactInfo.add(c);
				}
				else if(eElement.getElementsByTagName("contacttype").item(0).getTextContent().equals("Business"))
				{
					Contact c = new Contact(eElement.getElementsByTagName("firstname").item(0).getTextContent(),
							eElement.getElementsByTagName("lastname").item(0).getTextContent(),
							eElement.getElementsByTagName("gender").item(0).getTextContent(),
							eElement.getElementsByTagName("country").item(0).getTextContent(),
							eElement.getElementsByTagName("city").item(0).getTextContent(),
							"XML",
							eElement.getElementsByTagName("contacttype").item(0).getTextContent(),
							eElement.getElementsByTagName("occupation").item(0).getTextContent(),
							eElement.getElementsByTagName("organization").item(0).getTextContent(),
							eElement.getElementsByTagName("email").item(0).getTextContent());
					contactInfo.add(c);
				}
				
			}
		}
	}

	// Merges an ArrayList filled with parsed information from a CSV file
	public ArrayList<Contact> MergeArray(ArrayList<Contact> contactInfo)
	{
		contactInfo.addAll(this.contactInfo);
		return contactInfo;
	}
}
