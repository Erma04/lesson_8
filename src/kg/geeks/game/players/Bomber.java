package kg.geeks.game.players;




public class Bomber extends Hero{
    private int extraDamage;
    public Bomber(int health, int damage, String name) {
        super(health, damage,SuperAbility.EXTRA_DAMAGE, name);
        this.extraDamage=100;
    }



    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

            if (this.getHealth() <= 0 ) {
                boss.setHealth(boss.getHealth()-this.extraDamage);
            }
        System.out.println(getName() + " extra damage " + this.extraDamage);

    }

}
