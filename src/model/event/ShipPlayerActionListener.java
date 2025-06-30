package model.event;

public interface ShipPlayerActionListener {
    void shipIsMoved(ShipPlayerActionEvent event);
    void shipIsFire(ShipPlayerActionEvent event);
}
