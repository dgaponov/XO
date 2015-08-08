package xo;

import xo.exceptions.AlreadyOccupiedException;
import xo.exceptions.InvalidPointException;
import xo.exceptions.AlreadyOccupiedException;

import java.awt.*;

/**
 * Created by ������ on 07.08.2015.
 */
public class Field {

    public static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if(!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if(!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return (checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length));

    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return (coordinate >= MIN_COORDINATE && coordinate < maxCoordinate);
    }

}
