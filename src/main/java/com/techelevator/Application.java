package com.techelevator;

import com.techelevator.view.Menu;

public class Application {

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        ProWrestlingSimulatorCLI cli = new ProWrestlingSimulatorCLI(menu);
        System.out.println();
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("⣿ * Pro Wrestling Simulator * ⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        cli.run();

    }

}
