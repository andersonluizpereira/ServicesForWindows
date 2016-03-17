package br.com.estudo.ws.soap.exemplo1;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;

//Declara��o do WebService com anota��o @WebService
@WebService
public class MyFirstSOAPWebService {

	//Declara��o do WebMethod com anota��o @WebMethod, onde se, cria as classes
	//com os parametros exemplo @WebParam(name="nome"), com o propriedade, com o nome embutido
	//Permitindo valor nulo ou n�o com @NotNull
	@WebMethod
	public String ping(@WebParam(name="nome")@NotNull String nome){
		
		return "Pong !" +nome;
		
	}
	//Voc� consegue indicar o nome do m�todo operationName="MostreMinhaIdade"
	//caso, queira excluir o m�todo, tem que inserir o exclude
	@WebMethod(operationName="MostreMinhaIdade",exclude=true)
	public Integer getAge(){
		
		return new Random().nextInt();
	}
}
