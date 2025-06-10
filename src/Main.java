import model.field.fieldObject.Ship;
import presenter.ShipPlayerPresenter;
import view.GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Ship ship = new Ship(180, 310);
            ShipPlayerPresenter shipPlayerPresenter = new ShipPlayerPresenter(ship);
            GamePanel gamePanel = new GamePanel(shipPlayerPresenter);

            ship.addShipPLayerListListener(gamePanel);

            JFrame frame = new JFrame("Galaga GAME");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.add(gamePanel);
            frame.addKeyListener(shipPlayerPresenter);
            frame.setVisible(true);
            frame.setFocusable(true);
            frame.requestFocusInWindow();
        });
    }
}