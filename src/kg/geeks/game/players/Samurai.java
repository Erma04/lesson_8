package kg.geeks.game.players;

import java.util.Random;

public class Samurai extends Hero{
    public Samurai(int health, int damage, String name) {
        super(health, damage, SuperAbility.VIRUS_VACCINE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random= new Random();
        int shurikens = random.nextInt(2)+1;
        if(shurikens==1){
            boss.setHealth(boss.getHealth()-this.getDamage());
            System.out.println(getName()+" threw a shuriken "+shurikens);
        }else{
            boss.setHealth(boss.getHealth()+this.getDamage());
            System.out.println(getName()+" threw a shuriken "+shurikens);
        }


    }
}
