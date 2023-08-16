package gerencia.hotel.Controller;

import gerencia.hotel.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("usuario")
public class C_Login {

    @GetMapping("/")
    public String login(Model model) {
        // Verifica se há uma mensagem de erro de login e a adiciona ao modelo para exibição no Thymeleaf
        if (!model.containsAttribute("loginError")) {
            model.addAttribute("loginError", ""); // Adiciona uma mensagem vazia para que o elemento exista no modelo
        }
        return "Login/login";
    }

    @PostMapping("/")
    public String processingLogin(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, HttpSession session, RedirectAttributes redirectAttributes) {
        session.setAttribute("usuario", S_Usuario.checarLogin(usuario, senha));
        if (session.getAttribute("usuario") != null) {
            redirectAttributes.addFlashAttribute("usuario", session.getAttribute("usuario"));
            return "redirect:/Home"; // Redireciona para a página home em caso de sucesso.
        } else {
            redirectAttributes.addFlashAttribute("loginError", "Usuário ou senha incorretos"); // Define o atributo "loginError" para exibir a mensagem de erro no Thymeleaf
            return "redirect:/";
        }
    }
}
