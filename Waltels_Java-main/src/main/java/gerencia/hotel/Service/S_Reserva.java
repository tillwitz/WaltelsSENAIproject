package gerencia.hotel.Service;

import gerencia.hotel.Model.M_Quarto;
import gerencia.hotel.Repository.R_Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Reserva {

    private final R_Quarto quartoRepository;

    @Autowired
    public S_Reserva(R_Quarto quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public boolean fazerReserva(Long quartoId) {
        // Verificar se o quarto está disponível para reserva
        M_Quarto quarto = quartoRepository.findById(quartoId).orElse(null);
        if (quarto == null) {
            // Quarto não encontrado
            return false;
        }

        if (!"disponivel".equals(quarto.getStatus())) {
            // Quarto não está disponível para reserva
            return false;
        }

        // Efetuar a reserva do quarto
        // Aqui você pode adicionar a lógica de criação da reserva, salvar no banco de dados, etc.

        // Atualizar o status do quarto para "ocupado"
        quarto.setStatus("ocupado");
        quartoRepository.save(quarto);

        // Reserva efetuada com sucesso
        return true;
    }

    public boolean fazerCheckout(Long quartoId) {
        // Verificar se o quarto está ocupado
        M_Quarto quarto = quartoRepository.findById(quartoId).orElse(null);
        if (quarto == null) {
            // Quarto não encontrado
            return false;
        }

        if (!"ocupado".equals(quarto.getStatus())) {
            // Quarto não está ocupado
            return false;
        }

        // Efetuar o checkout do quarto
        // Aqui você pode adicionar a lógica de finalização da reserva, atualizar a data de check-out, calcular o valor a ser pago, etc.

        // Atualizar o status do quarto para "limpando"
        quarto.setStatus("limpando");
        quartoRepository.save(quarto);

        // Checkout efetuado com sucesso
        return true;
    }
}
