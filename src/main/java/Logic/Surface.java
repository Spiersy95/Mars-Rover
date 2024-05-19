package Logic;

import InputParsers.Position;

public interface Surface {

    boolean onSurface(Position position);

    boolean isVehicleOnSurface(Vehicle vehicle);

    void addVehicleToSurface(Vehicle vehicle);
}
