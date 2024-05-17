package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;
import InputParsers.Position;

import java.util.function.Function;
import java.util.function.Supplier;

import static Logic.UtilityFuntions.*;


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

    Supplier<CompassDirection> getFacing = () -> this.getPosition().getFacing();
}
