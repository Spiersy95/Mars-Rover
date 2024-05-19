package UI;

import InputParsers.IncorrectPlateauFormatException;
import InputParsers.PlateauParser;
import InputParsers.PlateauSize;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlateauPrompterTest {


    @Test
    void correctInputPlateauDimPrompt(){

        PlateauParser plateauParser = new PlateauParser();
        PlateauPrompter plateauPrompter = new PlateauPrompter();


        Scanner scanner = new Scanner("5 2\n2 3");

        int ExpectedOutput1x = 5;
        int ExpectedOutput1y = 2;
        int ExpectedOutput2x = 2;
        int ExpectedOutput2y = 3;

        PlateauSize plateau1 = plateauPrompter.prompt(scanner, plateauParser);
        PlateauSize plateau2 = plateauPrompter.prompt(scanner, plateauParser);

        int actualOutput1x = plateau1.width();
        int actualOutput1y = plateau1.length();
        int actualOutput2x = plateau2.width();
        int actualOutput2y = plateau2.length();


        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutput2x, actualOutput2x);
        assertEquals(ExpectedOutput2y, actualOutput2y);

        scanner.close();

    }

    @Test
    void incorrectInputPlateauDimPrompt() throws IncorrectPlateauFormatException {
        PlateauParser plateauParser = new PlateauParser();
        PlateauPrompter plateauPrompter = new PlateauPrompter();

        Scanner scanner = new Scanner("Hello\n0 0\n-444\n-3 -3\n2 3");

        int ExpectedOutput1x = 2;
        int ExpectedOutput1y = 3;

        PlateauSize plateau1 = plateauPrompter.prompt(scanner, plateauParser);


        int actualOutput1x = plateau1.width();
        int actualOutput1y = plateau1.length();



        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);

        scanner.close();

    }

}