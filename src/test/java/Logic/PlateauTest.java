package Logic;

import InputParsers.CompassDirection;
import InputParsers.PlateauSize;
import InputParsers.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void onPlateau() {
        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau plateau = new Plateau(plateauSize);

        Position position1 = new Position(0,0, CompassDirection.N);
        Position position2 = new Position(5,5, CompassDirection.S);
        Position position3 = new Position(3,4, CompassDirection.E);
        Position position4 = new Position(6,0, CompassDirection.N);
        Position position5 = new Position(0,700, CompassDirection.W);
        Position position6 = new Position(-20,3, CompassDirection.S);
        Position position7 = new Position(4,-1, CompassDirection.W);
        Position position8 = new Position(-9,-9, CompassDirection.E);

        assertTrue(plateau.onPlateau(position1));
        assertTrue(plateau.onPlateau(position2));
        assertTrue(plateau.onPlateau(position3));

        assertFalse(plateau.onPlateau(position4));
        assertFalse(plateau.onPlateau(position5));
        assertFalse(plateau.onPlateau(position6));
        assertFalse(plateau.onPlateau(position7));
        assertFalse(plateau.onPlateau(position8));




    }
}
