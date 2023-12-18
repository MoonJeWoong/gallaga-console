package gallaga.model;

import gallaga.model.wrapper.Damage;
import gallaga.model.wrapper.Velocity;

public class Bullet {

    private Damage damage;
    private Velocity velocity;

    public Bullet(Damage damage, Velocity velocity) {
        this.damage = damage;
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage.getValue();
    }
}
