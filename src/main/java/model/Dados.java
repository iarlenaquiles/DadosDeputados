package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dados implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Deputado> dados;
	List<Links> links;

	public Dados(List<Deputado> dados, List<Links> links) {
		this.dados = new ArrayList<Deputado>(dados.size());
		this.links = new ArrayList<Links>(links.size());
	}

	public Dados() {

	}

	public List<Deputado> getDados() {
		return dados;
	}

	public void setDados(List<Deputado> dados) {
		this.dados = dados;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "[" + this.dados + "]";
	}

}
