package gerencia.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class C_Cadastro {

    @GetMapping("/cadastro")
    public String pageCadastroUsuario() {
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastroUsuario(@RequestParam("email") String email, @RequestParam("senha") String senha, RedirectAttributes redirectAttributes) {
        if(email.equals(null) && senha.equals(null) || email.equals("") && senha.equals("")) {
            redirectAttributes.addFlashAttribute("CadastroError", "Insira um email ou senha corretos!");
            return "redirect:/cadastro";
        } else {
            redirectAttributes.addFlashAttribute("CadastroSucess", "Conta Cadastrada com Sucesso!");
            return "redirect:/";
        }
    }
}
