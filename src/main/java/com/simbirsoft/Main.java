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

        ArtilleryWarship Richelieu = new ArtilleryWarship(
                "Richelieu",
                "Richelieu-class",
                "France",
                54500,
                true,
                "380mm/45 Mle 1935",
                11900
        );

        AircraftCarrier Hakuryuu = new AircraftCarrier(
                "Hakuryuu",
                "Taihou Kai-class",
                "Japan",
                63100,
                false,
                "J5N Tenrai Type 91",
                9340
        );

        TorpedoWarship Shimakaze = new TorpedoWarship(
                "Shimakaze",
                "Shimakaze-class",
                "Japan",
                17900,
                true,
                "Type 93 torpedo",
                4190,
                5
        );

        Bismarck.showShipAndArmament();
        Enterprise.showShipAndArmament();
        Sovetsky_Soyuz.showShipAndArmament();
        Graf_Zeppelin.showShipAndArmament();
        Richelieu.showShipAndArmament();
        Hakuryuu.showShipAndArmament();

        Bismarck.checkIfShipExistedInRealLife();
        Enterprise.checkIfShipExistedInRealLife();
        Sovetsky_Soyuz.checkIfShipExistedInRealLife();
        Graf_Zeppelin.checkIfShipExistedInRealLife();
        Richelieu.checkIfShipExistedInRealLife();
        Hakuryuu.checkIfShipExistedInRealLife();

        System.out.println();

        fightUntilOneOfShipsSinks(Sovetsky_Soyuz, Graf_Zeppelin);

        System.out.println();

        Warship[] redFleet = new Warship[3];
        redFleet[0] = Enterprise;
        redFleet[1] = Sovetsky_Soyuz;
        redFleet[2] = Richelieu;
        Warship[] blackFleet = new Warship[3];
        blackFleet[0] = Bismarck;
        blackFleet[1] = Graf_Zeppelin;
        blackFleet[2] = Hakuryuu;

        fleetBattle(redFleet, blackFleet);

        System.out.println();

        fightUntilOneOfShipsSinks(Enterprise, Shimakaze);

        System.out.println();
        System.out.println("End");
    }

    public static void fightUntilOneOfShipsSinks(Warship warship1, Warship warship2) {
        warship1.resurrectShip();
        warship2.resurrectShip();
        System.out.println("The battle between " + warship1.name + " from " + warship1.country + " and " + warship2.name + " from " + warship2.country + " is about to start!");
        while (warship1.isSunk == false && warship2.isSunk == false) {
            if (warship1 instanceof ArtilleryWarship) {
                ((ArtilleryWarship) warship1).artilleryAttack(warship2);
            } else if (warship1 instanceof AircraftCarrier) {
                ((AircraftCarrier) warship1).planeAttack(warship2);
            } else if (warship1 instanceof TorpedoWarship) {
                ((TorpedoWarship) warship1).torpedoAttack(warship2);
            }
            if (warship2 instanceof ArtilleryWarship) {
                ((ArtilleryWarship) warship2).artilleryAttack(warship1);
            } else if (warship2 instanceof AircraftCarrier) {
                ((AircraftCarrier) warship2).planeAttack(warship1);
            } else if (warship2 instanceof TorpedoWarship) {
                ((TorpedoWarship) warship2).torpedoAttack(warship1);
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

    public static boolean isFleetSunk(Warship[] fleet) {
        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i].isSunk == false) {
                return false;
            }
        }
        return true;
    }

    public static void fleetBattle(Warship[] fleet1, Warship[] fleet2) {
        for (int i = 0; i < fleet1.length; i++) {
            fleet1[i].resurrectShip();
        }
        for (int i = 0; i < fleet1.length; i++) {
            fleet2[i].resurrectShip();
        }
        System.out.println("Two fleets meet each other in battle!");
        System.out.println("Fleet 1 consists of:");
        for (int i = 0; i < fleet1.length; i++) {
            System.out.println(fleet1[i].name);
        }
        System.out.println();
        System.out.println("Fleet 2 consists of:");
        for (int i = 0; i < fleet2.length; i++) {
            System.out.println(fleet2[i].name);
        }
        System.out.println();
        System.out.println("Let's begin the battle!");
        do {
            for (int i = 0; i < fleet1.length; i++) {
                for (int j = 0; j < fleet2.length; j++) {
                    if (fleet1[i] instanceof ArtilleryWarship) {
                        ((ArtilleryWarship) fleet1[i]).artilleryAttack(fleet2[j]);
                    } else if (fleet1[i] instanceof AircraftCarrier) {
                        ((AircraftCarrier) fleet1[i]).planeAttack(fleet2[j]);
                    } else if (fleet1[i] instanceof TorpedoWarship) {
                        ((TorpedoWarship) fleet1[i]).torpedoAttack(fleet2[j]);
                    }
                }
            }
            for (int i = 0; i < fleet2.length; i++) {
                for (int j = 0; j < fleet1.length; j++) {
                    if (fleet2[i] instanceof ArtilleryWarship) {
                        ((ArtilleryWarship) fleet2[i]).artilleryAttack(fleet1[j]);
                    } else if (fleet2[i] instanceof AircraftCarrier) {
                        ((AircraftCarrier) fleet2[i]).planeAttack(fleet1[j]);
                    } else if (fleet2[i] instanceof TorpedoWarship) {
                        ((TorpedoWarship) fleet2[i]).torpedoAttack(fleet1[j]);
                    }
                }
            }
        } while (isFleetSunk(fleet1) == false && isFleetSunk(fleet2) == false);
        if (isFleetSunk(fleet1)) {
            System.out.println("Fleet 1 has been sunk! Fleet 2 wins the battle!");
        } else if (isFleetSunk(fleet2)) {
            System.out.println("Fleet 2 has been sunk! Fleet 1 wins the battle!");
        }
    }
}
