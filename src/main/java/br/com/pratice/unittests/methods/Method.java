package br.com.pratice.unittests.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Method {

    public boolean lenghtValidator(String text) {
        if (text.length() > 0) {
            return true;
        }
        return false;
    }

    public String returnWeekDayName(int day) {

        if (day <= 0 || day > 7) {
            return "As posições dos dias da semana são de 1-7";
        }

        if (day == 1) {
            return "O primeiro dia da semana é domingo";
        } else if (day == 2) {
            return "O segundo dia da semana é segunda-feira";
        } else if (day == 3) {
            return "O terceiro dia da semana é terça-feira";
        } else if (day == 4) {
            return "O quarto dia da semana é quarta-feira";
        } else if (day == 5) {
            return "O quinto dia da semana é quinta-feira";
        } else if (day == 6) {
            return "O sexto dia da semana é sexta-feira";
        } else {
            return "O sétimo dia da semana é sábado";
        }
    }

    /**
     * Os códigos abaixo não possuem testes unitários.
     * TODO
     * Implemente os testes unitários PARA TODOS OS POSSÍVEIS FLUXOS e as particularidades abaixo
     * <p>
     * 1- Para o método de lista, adicione um novo if para caso o limite seja 0 ou negativo. Nesse caso, uma lista vazia deve ser devolvida
     * 2- Para o método de WeekDayNumber, deve ser adicionado um novo if para qualquer texto que não seja um dia da semana.
     * 3- Deve ser implementado um método de cálculo de fatorial (n!) de forma recursiva. (Dica: pesquisar o que são funções recursivas)
     */

    public List<Integer> populateList(int limit) {
        List<Integer> integers = new ArrayList<>();
        System.out.println("O limite de execuções é: " + limit);

        if (limit <= 0) {
            return integers;
        } else {
            for (int i = 0; i < limit; i++) {
                int numberToAdd = new Random().nextInt();
                integers.add(numberToAdd);
                System.out.println("O número adicionado é: " + numberToAdd);
            }
            return integers;
        }
    }

    public int returnWeekDayNumber(String weekDayName) {

        if (weekDayName.equalsIgnoreCase("Domingo")) {
            return 1;
        } else if (weekDayName.equalsIgnoreCase("Segunda-feira")) {
            return 2;
        } else if (weekDayName.equalsIgnoreCase("Terça-feira")) {
            return 3;
        } else if (weekDayName.equalsIgnoreCase("Quarta-feira")) {
            return 4;
        } else if (weekDayName.equalsIgnoreCase("Quinta-feira")) {
            return 5;
        } else if (weekDayName.equalsIgnoreCase("Sexta-feira")) {
            return 6;
        } else if (weekDayName.equalsIgnoreCase("Sabado")) {
            return 7;
        } else {
            System.out.println("Este não é um dia da semana");
            return 0;
        }
    }

    public int fatorial(int x) {
        // Se x for igual a 0 (zero) então retorna 1.
        if (x == 0)
            return 1;
    /* Para qualquer outro número, calcula o seu valor multiplicado
       pelo fatorial de seu antecessor. */
        return x * fatorial(x - 1);
    }
}
