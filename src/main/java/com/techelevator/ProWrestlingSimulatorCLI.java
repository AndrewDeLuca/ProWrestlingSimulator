package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;



public class ProWrestlingSimulatorCLI {

    private static final String MAIN_MENU_DISPLAY_WRESTLER_ROSTER = "Display Wrestler Roster";
    private static final String MAIN_MENU_BOOK_A_FIGHT = "Book A Fight";
    private static final String MAIN_MENU_BOOK_A_TAG_TEAM = "Book A Tag Team Fight";
    private static final String MAIN_MENU_BOOK_A_TOURNAMENT = "Book A Tournament";
    private static final String MAIN_MENU_BOOK_A_SHOW = "Book A Show";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_DISPLAY_WRESTLER_ROSTER, MAIN_MENU_BOOK_A_FIGHT, MAIN_MENU_BOOK_A_TAG_TEAM, MAIN_MENU_BOOK_A_TOURNAMENT, MAIN_MENU_BOOK_A_SHOW, MAIN_MENU_OPTION_EXIT};

    private final Menu menu;

    private static final String BOOK_MENU_CHOOSE_YOUR_WRESTLER = "Three Match Show";
    private static final String BOOK_MENU_CHOOSE_YOUR_OPPONENT = "Five Match Show";
    private static final String BOOK_MENU_FIGHT = "Eight Match Show";
    private static final String BOOK_MENU_MAIN_MENU = "Main Menu";
    private static final String[] PURCHASE_MENU_OPTIONS = {BOOK_MENU_CHOOSE_YOUR_WRESTLER, BOOK_MENU_CHOOSE_YOUR_OPPONENT, BOOK_MENU_FIGHT, BOOK_MENU_MAIN_MENU};

    private static final String BOOK_SINGLES = "Singles Match";
    private static final String BOOK_TEAMS = "Tag Team Match";
    private static final String[] MATCH_MENU_OPTIONS = {BOOK_SINGLES, BOOK_TEAMS};



    public ProWrestlingSimulatorCLI(Menu menu) {
        this.menu = menu;
        roster.rosterOptions();
    }

    Roster roster = new Roster();

    public void run() {

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            switch (choice) {
                case MAIN_MENU_DISPLAY_WRESTLER_ROSTER:
                    displayRosterTHREE();
                    break;
                case MAIN_MENU_BOOK_A_FIGHT:
                    bookAFight();
                    break;
                case MAIN_MENU_BOOK_A_TAG_TEAM:
                    bookATagTeam();
                    break;
                case MAIN_MENU_BOOK_A_TOURNAMENT:
                    bookATournament();
                    break;
                case MAIN_MENU_BOOK_A_SHOW:
                    bookAShow();
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    System.exit(0);
            }

        }

    }

    public void displayRosterONE() {
        System.out.println();
        for (String key : roster.getRosterList().keySet()) {
            System.out.print(key + " |");
            System.out.print(" " + roster.getRosterList().get(key).getName() + " |");
            System.out.print(" " + roster.getRosterList().get(key).getHometown() + " |" + "\n");

        }

    }

    public void displayRosterTWO() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("View Wrestler Statistics: 1 - 10");
            String viewFighter = scanner.nextLine();
            System.out.println();

            if (roster.getRosterList().containsKey(viewFighter)) {
                System.out.print("Name: " + roster.getRosterList().get(viewFighter).getName() + "\n");
                System.out.print("Hometown: " + roster.getRosterList().get(viewFighter).getHometown() + "\n");
                System.out.print("Height: " + roster.getRosterList().get(viewFighter).getHeight() + "\n");
                System.out.print("Weight: " + roster.getRosterList().get(viewFighter).getWeight() + "\n");
                System.out.print("Strength: " + roster.getRosterList().get(viewFighter).getStrength() + "\n");
                System.out.print("Speed: " + roster.getRosterList().get(viewFighter).getSpeed() + "\n");
                System.out.print("Skill: " + roster.getRosterList().get(viewFighter).getSkill() + "\n");
                System.out.print("Charisma: " + roster.getRosterList().get(viewFighter).getCharisma() + "\n");
                System.out.println();


            } else {
                System.out.println("Sorry, that is not a correct option.");

            }

            System.out.println("View Another Wrestlers Statistics?: Y or N");
            String viewAnother = scanner.nextLine();
            System.out.println();

            if (viewAnother.contains("Y")) {
                displayRosterTWO();
            } else {
                run();
            }

        }

    }

    public void displayRosterTHREE() {
        System.out.println();
        displayRosterONE();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("View Individual Wrestler Statistics: Y or N");
        String rosterTWO = scanner.nextLine();

        if (rosterTWO.contains("Y")) {
            displayRosterTWO();
        } else {
            run();
        }
    }


    public void bookAFight() {
        while (true) {
            displayRosterONE();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose your Wrestler: 1 - 10");
            String fighterONE = scanner.nextLine();

            if (roster.getRosterList().containsKey(fighterONE)) {
                System.out.println("You have chosen " + roster.getRosterList().get(fighterONE).getName());
                System.out.println();
                System.out.println("Please choose your Opponent: 1 - 10");
                String fighterTWO = scanner.nextLine();

                if (roster.getRosterList().containsKey(fighterTWO)) {
                    System.out.println("You have chosen " + roster.getRosterList().get(fighterTWO).getName() + " as your opponent.");
                    System.out.println();
                    System.out.println("* " + roster.getRosterList().get(fighterONE).getName() + " vs " + roster.getRosterList().get(fighterTWO).getName() + " *");
                    System.out.println("Ladies and gentlemen, introducing first, fighting out of " + roster.getRosterList().get(fighterONE).getHometown() + ", standing at " + roster.getRosterList().get(fighterONE).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterONE).getWeight() + " " + roster.getRosterList().get(fighterONE).getName() + "!");
                    System.out.println("And his opponent, fighting out of " + roster.getRosterList().get(fighterTWO).getHometown() + ", standing at " + roster.getRosterList().get(fighterTWO).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterTWO).getWeight() + " " + roster.getRosterList().get(fighterTWO).getName() + "!");
                    System.out.println();
                    if (roster.getRosterList().get(fighterONE).getFightStat() > roster.getRosterList().get(fighterTWO).getFightStat()) {
                        System.out.println(roster.getRosterList().get(fighterONE).getName() + " has won the fight!");
                        System.out.println(roster.getRosterList().get(fighterONE).getName() + roster.getRosterList().get(fighterONE).winFight());
                        System.out.println(roster.getRosterList().get(fighterTWO).getName() + roster.getRosterList().get(fighterTWO).loseFight());
                    } else {
                        System.out.println(roster.getRosterList().get(fighterTWO).getName() + " has won the fight!");
                        System.out.println(roster.getRosterList().get(fighterTWO).getName() + roster.getRosterList().get(fighterTWO).winFight());
                        System.out.println(roster.getRosterList().get(fighterONE).getName() + roster.getRosterList().get(fighterONE).loseFight());
                    }
                }

            } else {
                System.out.println("Sorry, that is not a correct option.");
            }
            return;
        }

    }

    public void bookATagTeam() {
        while (true) {
            displayRosterONE();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose your first Wrestler: 1 - 10");
            String partnerONE = scanner.nextLine();

            if (roster.getRosterList().containsKey(partnerONE)) {
                System.out.println("You have chosen " + roster.getRosterList().get(partnerONE).getName());
                System.out.println();
                System.out.println("Please choose his Tag Team partner: 1 - 10");
                String partnerTWO = scanner.nextLine();

                if (roster.getRosterList().containsKey(partnerTWO)) {
                    System.out.println("You have chosen " + roster.getRosterList().get(partnerTWO).getName() + " & " + roster.getRosterList().get(partnerONE).getName() + " as your Tag Team.");
                    System.out.println();

                    System.out.println("Please choose your first Opponent: 1 - 10");
                    String partnerTHREE = scanner.nextLine();

                    if (roster.getRosterList().containsKey(partnerONE)) {
                        System.out.println("You have chosen " + roster.getRosterList().get(partnerTHREE).getName());
                        System.out.println();
                        System.out.println("Please choose his Tag Team partner: 1 - 10");
                        String partnerFOUR = scanner.nextLine();

                        if (roster.getRosterList().containsKey(partnerTWO)) {
                            System.out.println("You have chosen " + roster.getRosterList().get(partnerFOUR).getName() + " & " + roster.getRosterList().get(partnerTHREE).getName() + " as their opponents.");
                            System.out.println();
                            System.out.println("* " + roster.getRosterList().get(partnerTWO).getName() + " & " + roster.getRosterList().get(partnerONE).getName() + " vs " + roster.getRosterList().get(partnerFOUR).getName() + " & " + roster.getRosterList().get(partnerTHREE).getName() + " *");
                            System.out.println("Ladies and gentlemen, introducing first, weighing in at a combine weight of " + (roster.getRosterList().get(partnerONE).getWeight() + roster.getRosterList().get(partnerTWO).getWeight()) + ", the Tag Team of, " + roster.getRosterList().get(partnerTWO).getName() + " & " + roster.getRosterList().get(partnerONE).getName() + "!");
                            System.out.println("And their opponents, weighing in at a combine weight of " + (roster.getRosterList().get(partnerTHREE).getWeight() + roster.getRosterList().get(partnerFOUR).getWeight()) + ", the Tag Team of, " + roster.getRosterList().get(partnerFOUR).getName() + " & " + roster.getRosterList().get(partnerTHREE).getName() + "!");
                            System.out.println();
                            if ((roster.getRosterList().get(partnerONE).getFightStat() + roster.getRosterList().get(partnerTWO).getFightStat()) > (roster.getRosterList().get(partnerTHREE).getFightStat() + roster.getRosterList().get(partnerONE).getFightStat())) {
                                System.out.println("The Tag Team of " + roster.getRosterList().get(partnerTWO).getName() + " & " + roster.getRosterList().get(partnerONE).getName() + " have won the fight!");
                                System.out.println(roster.getRosterList().get(partnerTWO).getName() + roster.getRosterList().get(partnerTWO).winFight());
                                System.out.println(roster.getRosterList().get(partnerONE).getName() + roster.getRosterList().get(partnerONE).winFight());
                                System.out.println(roster.getRosterList().get(partnerFOUR).getName() + roster.getRosterList().get(partnerFOUR).loseFight());
                                System.out.println(roster.getRosterList().get(partnerTHREE).getName() + roster.getRosterList().get(partnerTHREE).loseFight());
                            } else {
                                System.out.println("The Tag Team of " + roster.getRosterList().get(partnerFOUR).getName() + " & " + roster.getRosterList().get(partnerTHREE).getName() + " have won the fight!");
                                System.out.println(roster.getRosterList().get(partnerTHREE).getName() + roster.getRosterList().get(partnerTHREE).winFight());
                                System.out.println(roster.getRosterList().get(partnerFOUR).getName() + roster.getRosterList().get(partnerFOUR).winFight());
                                System.out.println(roster.getRosterList().get(partnerTWO).getName() + roster.getRosterList().get(partnerTWO).loseFight());
                                System.out.println(roster.getRosterList().get(partnerONE).getName() + roster.getRosterList().get(partnerONE).loseFight());
                            }
                        }
                    }
                }

            } else {
                System.out.println("Sorry, that is not a correct option.");
            }
            return;
        }
    }

    public void bookATournament() {
        String winnerONEName;
        String winnerONEHomeTown;
        double winnerONEHeight;
        double winnerONEWeight;
        double winnerONEStats;
        Fighters winnerONEFightStat = new Fighters();
        String winnerTWOName;
        String winnerTWOHomeTown;
        double winnerTWOHeight;
        double winnerTWOWeight;
        double winnerTWOStats;
        Fighters winnerTWOFightStat = new Fighters();
        String winnerTHREEName;
        String winnerTHREEHomeTown;
        double winnerTHREEHeight;
        double winnerTHREEWeight;
        double winnerTHREEStats;
        Fighters winnerTHREEFightStat = new Fighters();
        String winnerFOURName;
        String winnerFOURHomeTown;
        double winnerFOURHeight;
        double winnerFOURWeight;
        double winnerFOURStats;
        Fighters winnerFOURFightStat = new Fighters();
        String winnerFIVEName;
        String winnerFIVEHomeTown;
        double winnerFIVEHeight;
        double winnerFIVEWeight;
        double winnerFIVEStats;
        Fighters winnerFIVEFightStat = new Fighters();
        String winnerSIXName;
        String winnerSIXHomeTown;
        double winnerSIXHeight;
        double winnerSIXWeight;
        double winnerSIXStats;
        Fighters winnerSIXFightStat = new Fighters();


        System.out.println();
        displayRosterONE();
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book Match #1");
        System.out.println("Please choose your Wrestler: 1 - 10");
        String fighterONE = scanner.nextLine();

        if (roster.getRosterList().containsKey(fighterONE)) {
            System.out.println("You have chosen " + roster.getRosterList().get(fighterONE).getName());
            System.out.println();
            System.out.println("Please choose your Opponent: 1 - 10");
            String fighterTWO = scanner.nextLine();

            if (roster.getRosterList().containsKey(fighterTWO)) {
                System.out.println("You have chosen " + roster.getRosterList().get(fighterTWO).getName() + " as your opponent.");

            }
            System.out.println();
            System.out.println("Book Match #2");
            System.out.println("Please choose your Wrestler: 1 - 10");
            String fighterTHREE = scanner.nextLine();

            if (roster.getRosterList().containsKey(fighterTHREE)) {
                System.out.println("You have chosen " + roster.getRosterList().get(fighterTHREE).getName());
                System.out.println();
                System.out.println("Please choose your Opponent: 1 - 10");
                String fighterFOUR = scanner.nextLine();

                if (roster.getRosterList().containsKey(fighterFOUR)) {
                    System.out.println("You have chosen " + roster.getRosterList().get(fighterFOUR).getName() + " as your opponent.");

                }
                System.out.println();
                System.out.println("Book Match #3");
                System.out.println("Please choose your Wrestler: 1 - 10");
                String fighterFIVE = scanner.nextLine();

                if (roster.getRosterList().containsKey(fighterFIVE)) {
                    System.out.println("You have chosen " + roster.getRosterList().get(fighterFIVE).getName());
                    System.out.println();
                    System.out.println("Please choose your Opponent: 1 - 10");
                    String fighterSIX = scanner.nextLine();

                    if (roster.getRosterList().containsKey(fighterSIX)) {
                        System.out.println("You have chosen " + roster.getRosterList().get(fighterSIX).getName() + " as your opponent.");

                    }
                    System.out.println();
                    System.out.println("Book Match #4");
                    System.out.println("Please choose your Wrestler: 1 - 10");
                    String fighterSEVEN = scanner.nextLine();

                    if (roster.getRosterList().containsKey(fighterSEVEN)) {
                        System.out.println("You have chosen " + roster.getRosterList().get(fighterSEVEN).getName());
                        System.out.println();
                        System.out.println("Please choose your Opponent: 1 - 10");
                        String fighterEIGHT = scanner.nextLine();

                        if (roster.getRosterList().containsKey(fighterEIGHT)) {
                            System.out.println("You have chosen " + roster.getRosterList().get(fighterEIGHT).getName() + " as your opponent.");

                        }
                        System.out.println();
                        System.out.println("* Match 1: " + roster.getRosterList().get(fighterONE).getName() + " vs " + roster.getRosterList().get(fighterTWO).getName() + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + roster.getRosterList().get(fighterONE).getHometown() + ", standing at " + roster.getRosterList().get(fighterONE).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterONE).getWeight() + " " + roster.getRosterList().get(fighterONE).getName() + "!");
                        System.out.println("And his opponent, fighting out of " + roster.getRosterList().get(fighterTWO).getHometown() + ", standing at " + roster.getRosterList().get(fighterTWO).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterTWO).getWeight() + " " + roster.getRosterList().get(fighterTWO).getName() + "!");
                        System.out.println();
                        if (roster.getRosterList().get(fighterONE).getFightStat() > roster.getRosterList().get(fighterTWO).getFightStat()) {
                            System.out.println(roster.getRosterList().get(fighterONE).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterONE).getName() + roster.getRosterList().get(fighterONE).winFight());
                            System.out.println(roster.getRosterList().get(fighterTWO).getName() + roster.getRosterList().get(fighterTWO).loseFight());
                            winnerONEName = roster.getRosterList().get(fighterONE).getName();
                            winnerONEStats = roster.getRosterList().get(fighterONE).getFightStat();
                            winnerONEHomeTown = roster.getRosterList().get(fighterONE).getHometown();
                            winnerONEHeight = roster.getRosterList().get(fighterONE).getHeight();
                            winnerONEWeight = roster.getRosterList().get(fighterONE).getWeight();
                            winnerONEFightStat = (Fighters) roster.getRosterList().get(fighterONE);
                            System.out.println();
                        } else {
                            System.out.println(roster.getRosterList().get(fighterTWO).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterTWO).getName() + roster.getRosterList().get(fighterTWO).winFight());
                            System.out.println(roster.getRosterList().get(fighterONE).getName() + roster.getRosterList().get(fighterONE).loseFight());
                            winnerONEName = roster.getRosterList().get(fighterTWO).getName();
                            winnerONEStats = roster.getRosterList().get(fighterTWO).getFightStat();
                            winnerONEHomeTown = roster.getRosterList().get(fighterTWO).getHometown();
                            winnerONEHeight = roster.getRosterList().get(fighterTWO).getHeight();
                            winnerONEWeight = roster.getRosterList().get(fighterTWO).getWeight();
                            winnerONEFightStat = (Fighters) roster.getRosterList().get(fighterTWO);
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("* Match 2: " + roster.getRosterList().get(fighterTHREE).getName() + " vs " + roster.getRosterList().get(fighterFOUR).getName() + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + roster.getRosterList().get(fighterTHREE).getHometown() + ", standing at " + roster.getRosterList().get(fighterTHREE).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterTHREE).getWeight() + " " + roster.getRosterList().get(fighterTHREE).getName() + "!");
                        System.out.println("And his opponent, fighting out of " + roster.getRosterList().get(fighterFOUR).getHometown() + ", standing at " + roster.getRosterList().get(fighterFOUR).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterFOUR).getWeight() + " " + roster.getRosterList().get(fighterFOUR).getName() + "!");
                        System.out.println();
                        if (roster.getRosterList().get(fighterTHREE).getFightStat() > roster.getRosterList().get(fighterFOUR).getFightStat()) {
                            System.out.println(roster.getRosterList().get(fighterTHREE).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterTHREE).getName() + roster.getRosterList().get(fighterTHREE).winFight());
                            System.out.println(roster.getRosterList().get(fighterFOUR).getName() + roster.getRosterList().get(fighterFOUR).loseFight());
                            winnerTWOName = roster.getRosterList().get(fighterTHREE).getName();
                            winnerTWOStats = roster.getRosterList().get(fighterTHREE).getFightStat();
                            winnerTWOHomeTown = roster.getRosterList().get(fighterTHREE).getHometown();
                            winnerTWOHeight = roster.getRosterList().get(fighterTHREE).getHeight();
                            winnerTWOWeight = roster.getRosterList().get(fighterTHREE).getWeight();
                            winnerTWOFightStat = (Fighters) roster.getRosterList().get(fighterTHREE);
                            System.out.println();
                        } else {
                            System.out.println(roster.getRosterList().get(fighterFOUR).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterFOUR).getName() + roster.getRosterList().get(fighterFOUR).winFight());
                            System.out.println(roster.getRosterList().get(fighterTHREE).getName() + roster.getRosterList().get(fighterTHREE).loseFight());
                            winnerTWOName = roster.getRosterList().get(fighterFOUR).getName();
                            winnerTWOStats = roster.getRosterList().get(fighterFOUR).getFightStat();
                            winnerTWOHomeTown = roster.getRosterList().get(fighterFOUR).getHometown();
                            winnerTWOHeight = roster.getRosterList().get(fighterFOUR).getHeight();
                            winnerTWOWeight = roster.getRosterList().get(fighterFOUR).getWeight();
                            winnerTWOFightStat = (Fighters) roster.getRosterList().get(fighterFOUR);
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("* Match 3: " + roster.getRosterList().get(fighterFIVE).getName() + " vs " + roster.getRosterList().get(fighterSIX).getName() + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + roster.getRosterList().get(fighterFIVE).getHometown() + ", standing at " + roster.getRosterList().get(fighterFIVE).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterFIVE).getWeight() + " " + roster.getRosterList().get(fighterFIVE).getName() + "!");
                        System.out.println("And his opponent, fighting out of " + roster.getRosterList().get(fighterSIX).getHometown() + ", standing at " + roster.getRosterList().get(fighterSIX).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterSIX).getWeight() + " " + roster.getRosterList().get(fighterSIX).getName() + "!");
                        System.out.println();
                        if (roster.getRosterList().get(fighterFIVE).getFightStat() > roster.getRosterList().get(fighterSIX).getFightStat()) {
                            System.out.println(roster.getRosterList().get(fighterFIVE).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterFIVE).getName() + roster.getRosterList().get(fighterFIVE).winFight());
                            System.out.println(roster.getRosterList().get(fighterSIX).getName() + roster.getRosterList().get(fighterSIX).loseFight());
                            winnerTHREEName = roster.getRosterList().get(fighterFIVE).getName();
                            winnerTHREEStats = roster.getRosterList().get(fighterFIVE).getFightStat();
                            winnerTHREEHomeTown = roster.getRosterList().get(fighterFIVE).getHometown();
                            winnerTHREEHeight = roster.getRosterList().get(fighterFIVE).getHeight();
                            winnerTHREEWeight = roster.getRosterList().get(fighterFIVE).getWeight();
                            winnerTHREEFightStat = (Fighters) roster.getRosterList().get(fighterFIVE);
                            System.out.println();
                        } else {
                            System.out.println(roster.getRosterList().get(fighterSIX).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterSIX).getName() + roster.getRosterList().get(fighterSIX).winFight());
                            System.out.println(roster.getRosterList().get(fighterFIVE).getName() + roster.getRosterList().get(fighterFIVE).loseFight());
                            winnerTHREEName = roster.getRosterList().get(fighterSIX).getName();
                            winnerTHREEStats = roster.getRosterList().get(fighterSIX).getFightStat();
                            winnerTHREEHomeTown = roster.getRosterList().get(fighterSIX).getHometown();
                            winnerTHREEHeight = roster.getRosterList().get(fighterSIX).getHeight();
                            winnerTHREEWeight = roster.getRosterList().get(fighterSIX).getWeight();
                            winnerTHREEFightStat = (Fighters) roster.getRosterList().get(fighterSIX);
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("* Match 4: " + roster.getRosterList().get(fighterSEVEN).getName() + " vs " + roster.getRosterList().get(fighterEIGHT).getName() + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + roster.getRosterList().get(fighterSEVEN).getHometown() + ", standing at " + roster.getRosterList().get(fighterSEVEN).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterSEVEN).getWeight() + " " + roster.getRosterList().get(fighterSEVEN).getName() + "!");
                        System.out.println("And his opponent, fighting out of " + roster.getRosterList().get(fighterEIGHT).getHometown() + ", standing at " + roster.getRosterList().get(fighterEIGHT).getHeight() + ", and weighing in at " + roster.getRosterList().get(fighterEIGHT).getWeight() + " " + roster.getRosterList().get(fighterEIGHT).getName() + "!");
                        System.out.println();
                        if (roster.getRosterList().get(fighterSEVEN).getFightStat() > roster.getRosterList().get(fighterEIGHT).getFightStat()) {
                            System.out.println(roster.getRosterList().get(fighterSEVEN).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterSEVEN).getName() + roster.getRosterList().get(fighterSEVEN).winFight());
                            System.out.println(roster.getRosterList().get(fighterEIGHT).getName() + roster.getRosterList().get(fighterEIGHT).loseFight());
                            winnerFOURName = roster.getRosterList().get(fighterSEVEN).getName();
                            winnerFOURStats = roster.getRosterList().get(fighterSEVEN).getFightStat();
                            winnerFOURHomeTown = roster.getRosterList().get(fighterSEVEN).getHometown();
                            winnerFOURHeight = roster.getRosterList().get(fighterSEVEN).getHeight();
                            winnerFOURWeight = roster.getRosterList().get(fighterSEVEN).getWeight();
                            winnerFOURFightStat = (Fighters) roster.getRosterList().get(fighterSEVEN);
                            System.out.println();
                        } else {
                            System.out.println(roster.getRosterList().get(fighterEIGHT).getName() + " has won the fight!");
                            System.out.println(roster.getRosterList().get(fighterEIGHT).getName() + roster.getRosterList().get(fighterEIGHT).winFight());
                            System.out.println(roster.getRosterList().get(fighterSEVEN).getName() + roster.getRosterList().get(fighterSEVEN).loseFight());
                            winnerFOURName = roster.getRosterList().get(fighterEIGHT).getName();
                            winnerFOURStats = roster.getRosterList().get(fighterEIGHT).getFightStat();
                            winnerFOURHomeTown = roster.getRosterList().get(fighterEIGHT).getHometown();
                            winnerFOURHeight = roster.getRosterList().get(fighterEIGHT).getHeight();
                            winnerFOURWeight = roster.getRosterList().get(fighterEIGHT).getWeight();
                            winnerFOURFightStat = (Fighters) roster.getRosterList().get(fighterEIGHT);
                            System.out.println();
                        }
                        System.out.println("* Match 5: " + winnerONEName + " vs " + winnerTWOName + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + winnerONEHomeTown + ", standing at " + winnerONEHeight + ", and weighing in at " + winnerONEWeight + " " + winnerONEName + "!");
                        System.out.println("And his opponent, fighting out of " + winnerTWOHomeTown + ", standing at " + winnerTWOHeight + ", and weighing in at " + winnerTWOWeight + " " + winnerTWOName + "!");
                        System.out.println();
                        if (winnerONEStats > winnerTWOStats) {
                            System.out.println(winnerONEName + " has won the fight!");
                            System.out.println(winnerONEName + winnerONEFightStat.winFight());
                            System.out.println(winnerTWOName + winnerTWOFightStat.loseFight());
                            winnerFIVEName = winnerONEName;
                            winnerFIVEStats = winnerONEStats;
                            winnerFIVEHomeTown = winnerONEHomeTown;
                            winnerFIVEHeight = winnerONEHeight;
                            winnerFIVEWeight = winnerONEWeight;
                            winnerFIVEFightStat = winnerONEFightStat;
                            System.out.println();
                        } else {
                            System.out.println(winnerTWOName + " has won the fight!");
                            System.out.println(winnerTWOName + winnerTWOFightStat.winFight());
                            System.out.println(winnerONEName + winnerONEFightStat.loseFight());
                            winnerFIVEName = winnerTWOName;
                            winnerFIVEStats = winnerTWOStats;
                            winnerFIVEHomeTown = winnerTWOHomeTown;
                            winnerFIVEHeight = winnerTWOHeight;
                            winnerFIVEWeight = winnerTWOWeight;
                            winnerFIVEFightStat = winnerTWOFightStat;
                            System.out.println();
                        }
                        System.out.println("* Match 6: " + winnerTHREEName + " vs " + winnerFOURName + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + winnerTHREEHomeTown + ", standing at " + winnerTHREEHeight + ", and weighing in at " + winnerTHREEWeight + " " + winnerTHREEName + "!");
                        System.out.println("And his opponent, fighting out of " + winnerFOURHomeTown + ", standing at " + winnerFOURHeight + ", and weighing in at " + winnerFOURWeight + " " + winnerFOURName + "!");
                        System.out.println();
                        if (winnerTHREEStats > winnerFOURStats) {
                            System.out.println(winnerTHREEName + " has won the fight!");
                            System.out.println(winnerTHREEName + winnerTHREEFightStat.winFight());
                            System.out.println(winnerFOURName + winnerFOURFightStat.loseFight());
                            winnerSIXName = winnerTHREEName;
                            winnerSIXStats = winnerTHREEStats;
                            winnerSIXHomeTown = winnerTHREEHomeTown;
                            winnerSIXHeight = winnerTHREEHeight;
                            winnerSIXWeight = winnerTHREEWeight;
                            winnerSIXFightStat = winnerTHREEFightStat;
                            System.out.println();
                        } else {
                            System.out.println(winnerFOURName + " has won the fight!");
                            System.out.println(winnerFOURName + winnerFOURFightStat.winFight());
                            System.out.println(winnerTHREEName + winnerTHREEFightStat.loseFight());
                            winnerSIXName = winnerFOURName;
                            winnerSIXStats = winnerFOURStats;
                            winnerSIXHomeTown = winnerFOURHomeTown;
                            winnerSIXHeight = winnerFOURHeight;
                            winnerSIXWeight = winnerFOURWeight;
                            winnerSIXFightStat = winnerFOURFightStat;
                            System.out.println();
                        }
                        System.out.println("* The Main Event: " + winnerFIVEName + " vs " + winnerSIXName + " *");
                        System.out.println("Ladies and gentlemen, introducing first, fighting out of " + winnerFIVEHomeTown + ", standing at " + winnerFIVEHeight + ", and weighing in at " + winnerFIVEWeight + " " + winnerFIVEName + "!");
                        System.out.println("And his opponent, fighting out of " + winnerSIXHomeTown + ", standing at " + winnerSIXHeight + ", and weighing in at " + winnerSIXWeight + " " + winnerSIXName + "!");
                        System.out.println();
                        if (winnerFIVEStats > winnerSIXStats) {
                            System.out.println(winnerFIVEName + " has won the tournament!");
                            System.out.println(winnerFIVEName + winnerFIVEFightStat.winFight());
                            System.out.println(winnerSIXName + winnerSIXFightStat.loseFight());
                            System.out.println();
                        } else {
                            System.out.println(winnerSIXName + " has won the tournament!");
                            System.out.println(winnerSIXName + winnerSIXFightStat.winFight());
                            System.out.println(winnerFIVEName + winnerFIVEFightStat.loseFight());
                            System.out.println();
                        }


                    }
                }
            }


        } else {
            System.out.println("Sorry, that is not a correct option.");
        }
        run();
    }

    public void bookAShow() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome To Build A Show");
            System.out.println("First choose how many matches will happen on your show:");
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            switch (choice) {
                case BOOK_MENU_CHOOSE_YOUR_WRESTLER:
                    threeMatchShow();
                    break;
                case BOOK_MENU_CHOOSE_YOUR_OPPONENT:
                    break;
                case BOOK_MENU_FIGHT:
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    System.exit(0);
            }
        }

        }

    public void threeMatchShow() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to name your show?");
        String showName = scanner.nextLine();
        System.out.println();
        System.out.println("What city will your show be taking place in?");
        String showCity = scanner.nextLine();
        System.out.println();
        displayRosterONE();
        System.out.println();
        System.out.println("Book Match #1");
        System.out.println("Choose what type of match this will be:");
        while (true) {
            String winnerOne;
            String winnerTwo;
            String winnerThree;
            String winnerPone;
            String winnerPtwo;
            String winnerPthree;
            String winnerPfour;
            String winnerPfive;
            String winnerPsix;
            String choice = (String) menu.getChoiceFromOptions(MATCH_MENU_OPTIONS);

            switch (choice) {
                case BOOK_SINGLES:
                    System.out.println();
                    System.out.println("Please choose your Wrestler: 1 - 10");
                    String fighterONE = scanner.nextLine();

                    if (roster.getRosterList().containsKey(fighterONE)) {
                        System.out.println("You have chosen " + roster.getRosterList().get(fighterONE).getName());
                        System.out.println();
                        System.out.println("Please choose your Opponent: 1 - 10");
                        String fighterTWO = scanner.nextLine();

                        if (roster.getRosterList().containsKey(fighterTWO)) {
                            System.out.println("You have chosen " + roster.getRosterList().get(fighterTWO).getName() + " as your opponent.");

                            if (roster.getRosterList().get(fighterONE).getFightStat() > roster.getRosterList().get(fighterTWO).getFightStat()) {
                                winnerOne = roster.getRosterList().get(fighterONE).getName();
                            } else {
                                winnerOne = roster.getRosterList().get(fighterTWO).getName();

                            }
                        }
                    }
                    break;
                case BOOK_TEAMS:
                    System.out.println();
                    System.out.println("Please choose your first Wrestler: 1 - 10");
                    String partnerONE = scanner.nextLine();

                    if (roster.getRosterList().containsKey(partnerONE)) {
                        System.out.println("You have chosen " + roster.getRosterList().get(partnerONE).getName());
                        System.out.println();
                        System.out.println("Please choose his Tag Team partner: 1 - 10");
                        String partnerTWO = scanner.nextLine();

                        if (roster.getRosterList().containsKey(partnerTWO)) {
                            System.out.println("You have chosen " + roster.getRosterList().get(partnerTWO).getName() + " & " + roster.getRosterList().get(partnerONE).getName() + " as your Tag Team.");
                            System.out.println();

                            System.out.println();

                            System.out.println("Please choose your first Opponent: 1 - 10");
                            String partnerThree = scanner.nextLine();

                            if (roster.getRosterList().containsKey(partnerThree)) {
                                System.out.println("You have chosen " + roster.getRosterList().get(partnerThree).getName());
                                System.out.println();
                                System.out.println("Please choose his Tag Team partner: 1 - 10");
                                String partnerFOUR = scanner.nextLine();

                                if (roster.getRosterList().containsKey(partnerFOUR)) {
                                    System.out.println("You have chosen " + roster.getRosterList().get(partnerFOUR).getName() + " & " + roster.getRosterList().get(partnerThree).getName() + " as their opponents.");
                                    System.out.println();

                                    if ((roster.getRosterList().get(partnerONE).getFightStat() + roster.getRosterList().get(partnerTWO).getFightStat()) > (roster.getRosterList().get(partnerThree).getFightStat() + roster.getRosterList().get(partnerONE).getFightStat())) {
                                        winnerPone = roster.getRosterList().get(partnerTWO).getName();
                                        winnerPtwo = roster.getRosterList().get(partnerONE).getName();

                                    } else {
                                        winnerPone = roster.getRosterList().get(partnerFOUR).getName();
                                        winnerPtwo = roster.getRosterList().get(partnerThree).getName();
                                    }
                                }
                            }
                        }

                        break;


                    }


                    System.out.println();
                    displayRosterONE();
                    System.out.println();
                    System.out.println("Book Match #2");
                    System.out.println("Choose what type of match this will be:");
                    while (true) {
                        String choiceTwo = (String) menu.getChoiceFromOptions(MATCH_MENU_OPTIONS);

                        switch (choiceTwo) {
                            case BOOK_SINGLES:

                                System.out.println();
                                System.out.println("Please choose your Wrestler: 1 - 10");
                                String fighterThree = scanner.nextLine();

                                if (roster.getRosterList().containsKey(fighterThree)) {
                                    System.out.println("You have chosen " + roster.getRosterList().get(fighterThree).getName());
                                    System.out.println();
                                    System.out.println("Please choose your Opponent: 1 - 10");
                                    String fighterFour = scanner.nextLine();

                                    if (roster.getRosterList().containsKey(fighterFour)) {
                                        System.out.println("You have chosen " + roster.getRosterList().get(fighterFour).getName() + " as your opponent.");
                                    }
                                }
                                break;
                            case BOOK_TEAMS:

                                System.out.println("Please choose your first Wrestler: 1 - 10");
                                String partnerFive = scanner.nextLine();

                                if (roster.getRosterList().containsKey(partnerFive)) {
                                    System.out.println("You have chosen " + roster.getRosterList().get(partnerFive).getName());
                                    System.out.println();
                                    System.out.println("Please choose his Tag Team partner: 1 - 10");
                                    String partnerSIX = scanner.nextLine();

                                    if (roster.getRosterList().containsKey(partnerSIX)) {
                                        System.out.println("You have chosen " + roster.getRosterList().get(partnerSIX).getName() + " & " + roster.getRosterList().get(partnerFive).getName() + " as your Tag Team.");
                                        System.out.println();

                                        System.out.println();

                                        System.out.println("Please choose your first Opponent: 1 - 10");
                                        String partnerSEVEN = scanner.nextLine();

                                        if (roster.getRosterList().containsKey(partnerSEVEN)) {
                                            System.out.println("You have chosen " + roster.getRosterList().get(partnerSEVEN).getName());
                                            System.out.println();
                                            System.out.println("Please choose his Tag Team partner: 1 - 10");
                                            String partnerEIGHT = scanner.nextLine();

                                            if (roster.getRosterList().containsKey(partnerEIGHT)) {
                                                System.out.println("You have chosen " + roster.getRosterList().get(partnerEIGHT).getName() + " & " + roster.getRosterList().get(partnerSEVEN).getName() + " as their opponents.");
                                                System.out.println();

                                            }
                                        }
                                    }
                                }
                                break;
                        }
                        System.out.println();
                        displayRosterONE();
                        System.out.println();
                        System.out.println("Book Match #3");
                        System.out.println("Choose what type of match this will be:");
                        while (true) {
                            String choiceThree = (String) menu.getChoiceFromOptions(MATCH_MENU_OPTIONS);

                            switch (choiceThree) {
                                case BOOK_SINGLES:

                                    System.out.println();
                                    System.out.println("Please choose your Wrestler: 1 - 10");
                                    String fighterFive = scanner.nextLine();

                                    if (roster.getRosterList().containsKey(fighterFive)) {
                                        System.out.println("You have chosen " + roster.getRosterList().get(fighterFive).getName());
                                        System.out.println();
                                        System.out.println("Please choose your Opponent: 1 - 10");
                                        String fighterSix = scanner.nextLine();

                                        if (roster.getRosterList().containsKey(fighterSix)) {
                                            System.out.println("You have chosen " + roster.getRosterList().get(fighterSix).getName() + " as your opponent.");

                                        }
                                    }
                                    break;
                                case BOOK_TEAMS:

                                    System.out.println("Please choose your first Wrestler: 1 - 10");
                                    String partnerNine = scanner.nextLine();

                                    if (roster.getRosterList().containsKey(partnerNine)) {
                                        System.out.println("You have chosen " + roster.getRosterList().get(partnerNine).getName());
                                        System.out.println();
                                        System.out.println("Please choose his Tag Team partner: 1 - 10");
                                        String partnerTen = scanner.nextLine();

                                        if (roster.getRosterList().containsKey(partnerTen)) {
                                            System.out.println("You have chosen " + roster.getRosterList().get(partnerTen).getName() + " & " + roster.getRosterList().get(partnerNine).getName() + " as your Tag Team.");
                                            System.out.println();

                                            System.out.println();

                                            System.out.println("Please choose your first Opponent: 1 - 10");
                                            String partnerEleven = scanner.nextLine();

                                            if (roster.getRosterList().containsKey(partnerEleven)) {
                                                System.out.println("You have chosen " + roster.getRosterList().get(partnerEleven).getName());
                                                System.out.println();
                                                System.out.println("Please choose his Tag Team partner: 1 - 10");
                                                String partnerTwelve = scanner.nextLine();

                                                if (roster.getRosterList().containsKey(partnerTwelve)) {
                                                    System.out.println("You have chosen " + roster.getRosterList().get(partnerTwelve).getName() + " & " + roster.getRosterList().get(partnerEleven).getName() + " as their opponents.");
                                                    System.out.println();

                                                }
                                            }
                                        }
                                    }
                            }


                            break;
                        }

                    }
            }

            
                    System.out.println();
 //                   System.out.println("* " + roster.getRosterList().get(winnerOne).getName() + " vs " + roster.getRosterList().get(winnerTwo).getName() + " *");
                    System.out.println();
 //                       System.out.println(roster.getRosterList().get(winnerOne).getName() + " has won the fight!");

                    }


            }














    public void fiveMatchShow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to name your Show?");
        String showName = scanner.nextLine();
        System.out.println();
        System.out.println("What city will your show be taking place in?");
        String showCity = scanner.nextLine();
        System.out.println();
        displayRosterONE();
        System.out.println();

    }

    public void eightMatchShow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to name your Show?");
        String showName = scanner.nextLine();
        System.out.println();
        System.out.println("What city will your show be taking place in?");
        String showCity = scanner.nextLine();
        System.out.println();
        displayRosterONE();
        System.out.println();

    }

}











