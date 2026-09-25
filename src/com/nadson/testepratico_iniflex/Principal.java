package com.nadson.testepratico_iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat NUMBER_FORMATTER;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        NUMBER_FORMATTER = new DecimalFormat("#,##0.00", symbols);
    }


    public static void main(String[] args) {

        // 3.1 – Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
        //3.2 Remover joão
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        //3.3 imprimir todos os funcionario com as formatações
        System.out.println("======Lista de funcionarios=======");
        funcionarios.forEach(f->System.out.printf("Nome: %s | Data de Nascimento: %s | Salário: %s R$ | Função: %s\n"
                ,f.getNome(),f.getDataNascimento().format(DATE_FORMATTER),NUMBER_FORMATTER.format(f.getSalario()),f.getFuncao()));

        //3.4 funcionarios recebem 10% de aumento
        funcionarios.forEach(f->f.setSalario(f.getSalario().add(f.getSalario().multiply(new BigDecimal("0.1")))));

        //3.5 Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Imprimir os funcionários, agrupados por função.
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\n======Funcionários da função: " + funcao + "======");
            lista.forEach(f -> System.out.printf("Nome: %s | Data de Nascimento: %s | Salário: %s R$ | Função: %s\n"
                    , f.getNome(), f.getDataNascimento().format(DATE_FORMATTER), NUMBER_FORMATTER.format(f.getSalario()), f.getFuncao()));


        });

        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("=========Funcionarios com aniversário no mês 10 e 12:=======");
funcionarios.stream().filter(f->{int mesNas=f.getDataNascimento().getMonthValue();return mesNas==10||mesNas==12;})
        .forEach(f->System.out.printf(" %s - %s\n",f.getNome(),f.getDataNascimento().format(DATE_FORMATTER)));

//3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("=======Funcionario com a maior idade:==========");
        funcionarios.stream().min(Comparator.comparingInt(f -> f.getDataNascimento().getYear()))
                .ifPresent(f ->{
                    int idade = LocalDate.now().getYear() - f.getDataNascimento().getYear();
                    System.out.printf(" %s tem %d anos\n", f.getNome(), idade);
                });
        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("========Lista de funcionarios em ordem alfabetica ========");
        funcionarios.stream().sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(f->System.out.println(f.getNome()));

        //3.11 – Imprimir o total dos salários dos funcionários.
        System.out.println("========Total dos salários dos funcionários========");
        BigDecimal totalSalarios = funcionarios.stream().map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("Total de todos os salarios: " + NUMBER_FORMATTER.format(totalSalarios)+" R$");

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("========Quantidade de salários mínimos ganhos por cada funcionário========");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(f->{
            BigDecimal quantidadeSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf(" %s - %s\n", f.getNome(), quantidadeSalarios);
        });




    }}
