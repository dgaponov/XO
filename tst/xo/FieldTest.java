package xo;

import org.junit.Test;
import xo.exceptions.AlreadyOccupiedException;
import xo.exceptions.InvalidPointException;

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

    @Test
    public void testSetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
     public void testSetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getFieldSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getFieldSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }

}