package controllers;

import model.Field;
import model.Figure;
import model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); ++i) {
            countFigure += countFiguresInTheRow(field, i);
        }

        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        } else {
            return Figure.O;
        }

    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for (int j = 0; j < field.getSize(); ++j) {
            try {
                if (field.getFigure(new Point(row, j)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
