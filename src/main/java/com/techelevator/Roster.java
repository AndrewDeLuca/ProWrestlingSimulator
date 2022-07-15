package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Roster {

    private Map<String, RosterBuilder> rosterList = new LinkedHashMap<>();

    public Map<String, RosterBuilder> getRosterList() {
        return rosterList;
    }

    public void addToRosterList(String rosterList, RosterBuilder type) {
        this.rosterList.put(rosterList, type);
    }

    public Roster(){

    }

    public void rosterOptions() {
        String fileName = "ProWrestlingSimulator.csv";
        File rosterCSV = new File(fileName);


        try (Scanner rosterListScanner = new Scanner(rosterCSV)) {
            while (rosterListScanner.hasNextLine()) {
                String lineOfText = rosterListScanner.nextLine();
                String[] splitLineForRestocking = lineOfText.split("\\|");

                switch (splitLineForRestocking[0].charAt(0)) {
                    default:
                        Fighters fighters = new Fighters();
                        fighters.setFighter_id(Integer.parseInt(splitLineForRestocking[0]));
                        fighters.setName(splitLineForRestocking[1]);
                        fighters.setHometown((splitLineForRestocking[2]));
                        fighters.setHeight(Double.parseDouble(splitLineForRestocking[3]));
                        fighters.setWeight(Double.parseDouble(splitLineForRestocking[4]));
                        fighters.setStrength(Double.parseDouble(splitLineForRestocking[5]));
                        fighters.setSpeed(Double.parseDouble(splitLineForRestocking[6]));
                        fighters.setSkill(Double.parseDouble(splitLineForRestocking[7]));
                        fighters.setCharisma(Double.parseDouble(splitLineForRestocking[8]));
                        addToRosterList(splitLineForRestocking[0], fighters);
                        break;



                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
