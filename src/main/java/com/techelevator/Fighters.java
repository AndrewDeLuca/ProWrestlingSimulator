package com.techelevator;

public class Fighters implements RosterBuilder {
    private int fighter_id = 0;
    private String name = "";
    private String hometown = "";
    private double height = 0.0;
    private double weight = 0.0;
    private double strength = 0.0;
    private double speed = 0.0;
    private double skill = 0.0;
    private double charisma = 0.0;

    public double getFightStat() {
        double fightStat = height + weight + strength + speed + skill + charisma;
        return fightStat;
    }

    public int getFighter_id() {
        return fighter_id;
    }

    public void setFighter_id(int fighter_id) {
        this.fighter_id = fighter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getCharisma() {
        return charisma;
    }

    public void setCharisma(double charisma) {
        this.charisma = charisma;
    }

    public String winFight() {
        strength = (strength + 1);
        speed = (speed + 1);
        skill = (skill + 1);
        charisma = (charisma + 1);

        return " has gained skills from this victory!";
    }

    public String loseFight() {
        strength = (strength - 1);
        speed = (speed - 1);
        skill = (skill - 1);
        charisma = (charisma - 1);

        return " has sustained damage from this lose!";
    }

}

