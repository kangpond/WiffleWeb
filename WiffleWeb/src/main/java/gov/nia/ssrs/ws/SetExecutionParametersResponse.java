
package gov.nia.ssrs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="executionInfo" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ExecutionInfo" minOccurs="0"/>
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
    "executionInfo"
})
@XmlRootElement(name = "SetExecutionParametersResponse")
public class SetExecutionParametersResponse {

    protected ExecutionInfo executionInfo;

    /**
     * Gets the value of the executionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionInfo }
     *     
     */
    public ExecutionInfo getExecutionInfo() {
        return executionInfo;
    }

    /**
     * Sets the value of the executionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionInfo }
     *     
     */
    public void setExecutionInfo(ExecutionInfo value) {
        this.executionInfo = value;
    }

}
