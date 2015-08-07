package xo;

/**
 * Created by ������ on 07.08.2015.
 */
public class Player {

    private final String name;

    private final Figure figure;

    public Player(String name,
                  Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
