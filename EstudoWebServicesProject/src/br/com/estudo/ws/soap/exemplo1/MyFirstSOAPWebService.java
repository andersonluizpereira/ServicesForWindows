package br.com.estudo.ws.soap.exemplo1;

import java.util.LinkedList;
import java.util.List;
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
		
		
		return toReturn;
	}
}
