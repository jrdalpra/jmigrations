import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import br.com.wolkenapps.jmigrations.dsl.model.commands.CreateTable;

/**
 * Just test for a xml dsl <-- we need to please greeks and trojans
 * 
 * @author jose.junior
 * 
 */
public class TestXmlDSL {

    public static void main(String[] args) {

        /**
         * not attached on java dsl ... 
         */
        
        JAXBElement<CreateTable> command = new JAXBElement<>(new QName("http://wolkenapps.com.br/jmigrations", "create-table", "m"), CreateTable.class,new CreateTable("test_123"));
        
        JAXB.marshal(command, System.out);

    }
}
