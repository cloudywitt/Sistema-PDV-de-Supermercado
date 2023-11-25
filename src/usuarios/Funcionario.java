package usuarios;

public class Funcionario extends Usuario {
    
    private String nome_usuario;
    private String senha_usuario;
    private int HoraEntrada;
    private int HoraSaida;

    //Construtor

    public Funcionario(String nome_usuario, String senha_usuario, int HoraEntrada, int HoraSaida, String id, String sexo, int cpf) {
        super(id, sexo, cpf);
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;
        this.HoraEntrada = HoraEntrada;
        this.HoraSaida = HoraSaida;
    }
    
    
    //Setters and Getters

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public int getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(int HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public int getHoraSaida() {
        return HoraSaida;
    }

    public void setHoraSaida(int HoraSaida) {
        this.HoraSaida = HoraSaida;
    }

    
    //Métodos
    
    public void PesquisarProdutos() {
        
    }   
    
    public double ExibeCarrinho() {
        
        return 0;
        
    }
    
    public double TotalCompra() {
        
        return 0;
        
    }
    
    public void FecharCompra() {
        
    }
    
}
