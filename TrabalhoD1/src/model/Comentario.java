package model;

public class Comentario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String texto;
	
	
	public Comentario() {}
	
	public Comentario(int id, String nome, String texto) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
	}
	
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}