package br.com.contato.modelo;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Contato {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	private int id;
	private String nome;
	private String fone;
	private Calendar nascimento;
}
