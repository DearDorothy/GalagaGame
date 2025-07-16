package model.event;

import model.field.fieldObject.Bullet;
import model.field.fieldObject.Ship;

import java.util.EventObject;


public class ShipPlayerActionEvent extends EventObject {

    private Ship ship;

    private Bullet bullet;

    public void setShip(Ship ship) { this.ship = ship; }

    public Ship getShip() { return ship; }

    public void setBullet(Bullet bullet) { this.bullet = bullet; }

    public Bullet getBullet() { return bullet; }

    public ShipPlayerActionEvent(Object source) { super(source); }
}
