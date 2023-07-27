package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Tanos");


        Warrior warrior = new Warrior(290, 10, "Herkules");
        Warrior warrior2 = new Warrior(270, 15, "Ahiles");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(280, 20, "Harry Potter",1);
        Berserk berserk = new Berserk(260, 10, "Guts");
        Medic assistant = new Medic(300, 5, 5, "Strange");
        Witcher witcher = new Witcher(150,0,"Geralt");
        Thor thor = new Thor(265,0,"Chris ");
        Hacker hacker = new Hacker(240,1,"MRX",50);
        Samurai samurai = new Samurai(245,10,"Hikari");
        Bomber bomber = new Bomber(100,5,"Bomb");




        Hero[] heroes = {warrior, warrior2, doc, magic, berserk, assistant,witcher,thor,hacker,samurai,bomber};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
