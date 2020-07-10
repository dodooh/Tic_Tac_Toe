package tictactoe;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        TicTacToe test = new TicTacToe();
        System.out.print(test);

        while (!test.isFinished()) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = Integer.parseInt(sc.next());
                int y = Integer.parseInt(sc.next());

                test.play_coor(3 - y, x - 1);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            System.out.print(test);

        }
        System.out.println(test.getStatusMessage());

    }

}
