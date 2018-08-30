package model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String bairro;
	private String complemento;
	private String cidade;
	private int numero;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		return "\nrua = " + getRua() + "\nbairro = " + getBairro() + "\ncomplemento = " + getComplemento()
				+ "\ncidade = " + getCidade() + "\nnumero = " + getNumero() + "\n";
	}

}
