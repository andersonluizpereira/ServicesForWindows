package br.com.estudo.ws.soap.exemplo1;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;

@WebService
public class MyFirstSOAPWebService {

	@WebMethod
	public String ping(@WebParam(name="nome")@NotNull String nome){
		
		return "Pong !" +nome;
		
	}
	
	@WebMethod(operationName="MostreMinhaIdade",exclude=true)
	public Integer getAge(){
		
		return new Random().nextInt();
	}
}
