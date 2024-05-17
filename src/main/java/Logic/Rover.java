package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;
import InputParsers.Position;

import java.util.function.Function;
import java.util.function.Predicate;

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
        if (getfacing.apply(this)== CompassDirection.N) {
                nextPosition = new Position(this.getPosition().getX(),
                        this.getPosition().getY()+1,
                        CompassDirection.N);
        }
        if (getfacing.apply(this) == CompassDirection.E){
            nextPosition = new Position(this.getPosition().getX()+1,
                    this.getPosition().getY(),
                    CompassDirection.E);
        }
        if (getfacing.apply(this) == CompassDirection.S) {
            nextPosition = new Position(this.getPosition().getX(),
                    this.getPosition().getY() - 1,
                    CompassDirection.S);
        }
        if (getfacing.apply(this) == CompassDirection.W) {
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

    Function<Rover, CompassDirection> getfacing = rover -> rover.getPosition().getFacing();
}
