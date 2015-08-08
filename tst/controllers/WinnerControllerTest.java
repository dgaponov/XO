package controllers;

import org.junit.Test;
import xo.Field;
import xo.Figure;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Даниил on 08.08.2015.
 */
public class WinnerControllerTest {

    @Test
    public void testGetWinnerOnHorizontal() throws Exception {
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(i, 0), inputFigure);
            field.setFigure(new Point(i, 1), inputFigure);
            field.setFigure(new Point(i, 2), inputFigure);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
    }

    @Test
    public void testGetWinnerOnVertical() throws Exception {
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(0, i), inputFigure);
            field.setFigure(new Point(1, i), inputFigure);
            field.setFigure(new Point(2, i), inputFigure);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
    }

    @Test
    public void testGetWinnerOnDiagonalOne() throws Exception {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(0, 0), inputFigure);
            field.setFigure(new Point(1, 1), inputFigure);
            field.setFigure(new Point(2, 2), inputFigure);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetWinnerOnDiagonalTwo() throws Exception {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(2, 0), inputFigure);
            field.setFigure(new Point(1, 1), inputFigure);
            field.setFigure(new Point(0, 2), inputFigure);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetWinnerWhenNoWinnerHorizontal() throws Exception {
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(i, 0), inputFigure);
            field.setFigure(new Point(i, 1), inputFigure);
            field.setFigure(new Point(i, 2), Figure.X);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertNull(actualFigure);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerVertical() throws Exception {
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);
            final Figure inputFigure = Figure.O;

            field.setFigure(new Point(0, i), inputFigure);
            field.setFigure(new Point(1, i), inputFigure);
            field.setFigure(new Point(2, i), Figure.X);

            WinnerController winnerController = new WinnerController();
            final Figure actualFigure = winnerController.getWinner(field);

            assertNull(actualFigure);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerOnDiagonalOne() throws Exception {
        final Field field = new Field(3);
        final Figure inputFigure = Figure.O;

        field.setFigure(new Point(0, 0), inputFigure);
        field.setFigure(new Point(1, 1), inputFigure);
        field.setFigure(new Point(2, 2), Figure.X);

        WinnerController winnerController = new WinnerController();
        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    public void testGetWinnerWhenNoWinnerOnDiagonalTwo() throws Exception {
        final Field field = new Field(3);
        final Figure inputFigure = Figure.O;

        field.setFigure(new Point(2, 0), inputFigure);
        field.setFigure(new Point(1, 1), inputFigure);
        field.setFigure(new Point(0, 2), Figure.X);

        WinnerController winnerController = new WinnerController();
        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }


}