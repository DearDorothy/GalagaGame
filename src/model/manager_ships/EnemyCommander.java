package model.manager_ships;

import model.field.fieldObject.Ship;

import java.util.ArrayList;
import java.util.List;

public class EnemyCommander {

    private int numberShipsForPilots;
    private List<EnemyPilot> fleetPilots;

    public EnemyCommander(int numberShips) {
        fleetPilots = new ArrayList<>();
        this.numberShipsForPilots = numberShips;
    }

    public int getNumberShipsForPilots() { return numberShipsForPilots; }

    public int getNumberPilots() { return fleetPilots.size(); }

    public void setFleetShipsForPilots(List<Ship> fleetShipsForPilots) {

        // Передать по одному кораблю каждому пилоту во флоте
        for (Ship ship : fleetShipsForPilots) {
            EnemyPilot currEnemyPilot = new EnemyPilot(ship);
            fleetPilots.add(currEnemyPilot);
        }

        System.out.println("Успешно передали флот кораблей Вражескому Командиру и создали флот Пилотов!!!!!!!");
    }
}
