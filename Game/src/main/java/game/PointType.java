package game;

public enum PointType {
    EMPTY(0), ENEMY(1), PLAYER(2), WALL(3), EXIT(4), WAY(5);
    private final int val;

    PointType(int i) {
        val = i;
    }

    public int getValue() {
        return val;
    }

    public static PointType getTypeForVal(int val) {
        PointType[] gets = PointType.values();
        for (PointType get : gets) {
            if (get.getValue() == val) {
                return get;
            }
        }
        return null;
    }


//    private static char PLAYER = 'P';
//    private static char EMPTY = '.';
//    private static char ENEMY = 'X';
//    private static char GOAL = '!';
//    private static char WALL = 'W';
//    private static char EXIT = 'O';
//
//    public static char getPLAYER() {
//        return PLAYER;
//    }
//
//    public static char getEMPTY() {
//        return EMPTY;
//    }
//
//    public static char getENEMY() {
//        return ENEMY;
//    }
//
//    public static char getGOAL() {
//        return GOAL;
//    }
//
//    public static char getWALL() {
//        return WALL;
//    }
//
//    public static char getEXIT() {
//        return EXIT;
//    }
}
