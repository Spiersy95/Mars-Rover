package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;
import InputParsers.PlateauSize;
import InputParsers.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void driveInsideInteriorTest() throws NotDrivableLocationException {
        PlateauSize plateauSize = new PlateauSize(4, 4);
        Plateau plateau = new Plateau(plateauSize);
        Position position1 = new Position(2,3, CompassDirection.N);
        Position position2 = new Position(2,2, CompassDirection.S);
        Position position3 = new Position(2,3, CompassDirection.E);
        Position position4 = new Position(2,3, CompassDirection.W);

        Rover rover1 = new Rover(position1, plateau);
        Rover rover2 = new Rover(position2, plateau);
        Rover rover3 = new Rover(position3, plateau);
        Rover rover4 = new Rover(position4, plateau);

        rover1.drive();
        rover2.drive();
        rover3.drive();
        rover4.drive();

        assertEquals(2, rover1.getPosition().getX());
        assertEquals(4, rover1.getPosition().getY());
        assertEquals(CompassDirection.N, rover1.getPosition().getFacing());

        assertEquals(2, rover2.getPosition().getX());
        assertEquals(1, rover2.getPosition().getY());
        assertEquals(CompassDirection.S, rover2.getPosition().getFacing());

        assertEquals(3, rover3.getPosition().getX());
        assertEquals(3, rover3.getPosition().getY());
        assertEquals(CompassDirection.E, rover3.getPosition().getFacing());

        assertEquals(1, rover4.getPosition().getX());
        assertEquals(3, rover4.getPosition().getY());
        assertEquals(CompassDirection.W, rover4.getPosition().getFacing());
    }

    @Test
    void driveBoundaryTest() throws NotDrivableLocationException {
        PlateauSize plateauSize = new PlateauSize(4, 4);
        Plateau plateau = new Plateau(plateauSize);
        Position position1 = new Position(0,3, CompassDirection.W);
        Position position2 = new Position(2,0, CompassDirection.N);
        Position position3 = new Position(2,4, CompassDirection.E);
        Position position4 = new Position(4,3, CompassDirection.E);

        Rover rover1 = new Rover(position1, plateau);
        Rover rover2 = new Rover(position2, plateau);
        Rover rover3 = new Rover(position3, plateau);
        Rover rover4 = new Rover(position4, plateau);

        assertThrows(Exception.class, rover1::drive);

        rover2.drive();
        assertEquals(2, rover2.getPosition().getX());
        assertEquals(1, rover2.getPosition().getY());
        assertEquals(CompassDirection.N, rover2.getPosition().getFacing());


        rover3.drive();
        assertEquals(3, rover3.getPosition().getX());
        assertEquals(4, rover3.getPosition().getY());
        assertEquals(CompassDirection.E, rover3.getPosition().getFacing());

        assertThrows(Exception.class, rover4::drive);

    }

    @Test
    void rotate(){

        PlateauSize plateauSize = new PlateauSize(5, 3);

        Plateau plateau = new Plateau(plateauSize);

        Position positionN = new Position(2,2, CompassDirection.N);
        Position positionE = new Position(2,2, CompassDirection.E);
        Position positionS = new Position(2,2, CompassDirection.S);
        Position positionW = new Position(2,2, CompassDirection.W);

        Rover roverNR = new Rover(positionN, plateau);
        Rover roverNL = new Rover(positionN, plateau);
        Rover roverNM = new Rover(positionN, plateau);

        Rover roverER = new Rover(positionE, plateau);
        Rover roverEL = new Rover(positionE, plateau);
        Rover roverEM = new Rover(positionE, plateau);

        Rover roverSR = new Rover(positionS, plateau);
        Rover roverSL = new Rover(positionS, plateau);
        Rover roverSM = new Rover(positionS, plateau);

        Rover roverWR = new Rover(positionW, plateau);
        Rover roverWL = new Rover(positionW, plateau);
        Rover roverWM = new Rover(positionW, plateau);

        roverNR.rotate(Instruction.R);
        roverNL.rotate(Instruction.L);
        roverNM.rotate(Instruction.M);

        roverER.rotate(Instruction.R);
        roverEL.rotate(Instruction.L);
        roverEM.rotate(Instruction.M);

        roverSR.rotate(Instruction.R);
        roverSL.rotate(Instruction.L);
        roverSM.rotate(Instruction.M);

        roverWR.rotate(Instruction.R);
        roverWL.rotate(Instruction.L);
        roverWM.rotate(Instruction.M);

        assertEquals(CompassDirection.E, roverNR.getFacing.get());
        assertEquals(CompassDirection.W, roverNL.getFacing.get());
        assertEquals(CompassDirection.N, roverNM.getFacing.get());

        assertEquals(CompassDirection.S, roverER.getFacing.get());
        assertEquals(CompassDirection.N, roverEL.getFacing.get());
        assertEquals(CompassDirection.E, roverEM.getFacing.get());

        assertEquals(CompassDirection.W, roverSR.getFacing.get());
        assertEquals(CompassDirection.E, roverSL.getFacing.get());
        assertEquals(CompassDirection.S, roverSM.getFacing.get());

        assertEquals(CompassDirection.N, roverWR.getFacing.get());
        assertEquals(CompassDirection.S, roverWL.getFacing.get());
        assertEquals(CompassDirection.W, roverWM.getFacing.get());
    }
}