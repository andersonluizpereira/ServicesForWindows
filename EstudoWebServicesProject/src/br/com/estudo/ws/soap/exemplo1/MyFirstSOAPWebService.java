package br.com.estudo.ws.soap.exemplo1;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.Hashtable;

import javax.naming.AuthenticationException;

import javax.naming.Context;

import javax.naming.NamingException;

import javax.naming.directory.DirContext;

import javax.naming.directory.InitialDirContext;
import javax.validation.constraints.NotNull;


//Declaração do WebService com anotação @WebService
@WebService
public class MyFirstSOAPWebService {

	//Declaração do WebMethod com anotação @WebMethod, onde se, cria as classes
	//com os parametros exemplo @WebParam(name="nome"), com o propriedade, com o nome embutido
	//Permitindo valor nulo ou não com @NotNull
	@WebMethod
	public String ping(@WebParam(name="nome")@NotNull String nome){
		
		return "Pong !" +nome;
		
	}
	//Você consegue indicar o nome do método operationName="MostreMinhaIdade"
	//caso, queira excluir o método, tem que inserir o exclude
	@WebMethod(operationName="MostreMinhaIdade",exclude=true)
	public Integer getAge(){
		
		return new Random().nextInt();
	}
	
	public List<String> getMinhaPrimeiraLista(){
		List<String> toReturn = new LinkedList<String>();
		toReturn.add("Item 1");
		toReturn.add("Item 2");
		toReturn.add("Item 3");
		toReturn.add("Item 4");
		toReturn.add("Item 5");
		
		
		return toReturn;
	}
	
	public List<Carro> getMeusCarros(){
		List<Carro> toReturn = new LinkedList<Carro>();
		
		Carro carro1 = new Carro();
		carro1.setCor(CorType.AZUL);
		carro1.setMarca("RENAULT");
		carro1.setNome("MEGANE GT");
		
		toReturn.add(carro1);
		
		Carro carro2 = new Carro();
		carro2.setCor(CorType.ROSA);
		carro2.setMarca("FIAT");
		carro2.setNome("UNO");
		
		toReturn.add(carro2);
		
	//	carro1.setErroXMLProfundo(carro2);
//		carro2.setErroXMLProfundo(carro1);
		return toReturn;
	}
	@WebMethod(operationName="AutenticarAD")
//	public Boolean autenticar(@WebParam(name="usuario")@NotNull String usuario,@WebParam(name="senha")@NotNull String senha,@WebParam(name="driver")@NotNull String _driver,@WebParam(name="provider")@NotNull String provider,@WebParam(name="domain")@NotNull String domain,@WebParam(name="porta")@NotNull String port,@WebParam(name="tipo")@NotNull String _tipo){
    public Boolean autenticar(@WebParam(name="usuario")@NotNull String usuario,@WebParam(name="senha")@NotNull String senha,@WebParam(name="domain")@NotNull String domain){
			
		
		//Hashtable authEnv;
		
		    String _usuario = (String) usuario;
	        String _senha = (String) senha;
	       String _provider = "ldap://192.168.220.128";
	        String _domain = (String) domain;
	        String _port = "389";
	        
	        
	        DirContext authContext;
			try {
				Hashtable authEnv = new Hashtable(11);
				String port1 = "0";
		/*	
				if(_port==null){
					port1="0";
				}
				
				else {
					
					port1 = String.valueOf(_port);
					
				}
			*/	
				String _driver = "com.sun.jndi.ldap.LdapCtxFactory";
				String _tipo = "simple";
				_port = "0";
				
				authEnv = new Hashtable(11);
				authEnv.put(Context.INITIAL_CONTEXT_FACTORY,_driver); 
				System.out.println("Driver " + _driver);
				
				authEnv.put(Context.PROVIDER_URL, _provider+":"+port1);
				System.out.println("PRovider "+ _provider+":"+port1);
				authEnv.put(Context.SECURITY_AUTHENTICATION, _tipo); 
				System.out.println("Tipo "+_tipo);
				authEnv.put(Context.SECURITY_PRINCIPAL, _usuario+"@"+_domain);
				System.out.println(_usuario+"@"+_domain);
				authEnv.put(Context.SECURITY_CREDENTIALS, _senha); 
				System.out.println(_senha);
				authContext = new InitialDirContext(authEnv);
				
				System.out.println("Conectou " + _usuario+"@"+_domain);
				authContext.close(); 
				return true;
			} 

			catch (AuthenticationException authEx) 
			{ 
				System.out.println("Erro na autenticação! Tente novamente."); 
				authEx.printStackTrace(); 
				return false;
			} 
			catch (NamingException namEx) 
			{ 
				//
				System.out.println("Problemas na conexão! Sua maquina pode estar fora da rede. Contate o Suporte Tecnico"); 
				namEx.getCause().printStackTrace(); 
				return false;
			} 
	}
	
}
