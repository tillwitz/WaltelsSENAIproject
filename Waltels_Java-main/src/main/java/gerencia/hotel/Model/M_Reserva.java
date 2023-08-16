package gerencia.hotel.Model;


import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.Date;

@Entity
@Table(name = "reservas")
public class M_Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private M_Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "id_quarto")
    private M_Quarto quarto;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_check_in")
    private Date dataCheckIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_check_out")
    private Date dataCheckOut;

    // getters and setters

    public Long getId_reserva() {
        return id_reserva;
    }

    public <M_Hospede> M_Hospede getHospede() {
        return hospede;
    }

    public void setHospede(M_Hospede hospede) {
        this.hospede = hospede;
    }

    public M_Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(M_Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}

