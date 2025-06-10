package model.managers;


import model.field.fieldObject.Ship;

/**
 * В чем суть класса игрока, он по сути выполняет роль управляющего.
 * То есть, если все переносить в реале, то не может же корабль сам управлять собой,
 * конечно если это не беспилотник. По сути можно и без него обойтись и будет проще (наверное).
 * Уж точно проще в плане написания кода.
 */
public class Player {

    private Ship ship;

    public void move(int dx) {
        this.ship.moveShip(dx);
    }
}
