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
	@XmlElement
	private Carro erroXMLProfundo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (cor != other.cor)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Carro getErroXMLProfundo() {
		return erroXMLProfundo;
	}

	public void setErroXMLProfundo(Carro erroXMLProfundo) {
		this.erroXMLProfundo = erroXMLProfundo;
	}

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
