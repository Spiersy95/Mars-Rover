package Logic;

public class PositionLogger {

    private static PositionLogger instance;

    private PositionLogger(){
    }

    public static PositionLogger getInstance(){
        if (instance == null){
            instance = new PositionLogger();
        }
        return instance;
    }

    public void logLocation(Rover rover){
        System.out.println(rover.getPosition().getX() + " "
                + rover.getPosition().getY() + " "
                + rover.getPosition().getFacing());
    }
}
