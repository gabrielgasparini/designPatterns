package ifsp.pwe.Beans;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Integer getId(){
        return this.id;
    }
}