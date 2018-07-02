package org.haizong.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class XPathTest {

    @Test
    public void testParse() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);
        String xml = "/Users/haizongqin/Git/mybatis-examples/mybatis-simple/src/main/resources/org/haizong/mybatis/example/CityMapper.xml";
        Document document = factory.newDocumentBuilder().parse(Files.newInputStream(Paths.get(xml), StandardOpenOption.READ));
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xPath.evaluate("/mapper", document, XPathConstants.NODE);
        System.out.println(node);
        NodeList nodes = (NodeList) xPath.evaluate("select|insert|update|delete", node, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            System.out.println(item);
        }
    }
}
