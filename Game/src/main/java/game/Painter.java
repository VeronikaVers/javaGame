package game;

public class Painter {
    private Settings settings = new Settings();

    public void paintField(GameField gameField) {
        int sizeX = gameField.getSizeX();
        int sizeY = gameField.getSizeY();

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                //System.out.println("x=" + x + " y=" + y);

                switch (gameField.getPoint(x, y).getType()) {
                    case EXIT:
                        System.out.print(settings.getExitChar());
                        break;
                    case EMPTY:
                        System.out.print(settings.getEmptyChar());
                        break;
                    case PLAYER:
                        System.out.print(settings.getPlayerChar());
                        break;
                    case ENEMY:
                        System.out.print(settings.getEnemyChar());
                        break;
                    case WALL:
                        System.out.print(settings.getWallChar());
                        break;
                    case WAY:
                        System.out.print('*');
                        break;
                }
            }
            System.out.println();
        }

    }



}

