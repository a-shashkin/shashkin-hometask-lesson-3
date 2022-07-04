package com.simbirsoft;

public class TorpedoWarship extends Warship {

    String torpedo;
    int torpedoDamage;
    int torpedoesInSalvo;

    public TorpedoWarship(
            String name,
            String shipClass,
            String country,
            int maxHealthPoints,
            boolean shipExistedInRealLife,
            String torpedo,
            int torpedoDamage,
            int torpedoesInSalvo
    ) {
        super(name, shipClass, country, maxHealthPoints, shipExistedInRealLife);
        this.torpedo = torpedo;
        this.torpedoDamage = torpedoDamage;
        this.torpedoesInSalvo = torpedoesInSalvo;
    }

    void torpedoAttack(Warship warship) {
        if (checkIfShipIsSunk()) {
            return;
        }
        if (checkIfEnemyShipIsSunk(warship)) {
            return;
        }
        System.out.println("Ship " + name + " attacks " + warship.name + " with torpedoes and deals " + torpedoDamage * torpedoesInSalvo + " damage!");
        warship.healthPoints = warship.healthPoints - (torpedoDamage * torpedoesInSalvo);
        System.out.println("Ship " + warship.name + " has " + warship.healthPoints + " HP left.");
        warship.checkIfShipWasDestroyed();
    }

    void showShipAndArmament() {
        showNameTypeClassAndCountry();
        System.out.println("Ship is armed with " + torpedo);
        System.out.println();
    }
}
