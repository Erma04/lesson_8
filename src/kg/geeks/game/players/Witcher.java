package kg.geeks.game.players;

public class Witcher extends Hero{
    private boolean isAlive;
    public Witcher(int health, int damage,String name) {
        super(health, damage, SuperAbility.REVIVE, name);
        this.isAlive=true;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(this.isAlive) {
            for (Hero hero : heroes) {
                if (hero.getHealth()<=0) {
                    System.out.println("Witcher revived " + hero.getName());
                    this.isAlive = false;
                    hero.setHealth(this.getHealth());
                    this.setHealth(0);
                    return;
                }

            }

        }else {
            System.out.println("Witcher is dead and can't revive");
        }

    }
}
