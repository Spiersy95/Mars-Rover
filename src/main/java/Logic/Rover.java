package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;
import InputParsers.Position;


import java.util.function.Function;
import java.util.function.Supplier;




public class Rover implements Vehicle {

    //private String name;
    private Position position;

    public Rover(Position position){
       // this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void drive(Surface surface) throws NotDrivableLocationException {
        if (!surface.isVehicleOnSurface(this)){
            throw new NotDrivableLocationException();
        }
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
        if (!surface.onSurface(nextPosition)){
            throw new NotDrivableLocationException();
        }
        this.setPosition(nextPosition);
    }

    public void rotate(Instruction instruction){
        int newDirectionNumber = (directionToModulus.apply(this.getFacing.get())
                + instructionToNumber.apply(instruction)) % 4;

        CompassDirection newDirection = directionToModulusInverse.apply(newDirectionNumber);
        this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY(), newDirection));
    }

    public void followInstructions(Instruction[] instructions, Surface surface) {
        try {
            for (int i = 0; i < instructions.length; i++) {
                if(instructions[i] == Instruction.M){
                    this.drive(surface);
                } else {
                    this.rotate(instructions[i]);
                }
            }
        } catch (NotDrivableLocationException e){
            System.out.println("\nEMERGENCY STOP!\n");

        }
    }

    Supplier<CompassDirection> getFacing = () -> this.getPosition().getFacing();

    static Function<CompassDirection, Integer> directionToModulus = direction -> switch (direction) {
        case CompassDirection.N -> 0;
        case CompassDirection.E -> 1;
        case CompassDirection.S -> 2;
        case CompassDirection.W -> 3;
    };

    static Function<Integer, CompassDirection> directionToModulusInverse = number -> switch (number) {
        case 0 -> CompassDirection.N ;
        case 1 -> CompassDirection.E;
        case 2 -> CompassDirection.S;
        case 3 -> CompassDirection.W;

        default -> throw new IllegalStateException("Unexpected value: " + number);
    };

    static Function<Instruction, Integer> instructionToNumber= direction -> switch (direction) {
        case Instruction.L -> 3;
        case Instruction.R -> 1;
        case Instruction.M -> 0;
    };
}
