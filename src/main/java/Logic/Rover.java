package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;
import InputParsers.Position;

import java.util.function.Function;
import java.util.function.Supplier;

import static Logic.UtilityFunctions.*;


public class Rover {

    private Position position;
    private final Plateau plateau;

    public Rover(Position position, Plateau plateau){
        this.position = position;
        this.plateau = plateau;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void drive() throws NotDrivableLocationException {
        Position nextPosition = null;
        if (getFacing.get()== CompassDirection.N) {
                nextPosition = new Position(this.getPosition().getX(),
                        this.getPosition().getY()+1,
                        CompassDirection.N);
        }
        if (getFacing.get() == CompassDirection.E){
            nextPosition = new Position(this.getPosition().getX()+1,
                    this.getPosition().getY(),
                    CompassDirection.E);
        }
        if (getFacing.get() == CompassDirection.S) {
            nextPosition = new Position(this.getPosition().getX(),
                    this.getPosition().getY() - 1,
                    CompassDirection.S);
        }
        if (getFacing.get() == CompassDirection.W) {
            nextPosition = new Position(this.getPosition().getX() - 1,
                    this.getPosition().getY(),
                    CompassDirection.W);
        }
        assert nextPosition != null;
        if (!this.plateau.onPlateau(nextPosition)){
            throw new NotDrivableLocationException();
        }
        this.setPosition(nextPosition);
    }

    public void rotate(Instruction instruction){
        int newDirectionNumber = (directionToModulus.apply(this.getFacing.get()) + instructionToNumber.apply(instruction)) % 4;

        CompassDirection newDirection = directionToModulusInverse.apply(newDirectionNumber);
        this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY(), newDirection));
    }

    public void followInstructions(Instruction[] instructions) {
        try {
            for (int i = 0; i < instructions.length; i++) {
                if(instructions[i] == Instruction.M){
                    this.drive();
                } else {
                    this.rotate(instructions[i]);
                }
            }
        } catch (NotDrivableLocationException e){
            System.out.printf("EMERGENCY STOP ROVER LOCATION X-coord: %d Y-Coord %d", this.getPosition().getX(), this.getPosition().getY());
        }
    }

    Supplier<CompassDirection> getFacing = () -> this.getPosition().getFacing();
}
