package com.ocr.kevin.di;

import com.ocr.kevin.random_choice_services.RandomChoiceService;
import com.ocr.kevin.random_choice_services.RandomService;
import com.ocr.kevin.services.*;

public class DI {

    private static ArcherService archerService = new ArcherAttacksServices();
    private static WarriorSaervice warriorSaervice = new WarriorAttacksServices();
    private static WizardService wizardService = new WizardAttacksServices();
    private static RandomService randomService = new RandomChoiceService();



    public static ArcherService getArcherService() {
        return archerService;
    }
    public static WarriorSaervice getWarriorService() {
        return warriorSaervice;
    }
    public static WizardService getWizardService() {
        return wizardService;
    }

    public static RandomService getRandomService() {
        return randomService;
    }

}
