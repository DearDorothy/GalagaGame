package model.manager_ships;


import model.field.fieldObject.Ship;

import java.util.List;

/**
 * В чем суть класса игрока, он по сути выполняет роль управляющего.
 * То есть, если все переносить в реале, то не может же корабль сам управлять собой,
 * конечно если это не беспилотник. По сути можно и без него обойтись и будет проще (наверное).
 * Уж точно проще в плане написания кода.
 */
public class Player {

    private int numberShips;
    private List<Ship> fleetShips;
    private Ship activeShip;

    public Player(int numberShips) {
        this.numberShips = numberShips;
    }

    public void move(int dx) { activeShip.moveShip(dx);}

    public int getNumberShips() { return numberShips; }

    // Нужно будет реализовать методы по получению флота кораблей и далее логикой их упрвления
    public void setFleetShips(List<Ship> fleetShips) {
        this.fleetShips = fleetShips;

        System.out.println("Успешно передали флот кораблей Игроку!!!!!!");
    }
}
