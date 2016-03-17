package br.com.estudo.ws.soap.exemplo1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carro implements java.io.Serializable {
	
	@XmlElement
	private String nome;
	@XmlElement
	private String marca;
	@XmlElement
	private CorType cor;
	
	public Carro(){
		
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public CorType getCor() {
		return cor;
	}
	public void setCor(CorType cor) {
		this.cor = cor;
	}

}
