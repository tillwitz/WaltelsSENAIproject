package gerencia.hotel.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class M_Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return nome;
    }

    public void setUsuario(String usuario) {
        this.nome = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
