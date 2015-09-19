/**
 * Jedi is a subclass of force sensitive soldier in Battlefront Simulation
 *
 * @author Zack Sparks
 * @version 1.0
 */
public class Jedi extends Soldier implements ForceSensitive {

    private final String identifier;
    private final double attackChance;
    private final double damageBonus;
    private double power;
    private boolean forceFlag;

    /**
    * Constructs Jedi object. 100% chance of dealing damage;
    * 0% attack bonus.
    * @param health The health value this RebelSoldier should begin with.
    *               Starting health must be at least 30.0 and up to 100.0
    * @param attack The attack value this Soldier should begin with.
                 Attack is bounded by [0.0, 100.0];
    * @param defense The defense value this Soldier should begin with.
                  Defense is bounded by [0.0, 100.0];
    * @param identifier The identifier of this Soldier.
    */
    public Jedi(double health, double attack, double defense,
        String identifier) {

        super(health, attack, defense, identifier);

        this.identifier = "Jedi " + super.getIdentifier();
        this.attackChance = 1.0;
        this.damageBonus = 0.0;
        this.power = 0.25 * getDefense();
    }


    /**
    * Attacks a target soldier, using the hurt method to damage it.
    * Concrete subclasses implement the logic for how much to hurt
    * target Soldiers by.
    * @param target The Soldier to attack.
    * @return The amount of damage dealt to the target Soldier.
    */
    public double attack(Soldier target) {
        double damageDealt;

        // Monte Carlo for attack chance
        if (Math.random() <= this.attackChance) {
            target.hurt(this.getAttack() * (1 + this.damageBonus));
            damageDealt = (super.getAttack()) * (1 + this.damageBonus);
        } else {
            damageDealt = 0.0;
        }

        if (forceFlag) {
            super.changeDefense(-1.0 * this.power);
            forceFlag = false;
        }

        return damageDealt;
    }

    /**
    * Method to modify the instance ForceSensitive's stats before and after an
    * attack
    */
    public void useTheForce() {
        this.forceFlag = true;

        super.heal(0.25 * this.power);
        super.changeDefense(this.power);
    }

    /**
     * @return This Solder's name with the format
     * "Jedi [identifier]".
     */
    @Override public String getName() {
        return "Jedi " + super.getIdentifier();
    }
}
