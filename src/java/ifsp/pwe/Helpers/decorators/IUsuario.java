package ifsp.pwe.Helpers.decorators;

import java.io.IOException;

public interface IUsuario {
    public void login() throws IOException;
    
    public void setId(Integer id);
    public Integer getId();
    public void setNome(String nome);
    public void setEmail(String email);
    public String getEmail();
    public void setSenha(String senha);
}
