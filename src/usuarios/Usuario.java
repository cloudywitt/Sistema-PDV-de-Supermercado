package usuarios;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String id;
    private String senha;
    private int cpf;

    //Construtor
    
    public Usuario (String id, String senha, int cpf) {
        this.id = id;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    //Getters and Setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
