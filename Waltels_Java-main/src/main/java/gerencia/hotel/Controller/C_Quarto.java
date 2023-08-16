package gerencia.hotel.Controller;

import gerencia.hotel.Model.M_Quarto;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Quarto {



        @GetMapping("/quartos")
        public String listarQuartos(M_Quarto quarto) {
            // Obtenha os quartos disponíveis do seu serviço ou repositório
            List<M_Quarto> quartos = // Obtenha os quartos disponíveis do seu serviço ou repositório
                    quarto.addAttribute("quartos", quartos);
            return "quartos";
        }

        @PostMapping("/atualizar-status")
        public String atualizarStatus(@RequestParam("quartoId") Long quartoId, @RequestParam("novoStatus") String novoStatus) {
            // Lógica para atualizar o status do quarto com o quartoId no servidor
            // ...

            return "redirect:/quartos"; // Redireciona de volta para a página de quartos
        }

}