package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "conta_seq", name = "grupo_id")
public class Grupo extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_id")
	private long id;
	private int numeroParticipantes;
	private int idvencedor;
	@OneToMany(cascade={CascadeType.ALL},mappedBy="grupo")
	private List<Usuario> usuarios;
	@ManyToOne
	private Promocao promocao;

	public List<Usuario> getUsuario() {
		return usuarios;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuarios = usuario;
	}

	public void setVencedor(int idvencedor) {
		this.idvencedor = idvencedor;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public int getVencedor() {
		return idvencedor;
	}

}
