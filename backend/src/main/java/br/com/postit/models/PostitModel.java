package br.com.postit.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_postit")
public class PostitModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime date;
	
	@NotNull
	private String descricao;
	
	public PostitModel() {}
	
	
	public PostitModel(LocalDateTime date, String descricao) {
		this.date = date;
		this.descricao = descricao;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public long getId() {
		return id;
	}


	@Override
	public String toString() {
		return " Data Adição= " + date + ", "
						+ "Descrição= " + descricao;
	}
	
	
	

}
