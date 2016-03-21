/**
 * MyFirstSOAPWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.estudo.ws.soap.exemplo1;

public class MyFirstSOAPWebServiceServiceLocator extends org.apache.axis.client.Service implements br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebServiceService {

    public MyFirstSOAPWebServiceServiceLocator() {
    }


    public MyFirstSOAPWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyFirstSOAPWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyFirstSOAPWebServicePort
    private java.lang.String MyFirstSOAPWebServicePort_address = "http://tuxix:8080/EstudoWebServicesProject/MyFirstSOAPWebServiceService";

    public java.lang.String getMyFirstSOAPWebServicePortAddress() {
        return MyFirstSOAPWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyFirstSOAPWebServicePortWSDDServiceName = "MyFirstSOAPWebServicePort";

    public java.lang.String getMyFirstSOAPWebServicePortWSDDServiceName() {
        return MyFirstSOAPWebServicePortWSDDServiceName;
    }

    public void setMyFirstSOAPWebServicePortWSDDServiceName(java.lang.String name) {
        MyFirstSOAPWebServicePortWSDDServiceName = name;
    }

    public br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebService getMyFirstSOAPWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyFirstSOAPWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyFirstSOAPWebServicePort(endpoint);
    }

    public br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebService getMyFirstSOAPWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebServicePortBindingStub _stub = new br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getMyFirstSOAPWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyFirstSOAPWebServicePortEndpointAddress(java.lang.String address) {
        MyFirstSOAPWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebServicePortBindingStub _stub = new br.com.estudo.ws.soap.exemplo1.MyFirstSOAPWebServicePortBindingStub(new java.net.URL(MyFirstSOAPWebServicePort_address), this);
                _stub.setPortName(getMyFirstSOAPWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MyFirstSOAPWebServicePort".equals(inputPortName)) {
            return getMyFirstSOAPWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://exemplo1.soap.ws.estudo.com.br/", "MyFirstSOAPWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://exemplo1.soap.ws.estudo.com.br/", "MyFirstSOAPWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyFirstSOAPWebServicePort".equals(portName)) {
            setMyFirstSOAPWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
