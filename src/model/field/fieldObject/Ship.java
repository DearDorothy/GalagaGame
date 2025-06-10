package model.field.fieldObject;

import model.event.ShipPlayerActionEvent;
import model.event.ShipPlayerActionListener;

import java.util.ArrayList;
import java.util.List;

public class Ship extends FieldObject {

    private List<ShipPlayerActionListener> shipPlayerListListeners = new ArrayList<>();

    public Ship(int x, int y) { super(x, y, 5); }

    public void moveShip(int dx) {

        this.x += dx * this.speed;

        // Оповестил что произошло перемещение корабля
        fireShipPayerIsMoved();
    }


    public void fire() {

    }

    public void addShipPLayerListListener(ShipPlayerActionListener listener) { this.shipPlayerListListeners.add(listener); }

    public void removeShipPlayerListListener(ShipPlayerActionListener listener) { this.shipPlayerListListeners.remove(listener); }

    private void fireShipPayerIsMoved() {
        for(ShipPlayerActionListener listener : this.shipPlayerListListeners) {
            ShipPlayerActionEvent event = new ShipPlayerActionEvent(listener);
            event.setShip(this);
            listener.shipIsMoved(event);
        }
    }
}
