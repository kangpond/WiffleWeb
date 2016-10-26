
package gov.nia.ssrs.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfChoice1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfChoice1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ParameterValue" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ParameterValue"/>
 *         &lt;element name="ParameterFieldReference" type="{http://schemas.microsoft.com/sqlserver/2005/06/30/reporting/reportingservices}ParameterFieldReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfChoice1", propOrder = {
    "parameterValueOrParameterFieldReference"
})
public class ArrayOfChoice1 {

    @XmlElements({
        @XmlElement(name = "ParameterValue", type = ParameterValue.class, nillable = true),
        @XmlElement(name = "ParameterFieldReference", type = ParameterFieldReference.class, nillable = true)
    })
    protected List<ParameterValueOrFieldReference> parameterValueOrParameterFieldReference;

    /**
     * Gets the value of the parameterValueOrParameterFieldReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterValueOrParameterFieldReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterValueOrParameterFieldReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterValue }
     * {@link ParameterFieldReference }
     * 
     * 
     */
    public List<ParameterValueOrFieldReference> getParameterValueOrParameterFieldReference() {
        if (parameterValueOrParameterFieldReference == null) {
            parameterValueOrParameterFieldReference = new ArrayList<ParameterValueOrFieldReference>();
        }
        return this.parameterValueOrParameterFieldReference;
    }

}
