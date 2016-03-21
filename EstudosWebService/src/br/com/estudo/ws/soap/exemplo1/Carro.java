/**
 * Carro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.estudo.ws.soap.exemplo1;

public class Carro  implements java.io.Serializable {
    private java.lang.String nome;

    private java.lang.String marca;

    private br.com.estudo.ws.soap.exemplo1.CorType cor;

    private br.com.estudo.ws.soap.exemplo1.Carro erroXMLProfundo;

    public Carro() {
    }

    public Carro(
           java.lang.String nome,
           java.lang.String marca,
           br.com.estudo.ws.soap.exemplo1.CorType cor,
           br.com.estudo.ws.soap.exemplo1.Carro erroXMLProfundo) {
           this.nome = nome;
           this.marca = marca;
           this.cor = cor;
           this.erroXMLProfundo = erroXMLProfundo;
    }


    /**
     * Gets the nome value for this Carro.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Carro.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the marca value for this Carro.
     * 
     * @return marca
     */
    public java.lang.String getMarca() {
        return marca;
    }


    /**
     * Sets the marca value for this Carro.
     * 
     * @param marca
     */
    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }


    /**
     * Gets the cor value for this Carro.
     * 
     * @return cor
     */
    public br.com.estudo.ws.soap.exemplo1.CorType getCor() {
        return cor;
    }


    /**
     * Sets the cor value for this Carro.
     * 
     * @param cor
     */
    public void setCor(br.com.estudo.ws.soap.exemplo1.CorType cor) {
        this.cor = cor;
    }


    /**
     * Gets the erroXMLProfundo value for this Carro.
     * 
     * @return erroXMLProfundo
     */
    public br.com.estudo.ws.soap.exemplo1.Carro getErroXMLProfundo() {
        return erroXMLProfundo;
    }


    /**
     * Sets the erroXMLProfundo value for this Carro.
     * 
     * @param erroXMLProfundo
     */
    public void setErroXMLProfundo(br.com.estudo.ws.soap.exemplo1.Carro erroXMLProfundo) {
        this.erroXMLProfundo = erroXMLProfundo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Carro)) return false;
        Carro other = (Carro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.marca==null && other.getMarca()==null) || 
             (this.marca!=null &&
              this.marca.equals(other.getMarca()))) &&
            ((this.cor==null && other.getCor()==null) || 
             (this.cor!=null &&
              this.cor.equals(other.getCor()))) &&
            ((this.erroXMLProfundo==null && other.getErroXMLProfundo()==null) || 
             (this.erroXMLProfundo!=null &&
              this.erroXMLProfundo.equals(other.getErroXMLProfundo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getMarca() != null) {
            _hashCode += getMarca().hashCode();
        }
        if (getCor() != null) {
            _hashCode += getCor().hashCode();
        }
        if (getErroXMLProfundo() != null) {
            _hashCode += getErroXMLProfundo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Carro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://exemplo1.soap.ws.estudo.com.br/", "carro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "marca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://exemplo1.soap.ws.estudo.com.br/", "corType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erroXMLProfundo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "erroXMLProfundo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://exemplo1.soap.ws.estudo.com.br/", "carro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
