package usuarios;

public class Gerente extends Funcionario {

    //Construtor Padrão
    public Gerente(String nome_usuario, String senha_usuario, int HoraEntrada, int HoraSaida, String id, String sexo, int cpf) {
        super(nome_usuario, senha_usuario, HoraEntrada, HoraSaida, id, sexo, cpf);
    }

    //Métodos
    
    public void CancelarProduto() {
        
    }
    
    public void CancelarCompra() {
        
    }
    
    public void CadastrarFuncionario() {
    
    }
}
