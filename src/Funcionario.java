import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Classe Funcionario extende-se(herda) da classe Pessoa e recebe seus atributos.
 *
 * Classe Funcionario implementa um Comparable do tipo Pessoa e implementa método compareTo para
 * comparar os nomes contidos na classe subclasse Funcionario.
 *
 */


public class Funcionario extends Pessoa implements Comparable<Pessoa> {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate data_Nascimento, BigDecimal salario,String funcao ){
        super(nome,data_Nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return nome.compareToIgnoreCase(pessoa.getNome());
    }

    public String getFuncao() {
        return funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    /**
     * Método do tipo DateTipeFormatter criado para formatar
     * o dia, mês e ano em formato dd/mm/aaaa.
     */
    private static final DateTimeFormatter formatadorDeTempo = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    /**
     *.Importa a Classe Locale e NumberFormat para formatar o valor
     * para o valor monetário Brasileiro.
     */
    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt","BR"));
        return "nome = "+nome + ", data_Nascimento = " + data_Nascimento.format(formatadorDeTempo) + ", salario = " + numberFormat.format(salario) +
                ", funcao = '" + funcao + '\'';
    }

}
