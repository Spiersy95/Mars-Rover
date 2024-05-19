package Logic;

import InputParsers.PlateauSize;
import InputParsers.Position;

import java.util.ArrayList;

public class Plateau implements Surface {

    private PlateauSize plateauSize;
    private ArrayList<Vehicle> vehicleList;

    public Plateau(PlateauSize plateauSize, ArrayList<Vehicle> vehicleList){
        this.plateauSize = plateauSize;
        this.vehicleList = vehicleList;
    }

    public Plateau(PlateauSize plateauSize){
        this.plateauSize = plateauSize;
        this.vehicleList = new ArrayList<>();
    }

    public boolean onSurface(Position position){
        if (position.getX() < 0|| position.getY() < 0){
            return false;
        }
        return position.getX() <= this.plateauSize.width() && position.getY() <= this.plateauSize.length();
    }

    public boolean isVehicleOnSurface(Vehicle vehicle){
        return vehicleList.contains(vehicle);
    }

    public void addVehicleToSurface(Vehicle vehicle){
        this.vehicleList.add(vehicle);
    }
}
