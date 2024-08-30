import com.google.gson.annotations.SerializedName;

public class Endereco {
    public String cep;
    @SerializedName("logradouro")
    public String rua;
    public String bairro;
    @SerializedName("localidade")
    public String cidade;
    public String uf;

    public String logString(){
        return "[ CEP: "+cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "CEP: '" + cep + '\'' +
                ", Rua: '" + rua + '\'' +
                ", Bairro: '" + bairro + '\'' +
                ", Cidade: '" + cidade + '\'' +
                ", Estado: '" + uf + '\'' +
                '}';
    }
}
