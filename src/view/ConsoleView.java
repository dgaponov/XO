package view;

import controllers.CurrentMoveController;
import controllers.MoveController;
import controllers.WinnerController;
import model.Field;
import model.Figure;
import model.Game;
import model.exceptions.AlreadyOccupiedException;
import model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    private void printLine(final Field field, final int i) {
        for(int j = 0; j < field.getSize(); ++j) {
            if(j != 0) System.out.print("|");
                System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(j, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:\n", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid coordinate!");
            return askCoordinate(coordinateName);
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X"), askCoordinate("Y"));
    }

    public void show(final Game game) {
        System.out.format("Game game: %s\n", game.getName());
        final Field field = game.getField();
        for(int i = 0; i < field.getSize(); ++i) {
            if(i != 0) printSeparator();
            printLine(field, i);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(game.getField());
        if(winner != null) {
            System.out.format("Winner is: %s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(game.getField());
        if(currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }

}
