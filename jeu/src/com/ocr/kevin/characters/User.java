package com.ocr.kevin.characters;

public class User {
    private int level;
    private int healthpoint;
    private int strength;
    private int agility;
    private int intelligence;

    public User(int level, int healthpoint, int strength, int agility, int intelligence) {
        this.level = level;
        this.healthpoint = healthpoint;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthpoint() {
        return healthpoint;
    }

    public void setHealthpoint(int healthpoint) {
        this.healthpoint = healthpoint;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
