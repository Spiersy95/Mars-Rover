package Logic;

import InputParsers.PlateauSize;
import InputParsers.Position;

public class Plateau {

    private PlateauSize plateauSize;

    public Plateau(PlateauSize plateauSize){
        this.plateauSize = plateauSize;
    }

    public boolean onPlateau(Position position){
        if (position.getX() < 0|| position.getY() < 0){
            return false;
        }
        return position.getX() <= this.plateauSize.width() && position.getY() <= this.plateauSize.length();
    }
}
