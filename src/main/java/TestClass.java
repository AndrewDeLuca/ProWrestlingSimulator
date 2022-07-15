import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TestClass {

    public static class FighterONE {
        private String name = "Scott";
        private int stat = 74;

    }


    public static class FighterTWO {
        private String name = "Andrew";
        private int stat = 91;

    }

    public static class FighterTHREE {
        private String name = "Brian";
        private int stat = 86;

    }



    public static void main(String[] args) {
        FighterONE fighterONE = new FighterONE();
        FighterTWO fighterTWO = new FighterTWO();
        FighterTHREE fighterTHREE = new FighterTHREE();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Choose A Fighter: 1, 2, 3");
        int fighter = Integer.parseInt(scanner.nextLine());
        if (fighter == 1) {
             fighter = fighterONE.stat;
        } else if (fighter == 2) {
            fighter = fighterTWO.stat;
        } else if (fighter == 3) {
            fighter = fighterTHREE.stat;
        } else
            System.out.println("Fighter does not exist");

        System.out.println("Please Choose An Opponent: ONE, TWO, THREE");
        int opponent = Integer.parseInt(scanner.nextLine());
        if (opponent == 1) {
            opponent = fighterONE.stat;
        } else if (opponent == 2) {
            opponent = fighterTWO.stat;
        } else if (opponent == 3) {
            opponent = fighterTHREE.stat;
        } else
            System.out.println("Opponent does not exist");

        if (fighter > opponent) {
            System.out.println(fighter + " has won the fight");
        } else {
            System.out.println(opponent + " has won the fight");
        }

        }


    }


