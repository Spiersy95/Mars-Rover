package Logic;

import InputParsers.PlateauSize;
import InputParsers.Position;

public class Plateau implements Surface {

    private PlateauSize plateauSize;

    public Plateau(PlateauSize plateauSize){
        this.plateauSize = plateauSize;
    }

    public boolean onSurface(Position position){
        if (position.getX() < 0|| position.getY() < 0){
            return false;
        }
        return position.getX() <= this.plateauSize.width() && position.getY() <= this.plateauSize.length();
    }
}
