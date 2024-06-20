import java.time.LocalDate;

public class Pessoa {
    //Atributos criados para Pessoa
    protected String nome;
    protected LocalDate data_Nascimento;

    public Pessoa(String nome, LocalDate data_Nascimento) {
        this.nome = nome;
        this.data_Nascimento = data_Nascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_Nascimento() {
        return data_Nascimento;
    }
}
