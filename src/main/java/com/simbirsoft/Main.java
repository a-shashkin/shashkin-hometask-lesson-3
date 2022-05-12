package com.simbirsoft;

public class Main {
    public static void main(String[] args) {

        ArtilleryWarship Bismarck = new ArtilleryWarship(
                "Bismarck",
                "Bismarck-class",
                "Germany",
                64500,
                true,
                "380mm SK C/34",
                11600
        );

        AircraftCarrier Enterprise = new AircraftCarrier(
                "Enterprise",
                "Yorktown-class",
                "USA",
                51400,
                true,
                "TBF Avenger",
                6470
        );

        Bismarck.showNameTypeClassAndCountry();
        Enterprise.showNameTypeClassAndCountry();
        Bismarck.artilleryAttack(Enterprise);
        Enterprise.planeAttack(Bismarck);
        Bismarck.artilleryAttack(Enterprise);
        Enterprise.planeAttack(Bismarck);
        Bismarck.artilleryAttack(Enterprise);
        Enterprise.planeAttack(Bismarck);
        Bismarck.artilleryAttack(Enterprise);
        Enterprise.planeAttack(Bismarck);
        Bismarck.artilleryAttack(Enterprise);
        Enterprise.planeAttack(Bismarck);

        ArtilleryWarship Sovetsky_Soyuz = new ArtilleryWarship(
                "Sovetsky Soyuz",
                "Sovetsky Soyuz-class",
                "USSR",
                80900,
                true,
                "406mm B-37",
                13250
        );

        AircraftCarrier Graf_Zeppelin = new AircraftCarrier(
                "Graf Zeppelin",
                "Graf Zeppelin-class",
                "Germany",
                52600,
                true,
                "Ta 152C-1/R14",
                5340
        );

        fightUntilOneOfShipsSinks(Sovetsky_Soyuz, Graf_Zeppelin);
    }

    public static void fightUntilOneOfShipsSinks(Warship warship1, Warship warship2) {
        System.out.println("The battle between " + warship1.name + " from " + warship1.country + " and " + warship2.name + " from " + warship2.country + " is about to start!");
        while (warship1.isSunk == false && warship2.isSunk == false) {
            if (warship1 instanceof ArtilleryWarship) {
                ((ArtilleryWarship) warship1).artilleryAttack(warship2);
            } else if (warship1 instanceof AircraftCarrier) {
                ((AircraftCarrier) warship1).planeAttack(warship2);
            }
            if (warship2 instanceof ArtilleryWarship) {
                ((ArtilleryWarship) warship2).artilleryAttack(warship1);
            } else if (warship2 instanceof AircraftCarrier) {
                ((AircraftCarrier) warship2).planeAttack(warship1);
            }
            if (warship1.isSunk == true || warship2.isSunk == true) {
                if (warship1.isSunk == true) {
                    System.out.println("Battle ended! " + warship2.name + " from " + warship2.country + " has won!");
                } else if (warship2.isSunk == true) {
                    System.out.println("Battle ended! " + warship1.name + " from " + warship1.country + " has won!");
                }
                break;
            }
        }
    }
}
