package com.ocr.kevin.launch;


import com.ocr.kevin.characters.User;
import com.ocr.kevin.di.DI;
import com.ocr.kevin.random_choice_services.RandomService;
import com.ocr.kevin.services.ArcherService;
import com.ocr.kevin.services.WarriorSaervice;
import com.ocr.kevin.services.WizardService;

import java.util.Scanner;

public class Start {
    private  Scanner sc = new Scanner(System.in);
    private ArcherService archerService = DI.getArcherService();
    private WarriorSaervice warriorSaervice = DI.getWarriorService();
    private WizardService wizardService = DI.getWizardService();
    private RandomService randomService = DI.getRandomService();
    private  static User user1 = new User(1, 0, 0, 0, 0);
    private  static User user2 = new User(1, 0, 0, 0, 0);
    private int is ;
    private int level ;
    private int agility ;
    private int strength ;
    private int  intelligence;
    private int menuAttack ;
    private int randomCharacter ;
    private int randomAttack ;


    public void  launch() {
        System.out.println("FIGHT CLUB !!");
        System.out.println("____________________________________");
        System.out.println("Les règles sont simples");
        System.out.println("Ce jeu est un 1 contre 1, les deux joueurs configurent leur personnage pour s'affronter à la fin.");
        System.out.println("Pour la configuration, vous devrez choisir un personnage ainsi que ses caractéristiques");
        System.out.println("Exemple:");
        System.out.println("Configuration :");
        System.out.println("Choix d'une classe");
        System.out.println("Choix des caractéristiques ");
        System.out.println("---- > La partie commence");
        System.out.println("________");
        System.out.println("Tapez '1' pour commencer la partie :)");
        for (; sc.nextInt() != 1;){
            System.out.println("Le chiffre 1 est demandé pour lancer le jeu");
        }
            configuration();
    }

    private void configuration() {
        System.out.println("Configuration du personnage");
        System.out.println("Choisissez une classe :");
        System.out.println("1 - Guerrier");
        System.out.println("2 - Rôdeur");
        System.out.println("3 - Mage");
        is = sc.nextInt();
        while (is > 3 || is < 1){
           System.out.println("Vous devez choisir entre la classe 1, 2 ou 3.");
           is = sc.nextInt();
        }
        switch (is){
            case 1:
                System.out.println("Vous avez choisis la classe guerrier");
                break;
            case 2:
                System.out.println("Vous avez choisis la classe Rôdeur");
                break;
            case 3:
                System.out.println("Vous avez choisis la classe Mage");
                break;
        }
        do {
            System.out.println("Choisissez vos caractéristiques :");
            System.out.println("!! ATTENTION LE TOTAL : FORCE + AGILITÉ + INTELLIGENCE DOIT ÊTRE ÉGAL AU NIVEAU DU JOUEUR !!");
            System.out.println("niveau : (entre 1 et 100)");
            level = sc.nextInt();
            while (level < 1 || level > 100) {
                System.out.println("Vous devez choisir Un niveau entre 1 et 100.");
                level = sc.nextInt();
            }
            user1.setLevel(level);

            System.out.println("force (entre 0 et 100)");
            strength = sc.nextInt();
            while (strength < 0 || strength > 100) {
                System.out.println("Vous devez choisir Une force entre 0 et 100.");
                strength = sc.nextInt();
            }
            user1.setStrength(strength);

            System.out.println("Agilité (entre 0 et 100)");
            agility = sc.nextInt();
            while (agility < 0 || agility > 100) {
                System.out.println("Vous devez choisir Une agilité entre 0 et 100.");
                agility = sc.nextInt();
            }
            user1.setAgility(agility);

            System.out.println("intelligence (entre 0 et 100)");
            intelligence = sc.nextInt();
            while (intelligence < 0 || intelligence > 100) {
                System.out.println("Vous devez choisir Une intelligence entre 0 et 100.");
                intelligence = sc.nextInt();
            }
            user1.setIntelligence(intelligence);
            user1.setHealthpoint(level * 5);
        }while (level != strength + agility + intelligence);

        System.out.println("Vous avez fini la configuration de votre personnage");
        System.out.println("Voici vos choix --> level:"+level+", force:"+strength+", agilité:"+agility+", intelligence:"+intelligence+", hp disponible:"+user1.getHealthpoint());
        System.out.println("Le programme va maintenant configurer son personnage");
        do {
            randomCharacter = randomService.randomChoiceCharacter();
            user2.setLevel(randomService.randomChoiceLevel());
            user2.setStrength(randomService.randomChoiceStrength());
            user2.setAgility(randomService.randomChoiceAgility());
            user2.setIntelligence(randomService.randomChoiceIntelligence());
            user2.setHealthpoint(user2.getLevel() * 5);
        }while (user2.getLevel() != user2.getStrength() + user2.getAgility() + user2.getIntelligence());

        switch (randomCharacter){
            case 0:
                System.out.println("Le programme a choisit la classe : Guerrier --> level:"+user2.getLevel()+", force:"+user2.getStrength()+", agilité:"+user2.getAgility()+", intelligence:"+user2.getIntelligence()+", hp disponible:"+user2.getHealthpoint());
                break;
            case 1:
                System.out.println("Le programme a choisit la classe : Rôdeur --> level:"+user2.getLevel()+", force:"+user2.getStrength()+", agilité:"+user2.getAgility()+", intelligence:"+user2.getIntelligence()+", hp disponible:"+user2.getHealthpoint());
                break;
            case 2:
                System.out.println("Le programme a choisit la classe : Mage --> level:"+user2.getLevel()+", force:"+user2.getStrength()+", agilité:"+user2.getAgility()+", intelligence:"+user2.getIntelligence()+", hp disponible:"+user2.getHealthpoint());
                break;
            default:
                System.out.println("error");
        }
        System.out.println("Le programme est prêt.");
        System.out.println("___________________________");
        System.out.println("C'EST PARTI !!");
        System.out.println("Tapez 0 pour commencer le combat");
        for (; sc.nextInt() != 0;){
            System.out.println("Le chiffre 0 est demandé pour commencer le combat");
        }
        play();
    }

    private void play() {
        while (user1.getHealthpoint() > 0 && user2.getHealthpoint() > 0) {
            switch (is) {
                case 1:
                    warriorMenu();
                    break;
                case 2:
                    archerMenu();
                    break;
                case 3:
                    wizardMenu();
                    break;
            }
            if (user1.getHealthpoint() > 0 && user2.getHealthpoint() > 0) {
                randomAttack = randomService.randomAttack();
                switch (randomCharacter) {
                    case 0:
                        System.out.println("Au tour du programme jouer : statut --> Guerrier");
                        if (randomAttack == 0) {
                            System.out.println("1 - Attaque Basique - Coup d’Épée, de la part du programme");
                            warriorSaervice.performBasicAttack(user1, user2);
                        } else {
                            System.out.println("2 - Attaque Spéciale - Coup de Rage, de la part du programme");
                            warriorSaervice.performSpecialAttack(user1, user2);
                        }
                        break;
                    case 1:
                        System.out.println("Au tour du programme jouer : statut --> Rôdeur");
                        if (randomAttack == 0) {
                            System.out.println("1 - Attaque Basique - Tir à l’Arc, de la part du programme");
                            archerService.performBasicAttack(user1, user2);
                        } else {
                            System.out.println("2 - Attaque Spéciale - Concentration, de la part du programme");
                            archerService.performSpecialAttack(user2);
                        }
                        break;
                    case 2:
                        System.out.println("Au tour du programme jouer : statut --> Mage");
                        if (randomAttack == 0) {
                            System.out.println("1 - Attaque Basique - Boule de Feu, de la part du programme");
                            wizardService.performBasicAttack(user1, user2);
                        } else {
                            System.out.println("2 - Attaque Spéciale - Soin, de la part du programme");
                            wizardService.performSpecialAttack(user2);
                        }
                        break;
                    default:
                        System.out.println("Attaque par défaut : Attaque simple");
                }
            }
            System.out.println("Voici vos points de vie ----> "+user1.getHealthpoint());
            System.out.println("Points de vie du programme ----> "+user2.getHealthpoint() );
        }

        if (user1.getHealthpoint() == 0){
            System.out.println("FIN DU COMBAT !!");
            System.out.println("Le combat est remporté par le programme !!");
        }else {
            System.out.println("FIN DU COMBAT !!");
            System.out.println("Vous êtes le vainqueur du combat!!");
        }

    }

    private void warriorMenu() {
        System.out.println("À votre tour de jouer : statut --> Guerrier");
        System.out.println("1 - Attaque Basique - Coup d’Épée");
        System.out.println("2 - Attaque Spéciale - Coup de Rage");
        menuAttack = sc.nextInt();
        while (menuAttack < 1 || menuAttack > 3){
            System.out.println("Vous devez choisir entre une attaque simple ou une attaque spéciale.");
            menuAttack = sc.nextInt();
        }
            switch (menuAttack) {
                case 1:
                    warriorSaervice.performBasicAttack(user2,user1);
                    System.out.println("2 - Attaque Basique - Coup d’Épée");
                    break;
                case 2:
                    warriorSaervice.performSpecialAttack(user2,user1);
                    System.out.println("2 - Attaque Spéciale - Coup de Rage ");
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque simple");
                    warriorSaervice.performBasicAttack(user2,user1);
            }

    }

    private void wizardMenu() {
        System.out.println("À votre tour de jouer : statut --> Mage");
        System.out.println("1 - Attaque Basique - Boule de Feu");
        System.out.println("2 - Attaque Spéciale - Soin");
        menuAttack = sc.nextInt();
        while (menuAttack > 3 || menuAttack < 1){
            System.out.println("Vous devez choisir entre une attaque simple ou une attaque spéciale.");
            menuAttack = sc.nextInt();
        }
            switch (menuAttack) {
                case 1:
                    wizardService.performBasicAttack(user2,user1);
                    System.out.println(" Attaque Basique - Boule");
                    break;
                case 2:
                    wizardService.performSpecialAttack(user1);
                    System.out.println("Attaque Spéciale - Soin");
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque simple");
                    wizardService.performBasicAttack(user2,user1);
            }
    }

    private void archerMenu() {
        System.out.println("À votre tour de jouer : statut --> Archer");
        System.out.println("1 - Attaque Basique - Tir à l’Arc");
        System.out.println("2 - Attaque Spéciale - Concentration");
        menuAttack = sc.nextInt();
        while (menuAttack > 3 || menuAttack < 1){
            System.out.println("Vous devez choisir entre une attaque simple ou une attaque spéciale.");
            menuAttack = sc.nextInt();
        }
            switch (menuAttack) {
                case 1:
                    archerService.performBasicAttack(user2,user1);
                    System.out.println("Attaque Basique - Tir à l’Arc");
                    break;
                case 2:
                    archerService.performSpecialAttack(user1);
                    System.out.println("Attaque Spéciale - Concentration");
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque Basique - Tir à l’Arc");
                    archerService.performBasicAttack(user2,user1);
            }
    }
}
