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
    private User user1 = new User(1, 0, 0, 0, 0);
    private User user2 = new User(1, 0, 0, 0, 0);

    public void  launch(){
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
        int ready = sc.nextInt();
        if (ready == 1) {
                System.out.println("C'est Parti !!");
                startGame();
            }

    }

    public void startGame() {
        System.out.println("Configuration du personnage");
        System.out.println("Choisissez une classe :");
        System.out.println("1 - Guerrier");
        System.out.println("2 - Rôdeur");
        System.out.println("3 - Mage");
        int is = sc.nextInt();
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
            default:
                System.out.println("error");
        }
        System.out.println("Choisissez vos caractéristiques :");
        System.out.println("niveau (entre 1 et 100)");
        int level = sc.nextInt();
        user1.setLevel(level);
        System.out.println("force (entre 0 et 100)");
        int strength = sc.nextInt();
        user1.setStrength(strength);
        System.out.println("Agilité (entre 0 et 100)");
        int agility = sc.nextInt();
        user1.setAgility(agility);
        System.out.println("intelligence (entre 0 et 100)");
        int intelligence = sc.nextInt();
        user1.setIntelligence(intelligence);
        user1.setHealthpoint(level*5);

        System.out.println("Vous avez fini la configuration de votre personnage");
        System.out.println("Voici vos choix --> level:"+level+", force:"+strength+", agilité:"+agility+", intelligence:"+intelligence+", hp disponible:"+user1.getHealthpoint());
        System.out.println("Le programme va maintenant configurer son personnage");

        int randomCharacter = randomService.randomChoiceCharacter();
        user2.setLevel(randomService.randomChoiceLevel());
        user2.setStrength(randomService.randomChoiceStrength());
        user2.setAgility(randomService.randomChoiceAgility());
        user2.setIntelligence(randomService.randomChoiceIntelligence());
        user2.setHealthpoint(user2.getLevel()*5);

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
    }

    public void warriorMenu() {
        System.out.println("À votre tour de jouer : status --> Guerrier");
        System.out.println("1 - Attaque simple ");
        System.out.println("2 - Attaque spéciale ");
        try {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    warriorSaervice.performBasicAttack();
                    break;
                case 2:
                    warriorSaervice.performSpecialAttack();
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque simple");
                    warriorSaervice.performBasicAttack();
            }
        }catch (RuntimeException e){
            System.out.println("erreur de saisie , vous avez le choix entre l'option 1 et l'option 2 ;)");
        }
    }

    public void wizardMenu() {
        System.out.println("À votre tour de jouer : status --> Mage");
        System.out.println("1 - Attaque Simple ");
        System.out.println("2 - Attaque spéciale ");
        try {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    wizardService.performBasicAttack();
                    break;
                case 2:
                    wizardService.performSpecialAttack();
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque simple");
            }
        }catch (RuntimeException e){
            System.out.println("erreur de saisie , vous avez le choix entre l'option 1 et l'option 2 ;)");
        }
    }

    public void archerMenu() {
        System.out.println("À votre tour de jouer : status --> Archer");
        System.out.println("1 - Attaque Simple ");
        System.out.println("2 - Attaque spéciale ");
        try {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    archerService.performBasicAttack();
                    break;
                case 2:
                    archerService.performSpecialAttack();
                    break;
                default:
                    System.out.println("Attaque par défaut : Attaque simple");
            }
        }catch (RuntimeException e){
            System.out.println("erreur de saisie , vous avez le choix entre l'option 1 et l'option 2 ;)");
        }
    }


}
