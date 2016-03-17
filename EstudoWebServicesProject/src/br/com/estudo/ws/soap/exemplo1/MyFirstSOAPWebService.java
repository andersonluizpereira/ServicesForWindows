package br.com.estudo.ws.soap.exemplo1;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
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
}
