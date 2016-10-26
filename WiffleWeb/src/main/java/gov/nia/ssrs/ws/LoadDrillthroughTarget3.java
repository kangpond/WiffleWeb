
package gov.nia.ssrs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DrillthroughID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "drillthroughID"
})
@XmlRootElement(name = "LoadDrillthroughTarget3")
public class LoadDrillthroughTarget3 {

    @XmlElement(name = "DrillthroughID")
    protected String drillthroughID;

    /**
     * Gets the value of the drillthroughID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrillthroughID() {
        return drillthroughID;
    }

    /**
     * Sets the value of the drillthroughID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrillthroughID(String value) {
        this.drillthroughID = value;
    }

}
