package kg.geeks.game.players;



public class Hacker extends Hero{

    private int stolenHealth;
    public Hacker(int health, int damage, String name,int stolenHealth) {
        super(health, damage, SuperAbility.STOLEN_HEALTH, name);
        this.stolenHealth= stolenHealth;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        boss.setHealth(boss.getHealth()-this.stolenHealth);

        for (Hero hero:heroes) {

            if(hero.getHealth()>0  && this !=hero && hero.getAbility()!=SuperAbility.EXTRA_DAMAGE){

                hero.setHealth(hero.getHealth()+this.stolenHealth);
                System.out.println(getName()+" translated "+hero.getName()+" "+this.stolenHealth);
                break;

            }



        }

    }
}
