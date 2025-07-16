package presenter;

import model.field.fieldObject.Ship;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShipPlayerPresenter extends KeyAdapter {

    private Ship ship;
    private boolean leftButtonPressed = false;
    private boolean rightButtonPressed = false;
    private boolean spaceButtonPressed = false;
    private boolean canFire = true;

    public ShipPlayerPresenter(Ship ship) { this.ship = ship; }

    public void hundleInput() {
        if (leftButtonPressed && ship.getX() > 0) ship.moveShip(-1);
        if (rightButtonPressed && ship.getX() < 355) ship.moveShip(1);
        if (spaceButtonPressed && canFire) {
            ship.fire();
            canFire = false;

            new Timer(300, e -> {
                canFire = true;
                ((Timer) e.getSource()).stop();
            }).start();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> leftButtonPressed = true;
            case KeyEvent.VK_RIGHT -> rightButtonPressed = true;
            case KeyEvent.VK_SPACE -> spaceButtonPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> leftButtonPressed = false;
            case KeyEvent.VK_RIGHT -> rightButtonPressed = false;
            case KeyEvent.VK_SPACE -> spaceButtonPressed = false;
        }
    }
}
