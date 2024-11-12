package game;

public class Enemy implements GameObject {
    private String signature;
    private Point point;

    public Enemy(Point point) {
        this.point = point;
//        point.setType(PointType.ENEMY);
    }

    public PointType getType() {
        return this.point.getType();
    }


}
