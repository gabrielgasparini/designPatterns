package ifsp.pwe.Beans;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public boolean entrar(String email, String senha){
        return true;
    }
}