package br.com.pratice.unittests.methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MethodTest {

    String textToTest = "";
    Method method;

    @BeforeEach
    public void setUp() {
        textToTest = "Hoje a aula é sobre testes unitários!";
        method = new Method();
    }

    @Test
    public void shouldValidateString() {
        boolean isValid = method.lenghtValidator(textToTest);
        assertTrue(isValid);
    }

    @Test
    public void shouldReturnFalseWhenStringHasLenghtGreaterThanZero() {
        textToTest = "";
        boolean isValid = method.lenghtValidator(textToTest);
        assertFalse(isValid);
    }

    @Test
    public void shouldValidateAllWeekDays() {
        String dayOne = method.returnWeekDayName(1);
        assertEquals("O primeiro dia da semana é domingo", dayOne);

        String dayTwo = method.returnWeekDayName(2);
        assertEquals("O segundo dia da semana é segunda-feira", dayTwo);

        String dayThree = method.returnWeekDayName(3);
        assertEquals("O terceiro dia da semana é terça-feira", dayThree);

        String dayFour = method.returnWeekDayName(4);
        assertEquals("O quarto dia da semana é quarta-feira", dayFour);

        String dayFive = method.returnWeekDayName(5);
        assertEquals("O quinto dia da semana é quinta-feira", dayFive);

        String daySix = method.returnWeekDayName(6);
        assertEquals("O sexto dia da semana é sexta-feira", daySix);

        String daySeven = method.returnWeekDayName(7);
        assertEquals("O sétimo dia da semana é sábado", daySeven);
    }

    @Test
    public void shouldValidateNonWeekDays() {
        String day = method.returnWeekDayName(8);
        assertEquals("As posições dos dias da semana são de 1-7", day);

        day = method.returnWeekDayName(0);
        assertEquals("As posições dos dias da semana são de 1-7", day);

        day = method.returnWeekDayName(-100);
        assertEquals("As posições dos dias da semana são de 1-7", day);
    }

    @Test
    public void shouldReturnEmptyList() {
        List<Integer> integers = method.populateList(-12);
        assertEquals(integers, new ArrayList<>());

    }

    @Test
    public void validateMethodListPopulation() {
        List<Integer> integers = method.populateList(20);
        assertFalse(integers.isEmpty());
    }

    @Test
    public void shouldValidateWeekDayNumber() {

        int day1 = method.returnWeekDayNumber("domingo");
        assertEquals(1, day1);

        int day2 = method.returnWeekDayNumber("segunda-feira");
        assertEquals(2, day2);

        int day3 = method.returnWeekDayNumber("terça-feira");
        assertEquals(3, day3);

        int day4 = method.returnWeekDayNumber("quarta-feira");
        assertEquals(4, day4);

        int day5 = method.returnWeekDayNumber("quinta-feira");
        assertEquals(5, day5);

        int day6 = method.returnWeekDayNumber("sexta-feira");
        assertEquals(6, day6);

        int day7 = method.returnWeekDayNumber("sabado");
        assertEquals(7, day7);

        int day9 = method.returnWeekDayNumber("eaksdasndasdians");
        assertEquals(0, day9);
    }

    @Test
    public void shouldValidateNonWeekDayss() {
        String nome = "asdmasldma";
        int day = method.returnWeekDayNumber(nome);

        if (day == 0) {
            assertEquals(0, day);
        }
    }

    @Test
    public void shouldBeReturnFactorial1() {

        int fatorial = method.fatorial(1);
        assertEquals(1, fatorial);
    }

    @Test
    public void shouldBeReturnFactorial5() {
        int fatorial = method.fatorial(5);
        assertEquals(120, fatorial);
    }
}

