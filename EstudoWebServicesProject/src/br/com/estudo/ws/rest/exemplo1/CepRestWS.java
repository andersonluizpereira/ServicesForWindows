package br.com.estudo.ws.rest.exemplo1;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;




@Path("ceprest")
public class CepRestWS {

	    @SuppressWarnings("unused")
	    @Context
	    private UriInfo context;

	public CepRestWS(){
		
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCep/{cep}")
	public Cep getCep(@PathParam("cep") String cep){
	   	Cep toReturn = new Cep();
		toReturn.setCep(cep);
		toReturn.setBairro("Bairro "+new Random().nextInt());
		toReturn.setNumero(new Random().nextInt());
		toReturn.setRua("Rua que sempre "+new Random().nextInt());
		toReturn.setUf("SP");
		/*
		 $.getJSON("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=json", {}, function (data) {
	            if (data.resultado_txt == 'sucesso - cep completo') {
	                $('#Endereco').val(data.tipo_logradouro +' '+data.logradouro);
	                $('#Bairro').val(data.bairro);
	                $('#Cidade').val(data.cidade);
	                $('#Estado').val(data.uf);
	            }

	        });
		*/
		
		
		
		return toReturn;
	}
	
}
