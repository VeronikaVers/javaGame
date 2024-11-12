package game;

public class Point {
    private int x;
    private int y;
    private PointType type;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = PointType.EMPTY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() { return y; }

    public void setY(int y) {
        this.y = y;
    }

    public PointType getType() { return this.type; }

    public void setType(PointType type) { this.type = type; }

}
