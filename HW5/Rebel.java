/**
* Rebel is a subclass of soldier in Battlefront Simulation
*
* @author Zack Sparks
* @version 1.0
*/
public class Rebel extends RebelSoldier {

    private final String identifier;
    private final double attackChance;
    private final double damageBonus;

    /**
    * Constructs Rebel object. 75% chance of dealing damage;
    * has a 35% attack bonus.
    * @param health The health value this RebelSoldier should begin with.
    *               Starting health must be at least 30.0 and up to 100.0
    * @param attack The attack value this Soldier should begin with.
    *               Attack is bounded by [0.0, 100.0];
    * @param defense The defense value this Soldier should begin with.
    *               Defense is bounded by [0.0, 100.0];
    * @param identifier The identifier of this Soldier.
    */
    public Rebel(double health, double attack, double defense,
        String identifier) {

        super(health, attack, defense, identifier);

        this.identifier = "Rebel " + super.getIdentifier();
        this.attackChance = 0.75;
        this.damageBonus = 0.15;
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
            damageDealt = this.getAttack() * (1 + this.damageBonus);
        } else {
            damageDealt =  0.0;
        }

        return damageDealt;
    }
}
