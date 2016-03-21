/**
 * MyFirstSOAPWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.estudo.ws.soap.exemplo1;

public interface MyFirstSOAPWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMyFirstSOAPWebServicePortAddress();

    public br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebService getMyFirstSOAPWebServicePort() throws javax.xml.rpc.ServiceException;

    public br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebService getMyFirstSOAPWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
