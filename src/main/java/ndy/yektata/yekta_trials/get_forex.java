package ndy.yektata.yekta_trials;

import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import jakarta.annotation.PostConstruct;

@Repository
public class get_forex {
    
    static Document tcmbLatest;

    private static Document parseXML(){
        
        Document forex_raw = null;
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            forex_raw = builder.parse(new  URL("https://www.tcmb.gov.tr/kurlar/today.xml").openStream());
            forex_raw.getDocumentElement().normalize();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return forex_raw;

    }    
    
    public static String getForexTRY(String forex){
        String result = ""; 
         NodeList forexNodeList = tcmbLatest.getElementsByTagName("Currency");
         for (int i = 0; i < forexNodeList.getLength(); i++) {
            Element currencyElement = (Element) forexNodeList.item(i);
            //System.out.println(currencyElement.getAttribute("CurrencyCode"));
            //System.out.println(forex);
            if(currencyElement.getAttribute("CurrencyCode").equals(forex)){
                result = tcmbLatest.getDocumentElement().getAttribute("Tarih") + " tarihinde TCMB'ye göre " + forex + "/TRY alım/satım değerleri.\n";
                result += "Alım: " + currencyElement.getElementsByTagName("ForexBuying").item(0).getTextContent();
                result += "Satım: " + currencyElement.getElementsByTagName("ForexSelling").item(0).getTextContent();
            }
         }
         //System.out.println(result);
         return result;
    }

    @PostConstruct
    private void init(){
        tcmbLatest = parseXML();
    }
    
    
}

