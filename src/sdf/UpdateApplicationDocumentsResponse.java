//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 01:52:13 PM GST 
//


package sdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateApplicationDocumentsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateApplicationDocumentsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="establishmentApplicationResponse" type="{http://service.api.service.establishment.v2015.emaratech.com/1.0}establishmentApplicationResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateApplicationDocumentsResponse", propOrder = {
    "establishmentApplicationResponse"
})
public class UpdateApplicationDocumentsResponse {

    protected EstablishmentApplicationResponse establishmentApplicationResponse;

    /**
     * Gets the value of the establishmentApplicationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EstablishmentApplicationResponse }
     *     
     */
    public EstablishmentApplicationResponse getEstablishmentApplicationResponse() {
        return establishmentApplicationResponse;
    }

    /**
     * Sets the value of the establishmentApplicationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstablishmentApplicationResponse }
     *     
     */
    public void setEstablishmentApplicationResponse(EstablishmentApplicationResponse value) {
        this.establishmentApplicationResponse = value;
    }

}
