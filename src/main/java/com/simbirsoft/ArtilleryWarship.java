package com.simbirsoft;

public class ArtilleryWarship extends Warship {

    String armament;
    int armamentDamage;

    public ArtilleryWarship(
            String name,
            String shipClass,
            String country,
            int maxHealthPoints,
            boolean shipExistedInRealLife,
            String armament,
            int armamentDamage
    ) {
        super(name, shipClass, country, maxHealthPoints, shipExistedInRealLife);
        this.armament = armament;
        this.armamentDamage = armamentDamage;
    }

    void artilleryAttack(Warship warship) {
        if (checkIfShipIsSunk()) {
            return;
        }
        System.out.println("Ship " + name + " attacks " + warship.name + " with artillery and deals " + armamentDamage + " damage!");
        warship.healthPoints = warship.healthPoints - armamentDamage;
        System.out.println("Ship " + warship.name + " has " + warship.healthPoints + " HP left.");
        warship.checkIfShipWasDestroyed();
    }


}
