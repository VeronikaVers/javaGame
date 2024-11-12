package game;

public class Player implements GameObject {
    private String signature;
    private Point point;


    public Player(Point point) {
        this.point = point;
//        point.setType(PointType.PLAYER);

    }
    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public PointType getType() {
        return this.point.getType();
    }


}
