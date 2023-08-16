package gerencia.hotel.Model;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

@Entity
@Table(name = "quartos")
public class M_Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quarto;
    private Integer id_estabelecimento;
    private Integer numero;
    private String status;
    private String tipo;
    private Float preco;

    public M_Quarto() {
    }

    public M_Quarto(Integer id_estabelecimento, Integer numero, String status, String tipo, Float preco) {
        this.id_estabelecimento = id_estabelecimento;
        this.numero = numero;
        this.status = status;
        this.tipo = tipo;
        this.preco = preco;
    }

    /*public List addAttribute(String quartos, List quartos1) {
        return
    }*/

    public Long getId_quarto() {
        return id_quarto;
    }

    public Integer getId_estabelecimento() {
        return id_estabelecimento;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setStatus(String ocupado) {

    }
}
