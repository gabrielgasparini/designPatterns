package ifsp.pwe.Beans;

import ifsp.pwe.Dao.UsuarioDao;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public boolean entrar(String email, String senha){
        Usuario usuario = new UsuarioDao().entrar(email, senha);
        if(usuario != null){
            return true;
        }else{
            return false;
        }
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