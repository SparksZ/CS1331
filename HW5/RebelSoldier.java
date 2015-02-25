/**
* RebelSoldier is a subclass of soldier in Battlefront Simulation
*
* @author Zack Sparks
* @version 1.0
*/
public class RebelSoldier extends Soldier {

    private final String identifier;
    private final double attackChance;
    private final double damageBonus;

    /**
    * Constructs RebelSoldier object. 80% chance of dealing damage;
    * no attack bonus.
    * @param health The health value this RebelSoldier should begin with.
    *               Starting health must be at least 30.0 and up to 100.0
    * @param attack The attack value this Soldier should begin with.
                    Attack is bounded by [0.0, 100.0];
    * @param defense The defense value this Soldier should begin with.
                     Defense is bounded by [0.0, 100.0];
    * @param identifier The identifier of this Soldier.
    */
    public RebelSoldier(double health, double attack, double defense,
        String identifier) {

        super(health, attack, defense, identifier);

        this.identifier = "Rebel Soldier " + super.getIdentifier();
        this.attackChance = 0.8;
        this.damageBonus = 0.0;
    }

    /**
     * Attacks a target soldier, using the hurt method to damage it.
     * Concrete subclasses implement the logic for how much to hurt
     * target Soldiers by.
     * @param target The Soldier to attack.
     * @return The amount of damage dealt to the target Soldier.
     */
    public double attack(Soldier target) {

        // Monte Carlo for attack chance
        if (Math.random() <= this.attackChance) {
            target.hurt(this.getAttack() * (1 + this.damageBonus));
            return this.getAttack() * (1 + this.damageBonus);
        } else {
            return 0.0;
        }
    }
}
