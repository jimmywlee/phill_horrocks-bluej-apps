
/**
 * This class creates an instance of the Game
 * class and then calls on its run method.
 *
 * @author Phill Horrocks
 * @version 0.1
 */
public class Program
{
    private static Game game;

    /**
     * This class creates and runs an instance of the Game
     */
    public static void main()
    {
        game = new Game("Phill");
        game.play();
    }
}
