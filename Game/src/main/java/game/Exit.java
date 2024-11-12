package game;

public class Exit  implements GameObject{
    private String signature;
    private Point point;

    public Exit(Point point) {
        this.point = point;

//        point.setType(PointType.EXIT);

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
