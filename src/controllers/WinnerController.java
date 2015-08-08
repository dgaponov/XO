package controllers;

import xo.Field;
import xo.Figure;
import xo.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Даниил on 08.08.2015.
 */
public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for(int i = 0; i < 3; ++i) {
                if (check(field, new Point(0, i), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(0, i));

                if (check(field, new Point(i, 0), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(i, 0));
            }

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(2, 0), p -> new Point(p.x - 1, p.y + 1)))
                return field.getFigure(new Point(2, 0));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch(InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        public Point next(final Point point);

    }


}
