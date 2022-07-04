package com.simbirsoft;

public class Warship {

    String name;
    String shipClass;
    String country;

    int maxHealthPoints;
    int healthPoints;

    boolean isSunk;
    boolean shipExistedInRealLife;

    public Warship(
            String name,
            String shipClass,
            String country,
            int maxHealthPoints,
            boolean shipExistedInRealLife
    ) {
        this.name = name;
        this.shipClass = shipClass;
        this.country = country;
        this.maxHealthPoints = maxHealthPoints;
        this.shipExistedInRealLife = shipExistedInRealLife;
        this.isSunk = false;
        this.healthPoints = maxHealthPoints;
    }

    void showNameTypeClassAndCountry() {
        System.out.println("Ship name: " + name);
        System.out.println("Ship class: " + shipClass);
        System.out.println("Country: " + country);
    }

    boolean checkIfShipIsSunk() {
        if (isSunk == true) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkIfEnemyShipIsSunk(Warship warship) {
        if (warship.isSunk == true) {
            return true;
        } else {
            return false;
        }
    }

    void checkIfShipWasDestroyed() {
        if (healthPoints <= 0) {
            System.out.println("Ship " + name + " that belongs to " + country + " has been sunk!");
            isSunk = true;
        } else {
            System.out.println("Ship " + name + " is still afloat! It still can do something.");
        }
    }

    void checkIfShipExistedInRealLife() {
        if (shipExistedInRealLife == false) {
            System.out.println("Ship " + name + " never existed in real life. But fine, let's dream a little...");
        }
    }

    void resurrectShip() {
        healthPoints = maxHealthPoints;
        isSunk = false;
    }
}
