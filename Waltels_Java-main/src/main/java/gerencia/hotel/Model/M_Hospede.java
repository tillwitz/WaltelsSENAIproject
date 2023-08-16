package gerencia.hotel.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospedes")
public class M_Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hospede;

    private String nome;
    private String sobrenome;
    private String endereco;
    private String cidade;
    private String pais;
    private String telefone;
    private String email;

    // getters and setters

    public Long getId_hospede() {
        return id_hospede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

