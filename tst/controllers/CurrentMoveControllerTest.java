package controllers;

import org.junit.Test;
import xo.Field;
import xo.Figure;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextIsO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNextIsX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < 3; ++i) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);

            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);

        for(int i = 0; i < 3; ++i) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
        }

        assertNull(currentMoveController.currentMove(field));
    }
}