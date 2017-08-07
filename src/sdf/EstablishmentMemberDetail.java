//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 01:52:13 PM GST 
//


package sdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstablishmentMemberDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstablishmentMemberDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="memberTypeId" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="UDB" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="establishmentCode" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="signatory" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstablishmentMemberDetail")
public class EstablishmentMemberDetail {

    @XmlAttribute(name = "memberTypeId", required = true)
    protected long memberTypeId;
    @XmlAttribute(name = "UDB")
    protected Long udb;
    @XmlAttribute(name = "establishmentCode")
    protected Long establishmentCode;
    @XmlAttribute(name = "signatory")
    protected Boolean signatory;

    /**
     * Gets the value of the memberTypeId property.
     * 
     */
    public long getMemberTypeId() {
        return memberTypeId;
    }

    /**
     * Sets the value of the memberTypeId property.
     * 
     */
    public void setMemberTypeId(long value) {
        this.memberTypeId = value;
    }

    /**
     * Gets the value of the udb property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUDB() {
        return udb;
    }

    /**
     * Sets the value of the udb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUDB(Long value) {
        this.udb = value;
    }

    /**
     * Gets the value of the establishmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEstablishmentCode() {
        return establishmentCode;
    }

    /**
     * Sets the value of the establishmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEstablishmentCode(Long value) {
        this.establishmentCode = value;
    }

    /**
     * Gets the value of the signatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSignatory() {
        return signatory;
    }

    /**
     * Sets the value of the signatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSignatory(Boolean value) {
        this.signatory = value;
    }

}
