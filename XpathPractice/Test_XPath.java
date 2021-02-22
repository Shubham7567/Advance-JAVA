package XpathPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test_XPath
{
    public static void main(String[] args)
    {
        try{
            FileInputStream file = new FileInputStream(new File("./Employees.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            System.out.println("****************************************");
            String expression = "/Employees/Employee[@emplid='3333']/Email";
            System.out.println(expression);
            String email = xPath.compile(expression).evaluate(xmlDocument);
            System.out.println(email);

            System.out.println("****************************************");
            expression = "/Employees/Employee/Firstname";
            System.out.println(expression);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }

            System.out.println("****************************************");
            expression = "/Employees/Employee[@type='admin']/Firstname";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }

            System.out.println("****************************************");
            expression = "/Employees/Employee[age>40]/Firstname";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }

            System.out.println("****************************************");
            expression = "/Employees/Employee[1]/Firstname";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }

            System.out.println("****************************************");
            expression = "/Employees/Employee[position() <= 2]/Firstname";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }

            System.out.println("****************************************");
            expression = "/Employees/Employee[last()]/Firstname";
            System.out.println(expression);
            nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODESET);
            for(int i=0; i < nodeList.getLength(); i++)
            {
                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
            }
            

            System.out.println("****************************************");
            expression = "/Employees/Employee[@emplid='2222']/Firstname";
            System.out.println(expression);
            Node node = (Node) xPath.compile(expression).evaluate(xmlDocument,XPathConstants.NODE);
            if(node != null)
            {
                nodeList = node.getChildNodes();
                for(int index=0; null != nodeList && index <= nodeList.getLength(); index++)
                {
                    Node nod = nodeList.item(index);
                    if(nodeList.item(index).getNodeType() == Node.ELEMENT_NODE)
                    {
                        System.out.println(nodeList.item(index).getNodeName() + " : " + nod.getFirstChild().getNodeValue());
                    }
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace(System.err);
        }
    }
}