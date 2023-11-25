package usuarios;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String sexo;
    private int cpf;

    //Construtor
    
    public Usuario(String id, String sexo, int cpf) {
        this.id = id;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    //Getters and Setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
       
}
