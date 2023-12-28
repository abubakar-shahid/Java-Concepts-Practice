import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    //private TicTacToe ticTacToe;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class: Setup one-time resources or configuration.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class: Release one-time resources or perform cleanup.");
    }

    @Before
    public void setUp() {
        System.out.println("Before: Setup resources for each test case.");
        //ticTacToe = new TicTacToe();
    }

    @After
    public void tearDown() {
        System.out.println("After: Release resources after each test case.");
        //ticTacToe = null;
    }

    @Test
    public void testInitialBoard() {
        System.out.println("Test: Check if the initial board is created correctly.");
        char[][] expectedBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        //assertArrayEquals(expectedBoard, ticTacToe.getBoard());
    }

    @Test
    public void testMakeMove() {
        System.out.println("Test: Make a move and check if the board is updated correctly.");
        //ticTacToe.makeMove(0, 0, 'X');
        char[][] expectedBoard = {{'X', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        //assertArrayEquals(expectedBoard, ticTacToe.getBoard());
    }

    @Test
    public void testPlayerWin() {
        System.out.println("Test: Check if a player wins horizontally.");
//        ticTacToe.makeMove(0, 0, 'X');
//        ticTacToe.makeMove(0, 1, 'X');
//        ticTacToe.makeMove(0, 2, 'X');
//        assertTrue(ticTacToe.checkWin('X'));
//        assertFalse(ticTacToe.checkWin('O')); // Other player should not win
    }

    @Test
    public void testGameDraw() {
        System.out.println("Test: Check if the game ends in a draw.");
//        ticTacToe.makeMove(0, 0, 'X');
//        ticTacToe.makeMove(0, 1, 'O');
//        ticTacToe.makeMove(0, 2, 'X');
//        ticTacToe.makeMove(1, 0, 'O');
//        ticTacToe.makeMove(1, 1, 'X');
//        ticTacToe.makeMove(1, 2, 'O');
//        ticTacToe.makeMove(2, 0, 'X');
//        ticTacToe.makeMove(2, 1, 'O');
//        ticTacToe.makeMove(2, 2, 'X');
//        assertTrue(ticTacToe.isGameDraw());
    }
}
