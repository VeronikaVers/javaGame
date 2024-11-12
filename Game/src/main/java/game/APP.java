package game;

public class APP {
    public static void main(String[] args) {
        GameField gf = new GameField(8,  0, 30 );
//        gf.initialize();
        Painter p = new Painter();
        p.paintField(gf);
    }
}
