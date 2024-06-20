
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * 1- O código Principal será explicado de cima para baixo em relaçao a suas Classes e métodos usados.

 *2- Classe Principal e método main para executar as ações requisitadas.

 *3- Inserido na mesma ordem as informações da tabela

 * 4- Remove o funcionário João através do método removeIf que verifica se a comparação
 * entre o nome do funcionário com o parâmetro String providenciado é verdadeira.

 * 5-Utiliza de um loop for-each para adicionar o aumento ao novo salário
 * e poder alterar o antigo salário de cada funcionário através do
 * método modificador setSalario().

 * 6-Adiciona os funcionários cada um em um Map chamado mapeamentoFuncionarios,
 * recebendo o tipo da chave(Key) e valor(value) como String e uma Lista do tipo Funcionario.

 * 7-Imprime cada função com seus devidos grupos de funcionários.

 * 8-Utiliza de um loop for-each e uma variável chamada mesDoNascimentopara para
 * imprimir apenas os funcionários que nasceram no mês de Outubro(10) e Dezembro(12).

 * 9-Cria 2 variáveis para identificar o ano atual correspondente e outra para
*  verificar a idade do Funcionario. Dentro de um loop for-each, a idade do mais velho
*  é passada para a variável de controle idadeDoFuncionarioMaisVelho todas as vezes que ela for
*  maior que a última idade comparada.No final as informações do nome e a idade do funcionário mais velho
 * são imprimidas

 * 10-Através da interface Comparable implementada na classe Funcionario
 * é possível usar o sort em Collections para ordenar de forma alfabética
 * a variável lista chamada listaOrdemAlfabetica e logo após isso imprimir
 * seus funcionários.

 * 11-Cria uma variável salarioTotal com valor 0 e atualiza o valor da mesma
 * através de um loop for-each para adicionar o salário de cada funcionário
 * a ela mesma e em seguida imprimir o valor formatado em real.

 * 12-Cria uma variável para mediar a quantidade estimada de salários minimos recebidos por funcionário,
 * Cria um formatador a partir da classe DecimalFormat para aproximar o valor eem até 1 digito e
 * em seguida imprime o nome e a quantidade média de salários mínimos recebidos.
 */

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> listaFuncionarios = new ArrayList<>(); //Lista de Funcionários.

        Map<String, List<Funcionario>> mapeamentoFuncionarios = new HashMap<>(); //Map criado para mapear os Funcionarios dentro de suas funções.

        int idadeDoFuncionarioMaisVelho = 0; //Variavel de controle para receber a idade do funcionario mais velho

        Funcionario funcionarioMaisVelho = null; //Classe instanciada para verificar o nome do funcionario através do método getNome().

        List<Funcionario> listaOrdemAlfabetica =  (listaFuncionarios); //Lista que recebe o valor da lista original para ser ordenada de forma alfabetica.

        BigDecimal salarioTotal = BigDecimal.valueOf(0.0); //Variavel de controle para receber o valor total do salario dos funcionarios.

        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt","BR")); //Variavel criada para formatar valores para moeda brasileira.


        listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        listaFuncionarios.add(new Funcionario("Artur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));


        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase("João"));


        for (Funcionario funcionarios : listaFuncionarios) {
            BigDecimal aumento = funcionarios.getSalario().multiply(BigDecimal.valueOf(0.10));
            BigDecimal novoSalario = funcionarios.getSalario().add(aumento);
            funcionarios.setSalario(novoSalario);
        }


        for (Funcionario funcionario : listaFuncionarios) {
            String funcao = funcionario.getFuncao();
            if (!mapeamentoFuncionarios.containsKey(funcao)) {
                mapeamentoFuncionarios.put(funcao, new ArrayList<>());
            }
            mapeamentoFuncionarios.get(funcao).add(funcionario);
        }

        for (Map.Entry<String, List<Funcionario>> entry : mapeamentoFuncionarios.entrySet()) {
            System.out.println("\n" + entry.getKey());
            System.out.println("--------------------------");
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println(funcionario);
            }
        }


        System.out.println("--------------------------");
        System.out.println("A seguir, funcionários que nasceram nos meses Outubro e Dezembro: ");
        for (Funcionario funcionarios : listaFuncionarios) {
            int mesDoNascimento = funcionarios.getData_Nascimento().getMonthValue();
            if (mesDoNascimento == 10 || mesDoNascimento == 12) {
                System.out.println(funcionarios);
            }
        }


        System.out.println("--------------------------");
        System.out.println("A seguir, o funcionário mais velho: ");

        for (Funcionario funcionario : listaFuncionarios) {
            int anoAtual = LocalDate.now().getYear();
            int idadeDoFuncionario = anoAtual - funcionario.getData_Nascimento().getYear();


            if (idadeDoFuncionario > idadeDoFuncionarioMaisVelho) {
                idadeDoFuncionarioMaisVelho = idadeDoFuncionario;
                funcionarioMaisVelho = funcionario;

            }
        }
        if (funcionarioMaisVelho != null) {
            System.out.println("Nome = "+funcionarioMaisVelho.getNome() + ", Idade = " +idadeDoFuncionarioMaisVelho);
        }


        System.out.println("--------------------------");
        System.out.println("A seguir a lista ordenada em ordem alfabética: ");
        System.out.println();

        Collections.sort(listaOrdemAlfabetica);
        for (Funcionario funcionarios : listaOrdemAlfabetica){
            System.out.println(funcionarios);
        }

        System.out.println("--------------------------");
        System.out.println("A seguir a soma total dos salários dos funcionários: ");
        for(Funcionario funcionario : listaFuncionarios){
            salarioTotal = salarioTotal.add(funcionario.getSalario());
        }
        System.out.println("R$"+numberFormat.format(salarioTotal));

        System.out.println("--------------------------");


        for(Funcionario funcionario : listaFuncionarios){
            BigDecimal quantidadeMediaDeSalariosMinimos = funcionario.getSalario().divide(BigDecimal.valueOf(1222), RoundingMode.FLOOR);
            DecimalFormat df = new DecimalFormat("#,##0");
            System.out.println("O funcionário: "+funcionario.getNome()+", recebe em torno de "+df.format(quantidadeMediaDeSalariosMinimos)+ " salários minimos.");

        }

    }
}
