package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;

public class Thor extends Hero{
    private boolean isStunned;



    public Thor(int health, int damage,String name) {
        super(health, damage, SuperAbility.STUN, name);
        this.isStunned=true;





    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
            Random random = new Random();

            isStunned = random.nextBoolean();

            if (isStunned) {
                boss.setDamage(0);
                System.out.println(getName() + " stunned the boss for 1 round ");


            } else {
                boss.setDamage(50);
            }

    }
}
