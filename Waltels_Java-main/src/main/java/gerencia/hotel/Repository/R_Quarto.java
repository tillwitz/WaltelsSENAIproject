package gerencia.hotel.Repository;

import gerencia.hotel.Model.M_Quarto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Quarto extends JpaRepository<M_Quarto, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Quarto q SET q.status = :status WHERE q.id = :quartoId")
    void atualizarStatusReserva(@Param("quartoId") Long quartoId, @Param("status") String status);
}
