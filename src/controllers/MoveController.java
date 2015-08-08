package controllers;

import xo.Field;
import xo.Figure;
import xo.exceptions.AlreadyOccupiedException;
import xo.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Даниил on 08.08.2015.
 */
public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                    AlreadyOccupiedException {
        if(field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }


}
