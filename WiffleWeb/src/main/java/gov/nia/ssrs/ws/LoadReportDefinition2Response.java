
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
 *         &lt;element name="executionInfo" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ExecutionInfo2" minOccurs="0"/>
 *         &lt;element name="warnings" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ArrayOfWarning" minOccurs="0"/>
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
    "executionInfo",
    "warnings"
})
@XmlRootElement(name = "LoadReportDefinition2Response")
public class LoadReportDefinition2Response {

    protected ExecutionInfo2 executionInfo;
    protected ArrayOfWarning warnings;

    /**
     * Gets the value of the executionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionInfo2 }
     *     
     */
    public ExecutionInfo2 getExecutionInfo() {
        return executionInfo;
    }

    /**
     * Sets the value of the executionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionInfo2 }
     *     
     */
    public void setExecutionInfo(ExecutionInfo2 value) {
        this.executionInfo = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWarning }
     *     
     */
    public ArrayOfWarning getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWarning }
     *     
     */
    public void setWarnings(ArrayOfWarning value) {
        this.warnings = value;
    }

}
