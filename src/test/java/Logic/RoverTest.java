package Logic;

import DataTypes.CompassDirection;
import DataTypes.Instruction;
import DataTypes.PlateauSize;
import DataTypes.Position;
import InputParsers.InstructionParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Rover/drive/driveInterior.csv", numLinesToSkip = 1)
    void driveInsideInteriorTest(String X, String Y, String direction, String ExpectedFirst, String ExpectedSecond ) throws NotDrivableLocationException {
        Position position = new Position(Integer.parseInt(X), Integer.parseInt(Y), CompassDirection.valueOf(direction));

        Rover rover = new Rover(position);

        PlateauSize plateauSize = new PlateauSize(4, 4);
        Plateau plateau = new Plateau(plateauSize);

        plateau.addVehicleToSurface(rover);

        rover.drive(plateau);

        assertEquals(Integer.parseInt(ExpectedFirst), rover.getPosition().getX());
        assertEquals(Integer.parseInt(ExpectedSecond), rover.getPosition().getY());
        assertEquals(CompassDirection.valueOf(direction), rover.getPosition().getFacing());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Rover/drive/driveBoundaryTrue.csv", numLinesToSkip = 1)
    void driveBoundaryTrueTest(String X, String Y, String direction,String expectedFirst, String expectedSecond) throws NotDrivableLocationException {
        PlateauSize plateauSize = new PlateauSize(4, 4);
        Plateau plateau = new Plateau(plateauSize);

        Position position = new Position(Integer.parseInt(X),
                Integer.parseInt(Y),
                CompassDirection.valueOf(direction));

        Rover rover = new Rover(position);

        plateau.addVehicleToSurface(rover);

        rover.drive(plateau);

        assertEquals(Integer.parseInt(expectedFirst), rover.getPosition().getX());
        assertEquals(Integer.parseInt(expectedSecond), rover.getPosition().getY());
        assertEquals(CompassDirection.valueOf(direction), rover.getPosition().getFacing());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Rover/drive/driveBoundaryThrows.csv", numLinesToSkip = 1)
    void driveBoundaryThrowTest(String X, String Y, String direction) throws NotDrivableLocationException {
        PlateauSize plateauSize = new PlateauSize(4, 4);
        Plateau plateau = new Plateau(plateauSize);

        Position position = new Position(Integer.parseInt(X),
                Integer.parseInt(Y),
                CompassDirection.valueOf(direction));

        Rover rover = new Rover(position);

        plateau.addVehicleToSurface(rover);

        assertThrows(Exception.class, () -> rover.drive(plateau));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Rover/rotate.csv", numLinesToSkip = 1)
    void rotate(String direction, String turn, String expectation) {

        PlateauSize plateauSize = new PlateauSize(5, 3);

        Plateau plateau = new Plateau(plateauSize);

        Position position = new Position(2, 2, CompassDirection.valueOf(direction));


        Rover rover= new Rover(position);

        plateau.addVehicleToSurface(rover);

        rover.rotate(Instruction.valueOf(turn));

        assertEquals(CompassDirection.valueOf(expectation), rover.getFacing.get());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Logic/Rover/followInstructions.csv", numLinesToSkip = 1)
    void followInstructionsTest(String X,
                                String Y,
                                String direction,
                                String expectedFirst,
                                String expectedSecond,
                                String expectedLast,
                                String instructionString) {
        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau plateau = new Plateau(plateauSize);

        InstructionParser instructionParser = new InstructionParser();

        Position position = new Position(Integer.parseInt(X), Integer.parseInt(Y), CompassDirection.valueOf(direction));

        Rover rover = new Rover(position);

        plateau.addVehicleToSurface(rover);

        Instruction[] input = instructionParser.stringToInstructions(instructionString);

        int expectedOutput1x = Integer.parseInt(expectedFirst);
        int expectedOutput1y = Integer.parseInt(expectedSecond);
        CompassDirection expectedOutput1Dir = CompassDirection.valueOf(expectedLast);

        rover.followInstructions(input, plateau);

        assertEquals(expectedOutput1x, rover.getPosition().getX());
        assertEquals(expectedOutput1y, rover.getPosition().getY());
        assertEquals(expectedOutput1Dir, rover.getFacing.get());

    }

}