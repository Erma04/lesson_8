package kg.geeks.game.players;

public class Magic extends Hero {
    private int boostHeroes;
    public Magic(int health, int damage, String name,int boostHeroes) {
        super(health, damage, SuperAbility.BOOST, name);
        this.boostHeroes=boostHeroes;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero:heroes) {
            if (hero.getHealth() > 0 && hero.getAbility()!=SuperAbility.REVIVE ) {
                hero.setDamage(hero.getDamage() + boostHeroes);
            }

        }

    }
}
