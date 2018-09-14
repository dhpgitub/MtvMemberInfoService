//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.22 at 11:02:15 AM CDT 
//


package com.deanhealthplan.memberinfo.domain.api.networkidsearch;

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
 *         &lt;element ref="{}ContractId"/>
 *         &lt;element ref="{}MemberId"/>
 *         &lt;element ref="{}EffectiveDateStart"/>
 *         &lt;element ref="{}EffectiveDateEnd"/>
 *         &lt;element ref="{}NetworkId" minOccurs="0"/>
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
    "contractId",
    "memberId",
    "effectiveDateStart",
    "effectiveDateEnd",
    "networkId"
})
@XmlRootElement(name = "MemberInput")
public class MemberInput {

    @XmlElement(name = "ContractId", required = true)
    protected String contractId;
    @XmlElement(name = "MemberId", required = true)
    protected String memberId;
    @XmlElement(name = "EffectiveDateStart", required = true)
    protected String effectiveDateStart;
    @XmlElement(name = "EffectiveDateEnd", required = true)
    protected String effectiveDateEnd;
    @XmlElement(name = "NetworkId")
    protected String networkId;

    /**
     * Gets the value of the contractId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * Sets the value of the contractId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractId(String value) {
        this.contractId = value;
    }

    /**
     * Gets the value of the memberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberId(String value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the effectiveDateStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDateStart() {
        return effectiveDateStart;
    }

    /**
     * Sets the value of the effectiveDateStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDateStart(String value) {
        this.effectiveDateStart = value;
    }

    /**
     * Gets the value of the effectiveDateEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDateEnd() {
        return effectiveDateEnd;
    }

    /**
     * Sets the value of the effectiveDateEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDateEnd(String value) {
        this.effectiveDateEnd = value;
    }

    /**
     * Gets the value of the networkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkId() {
        return networkId;
    }

    /**
     * Sets the value of the networkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkId(String value) {
        this.networkId = value;
    }

}
