package game;

public class Wall implements GameObject {
    private String signature;
    private Point point;

    public Wall(Point point) {
        this.point = point;
//        point.setType(PointType.WALL);

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
