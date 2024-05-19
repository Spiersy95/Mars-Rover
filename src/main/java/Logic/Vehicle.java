package Logic;

import InputParsers.Position;

public interface Vehicle {


    void drive(Surface surface) throws NotDrivableLocationException;
}
