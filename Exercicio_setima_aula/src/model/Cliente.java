package model;
import java.io.Serializable;
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String fone;
	private String email;
	public Cliente() {
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
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return"Cliente [id=" + id + ", nome=" + nome + ", fone=" + fone
				+ ", email=" + email + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;

		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
		return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
		return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
		return false;
		return true;
	}
}