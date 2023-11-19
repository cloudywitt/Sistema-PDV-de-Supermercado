package usuarios;

import java.util.ArrayList;
import java.util.List;
class Usuario {
    private String id;
    private String senha;
    public Usuario (String id, String senha){
        this.id = id;
        this.senha = senha;
    }
    public String getId() {
        return id;
    }
    public String getSenha(){
        return senha;
    }
}
