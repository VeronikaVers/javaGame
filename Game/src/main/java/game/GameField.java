package game;

import game.exeptions.IllegalParametersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static game.PointType.EMPTY;
import static game.PointType.WAY;

public class GameField {
    private final Point[][] gameField;
    private List<Point> availablePoints;
    private List<Enemy> enemyList;
//    private List<Wall> wallList;
    private Exit exit;
    private Player player;

    private final int sizeX;
    private final int sizeY;

    private int enemyCount;
    private int wallCount;
//    private static Random random = new Random();
//    private static int PlayerX;
//    private static int PlayerY;
//
//    public static int getPlayerX() {
//        return PlayerX;
//    }
//
//    public static int getPlayerY() {
//        return PlayerY;
//    }


    public GameField(int size, int enemyCount, int wallCount) {
        if (size <= 0 || enemyCount < 0 || wallCount < 0 || (size * size) < (enemyCount + wallCount + 2)) {
            throw new IllegalParametersException("Invalid input");
        }
        this.sizeX = size;
        this.sizeY = size;
        this.enemyCount = enemyCount;
        this.wallCount = wallCount;
        gameField = new Point[sizeY][sizeX];
        this.availablePoints = new ArrayList<>();
        this.enemyList = new ArrayList<>();
//        this.wallList = new ArrayList<>();
        initialize();
    }

    public void initialize(/*int enemiesCount, int wallsCount*/) {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {

                gameField[y][x] = new Point(x, y);
                availablePoints.add(gameField[y][x]);

            }
        }

        addObject(PointType.EXIT, 1);
        addObject(PointType.WALL, wallCount);
        addObject(PointType.PLAYER, 1);
        addObject(PointType.ENEMY, enemyCount);

//        while (!findWay()) {
//            generateMap();
//        }
        Painter p = new Painter();
        if (!findWay()) {
            p.paintField(this);
            System.out.println("ex" + exit.getX());
            System.exit(1);};




    }

    private void addObject(PointType type, int count) {
        for (int i = 1; i <= count; i++) {
            int index = (new Random()).nextInt(this.availablePoints.size());
            Point point = this.availablePoints.get(index);
            point.setType(type);

            if (type == PointType.ENEMY) {
                this.enemyList.add(new Enemy(point));
            } else if (type == PointType.EXIT) {
                this.exit = new Exit(point);
            } else if (type == PointType.PLAYER) {
                this.player = new Player(point);
            }

            this.availablePoints.remove(index);
        }

    }

//    private void addEnemy() {
//        for (int count = 1; count <= enemyCount; count++) {
//            int index = (new Random()).nextInt(this.availablePoints.size());
//            Point point = this.availablePoints.get(index);
//            point.setType(PointType.ENEMY);
//            this.enemyList.add(new Enemy(point));
//            this.availablePoints.remove(index);
//        }
//    }

    private boolean findWay() {
//        System.out.println("PPPP" + exit.getX());
        if(!checkAround(exit.getX(), exit.getY(), PointType.PLAYER)) {
            return true;
        }
        int x = player.getX();
        int y = player.getY();
//        Point index = availablePoints.get(gameField[y][x]);

        if (y + 1 < sizeY && gameField[y + 1][x].getType() == PointType.EMPTY)
            gameField[y + 1][x].setType(PointType.WAY);
        if (x + 1 < sizeX && gameField[y][x + 1].getType() == PointType.EMPTY)
            gameField[y][x + 1].setType(PointType.WAY);
        if (y - 1 >= 0 && gameField[y - 1][x].getType() == PointType.EMPTY)
            gameField[y - 1][x].setType(PointType.WAY);
        if (x - 1 >= 0 && gameField[y][x - 1].getType() == PointType.EMPTY)
            gameField[y][x - 1].setType(PointType.WAY);
        
        int c = 0;
        while (check() > c) {
            c = check();
            searchValid();
            if (!checkAround(exit.getX(), exit.getY(), PointType.WAY))
                return true;
        }
        return false;
    }

    private boolean checkAround(int y, int x, PointType check) {
        
        if (y - 1 >= 0 && gameField[y-1][x].getType() == check) {
            return false;
        } else if (x - 1 >= 0 && gameField[y][x - 1].getType() == check) {
            return false;
        } else if (y + 1 < sizeX && gameField[y + 1][x].getType() == check) {
            return false;
        } else if (x + 1 < sizeY && gameField[y][x + 1].getType() == check) {
            return false;
        }
        return true;
    }

    private int check(){
        int c = 0;
        for(int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                if (gameField[i][j].getType() == WAY)
                    c++;
            }
        }
        System.out.println("cccc" + c);
        return c;
    }

    private void searchValid() {
        for (int y = 0; y < sizeX; y++){
            for (int x = 0; x < sizeY; x++){
                if(y + 1 < sizeY && gameField[y + 1][x].getType() == WAY &&  gameField[y][x].getType() == EMPTY)
                    gameField[y][x].setType(WAY);
                if(x + 1 < sizeX && gameField[y][x + 1].getType() == WAY &&  gameField[y][x].getType() == EMPTY)
                    gameField[y][x].setType(WAY);
                if(y - 1 > 0 && gameField[y - 1][x].getType() == WAY &&  gameField[y][x].getType() == EMPTY)
                    gameField[y][x].setType(WAY);
                if(x - 1 > 0 && gameField[y][x - 1].getType() == WAY &&  gameField[y][x].getType() == EMPTY)
                    gameField[y][x].setType(WAY);
            }
        }
    }

    public Point getPoint(int x, int y) {
        return gameField[y][x];
//        return isValidPosition(x, y) ? GameEntitiesTypes.getTypeForVal(field[x][y]) : null;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private boolean isValidPosition(int x, int y) {
        return !(x < 0 || x >= sizeX || y < 0 || y >= sizeY);
    }
}
