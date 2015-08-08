import model.Field;
import model.Figure;
import model.Game;
import model.Player;
import view.ConsoleView;

public class CLI {

    public static void main(final String[] args) {
        final String name1 = "Danil";
        final String name2 = "Sergey";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }

    }

}
