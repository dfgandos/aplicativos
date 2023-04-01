package natalia.pratica06;

public class Contato {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Contato(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome + "\n" + email + "\n" + telefone + "\n" + endereco + "\n" + id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() { return telefone; }

    public String getEndereco() { return endereco; }
}