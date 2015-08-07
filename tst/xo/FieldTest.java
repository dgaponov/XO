package xo;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Даниил on 07.08.2015.
 */
public class FieldTest {

    @Test
    public void testGetFieldSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getFieldSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }
}