package com.simbirsoft;

public class AircraftCarrier extends Warship {

    String plane;
    int planeDamage;

    public AircraftCarrier(
            String name,
            String shipClass,
            String country,
            int maxHealthPoints,
            boolean shipExistedInRealLife,
            String plane,
            int planeDamage
    ) {
        super(name, shipClass, country, maxHealthPoints, shipExistedInRealLife);
        this.plane = plane;
        this.planeDamage = planeDamage;
    }

    void planeAttack(Warship warship) {
        if (checkIfShipIsSunk()) {
            return;
        }
        System.out.println("Ship " + name + " attacks " + warship.name + " with planes and deals " + planeDamage + " damage!");
        warship.healthPoints = warship.healthPoints - planeDamage;
        System.out.println("Ship " + warship.name + " has " + warship.healthPoints + " HP left.");
        warship.checkIfShipWasDestroyed();
    }
}
