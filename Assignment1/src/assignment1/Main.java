package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
public class Main {
    public static void main(String[] args) {
        try {
            //Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the input XML document, parse it and return an instance of the
            // Document class.
            Document document = builder.parse(new File("Catalogue.xml"));

            List<Book> books = new ArrayList<Book>();
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            Element elem ;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                     elem = (Element) node;

                    // Get the value of the ID attribute.
                    String ID = node.getAttributes().getNamedItem("ID").getNodeValue();

                    // Get the value of all sub-elements.
                    String auther = elem.getElementsByTagName("Author")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    String title = elem.getElementsByTagName("Title").item(0)
                            .getChildNodes().item(0).getNodeValue();

                    String genre = elem.getElementsByTagName("Genre")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    Double price = Double.parseDouble(elem.getElementsByTagName("Price")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    
                    String publish_Date = elem.getElementsByTagName("Publish_Date").item(0)
                            .getChildNodes().item(0).getNodeValue();
                
                    String description = elem.getElementsByTagName("Description").item(0)
                            .getChildNodes().item(0).getNodeValue();

                    books.add(new Book(ID, auther, title, genre, price,publish_Date,description));
                }
            }
            System.out.println("Please enter the number of books ");
            Scanner scanner = new Scanner(System.in);
            int booksNumber = scanner.nextInt();
            System.out.println("Enter the information of each book");
            for (int i =0 ; i < booksNumber; i++){
                // Element rooElement = document.createElement("Catalogue");
                // Element mainElement = document.createElement("Book");
                System.out.print("ID for book number ("+(i+1)+"): ");
                String newID = scanner.next();
                // Text bookIDText = document.createTextNode(newID);
                // Element bookID = document.createElement("ID");
                // bookID.appendChild(bookIDText);
                // mainElement.appendChild(bookID);
                // rooElement.appendChild(mainElement);
                // document.appendChild(rooElement);
                
                
                
                System.out.print("Author for book number ("+(i+1)+"): ");
                String newAuthor = scanner.next();
                System.out.print("Title for book number ("+(i+1)+"): ");
                String newTitle = scanner.next();
                System.out.print("Genre for book number ("+(i+1)+"): ");
                String newGenre = scanner.next();
                System.out.print("Price for book number ("+(i+1)+"): ");
                Double newPrice = scanner.nextDouble();
                System.out.print("Publish Date for book number ("+(i+1)+"): ");
                String newPublichDate = scanner.next();
                System.out.print("Description for book number ("+(i+1)+"): ");
                String newDescription = scanner.next();
            }


            // Print all books.
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
