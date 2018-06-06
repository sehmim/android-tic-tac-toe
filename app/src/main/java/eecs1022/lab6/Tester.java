package eecs1022.lab6;

/**
 * Created by user on 2018-03-23.
 */

public class Tester {
    public static void main(String arg[]){
        Game game = new Game("Bob", "Tom");
        game.checkingWhoPlaysFirst("X");
        System.out.println();

        System.out.println(game.displayBoard());


        System.out.println(game.play(1,1));
        System.out.println(game.play(2,2));
        System.out.println(game.play(3,3));
        System.out.println(game.play(3,2));
        System.out.println(game.play(2,1));
        System.out.println(game.play(1,2));
        System.out.println(game.play(1,1));
        System.out.println(game.play(1,1));



    }
}
