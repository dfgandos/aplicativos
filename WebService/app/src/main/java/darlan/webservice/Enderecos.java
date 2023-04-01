package natalia.webservice;

public class Enderecos {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    public Enderecos (String cep) {
        this.cep = cep;
    }
    public Enderecos () { }
    @Override
    public String toString() {
        return "Cep: " + cep + "\n"
                + "Logradouro: " + logradouro + "\n"
                + "Complemento: " + complemento + "\n"
                + "Bairro: " + bairro + "\n"
                + "Localidade: " + cidade + "\n";
    }


    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro(){
        return logradouro;
    }
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }
    public String getComplemento(){
        return complemento;
    }
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getUf(){
        return uf;
    }
    public void setUf(String uf){
        this.uf = uf;
    }


}
