package Logic;

import DataTypes.CompassDirection;
import DataTypes.PlateauSize;
import DataTypes.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {



    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Plateau/onPlateau/onPlateauTrue.csv", numLinesToSkip = 1)
    void onPlateauTrueTest(String width, String length, String direction) {
        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau plateau = new Plateau(plateauSize);
        Position position = new Position(Integer.parseInt(width),
                Integer.parseInt(length),
                CompassDirection.valueOf(direction));

        assertTrue(plateau.onSurface(position));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Plateau/onPlateau/onPlateauFalse.csv", numLinesToSkip = 1)
    void onPlateauFalseTest(String X, String Y, String direction) {
        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau plateau = new Plateau(plateauSize);
        Position position = new Position(Integer.parseInt(X),
                Integer.parseInt(Y),
                CompassDirection.valueOf(direction));
        assertFalse(plateau.onSurface(position));
    }
}
