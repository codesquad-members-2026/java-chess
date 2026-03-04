package pieces;

import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void create_default() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
        assertEquals(Pawn.BLACK_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    public void create() {

        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}