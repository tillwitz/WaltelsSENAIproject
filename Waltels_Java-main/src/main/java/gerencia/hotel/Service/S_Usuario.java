package gerencia.hotel.Service;

import gerencia.hotel.Model.M_Usuario;
import gerencia.hotel.Repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario usuario;

    public S_Usuario(R_Usuario usuario){
        this.usuario = usuario;
    }

    public static M_Usuario checarLogin(String nome, String senha){
        return usuario.findByUsuarioESenha(nome,senha);
    }
}
