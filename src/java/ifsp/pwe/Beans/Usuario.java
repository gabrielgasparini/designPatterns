package ifsp.pwe.Beans;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public boolean entrar(String email, String senha){
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}