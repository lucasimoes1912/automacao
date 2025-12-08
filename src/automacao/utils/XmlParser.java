package automacao.utils;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

// Usado apenas na API real para retornar SOAP.

public class XmlParser {

    public static Document parse(String xml) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        try (var is = new ByteArrayInputStream(xml.getBytes(java.nio.charset.StandardCharsets.UTF_8))) {
            return builder.parse(is);
        }
    }
}
