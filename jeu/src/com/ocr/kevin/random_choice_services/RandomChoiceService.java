package com.ocr.kevin.random_choice_services;


import java.util.Random;

public class RandomChoiceService implements RandomService{



    @Override
    public int randomChoiceCharacter() {
        Random random = new Random();
        return random.nextInt(3);
    }

    @Override
    public int randomChoiceLevel() {
        //random
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public int randomChoiceStrength() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public int randomChoiceIntelligence() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public int randomChoiceAgility() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public int randomAttack() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
