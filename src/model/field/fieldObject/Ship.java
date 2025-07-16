package model.field.fieldObject;

import model.event.ShipPlayerActionEvent;
import model.event.ShipPlayerActionListener;

import java.util.ArrayList;
import java.util.List;

public class Ship extends FieldObject {

    private List<ShipPlayerActionListener> shipPlayerListListeners = new ArrayList<>();

    public Ship(int x, int y) { super(x, y, 5); }

    public void moveShip(int dx) {

        x += dx * speed;

        // Оповестил, что произошло перемещение корабля
        fireShipPayerIsMoved();
    }

    public void fire() {
        Bullet bullet = new Bullet(x + 15 / 2, y);

        // Оповестить, что корабль совершил выстрел
        fireShipPlayerIsFire(bullet);
    }

    public void addShipPLayerListListener(ShipPlayerActionListener listener) { shipPlayerListListeners.add(listener); }

    public void removeShipPlayerListListener(ShipPlayerActionListener listener) { shipPlayerListListeners.remove(listener); }

    private void fireShipPayerIsMoved() {
        for(ShipPlayerActionListener listener : shipPlayerListListeners) {
            ShipPlayerActionEvent event = new ShipPlayerActionEvent(listener);
            event.setShip(this);
            listener.shipIsMoved(event);
        }
    }

    private void fireShipPlayerIsFire(Bullet bullet) {
        for(ShipPlayerActionListener listener : shipPlayerListListeners) {
            ShipPlayerActionEvent event = new ShipPlayerActionEvent(listener);
            event.setBullet(bullet);
            listener.shipIsFire(event);
        }
    }
}
