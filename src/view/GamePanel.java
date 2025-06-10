package view;

import presenter.ShipPlayerPresenter;
import model.event.ShipPlayerActionEvent;
import model.event.ShipPlayerActionListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements ShipPlayerActionListener{

    private ShipPlayerActionEvent shipPlayerActionEvent;
    private ShipPlayerPresenter shipPlayerPresenter;
    private Image imageShipPlayer;
    private Image imageBullet;

    public GamePanel(ShipPlayerPresenter shipPlayerPresenter) {
        this.shipPlayerPresenter = shipPlayerPresenter;
        setBackground(Color.BLACK);

        loadImage();

        Timer timer = new Timer(25, e -> {
            this.shipPlayerPresenter.hundleInput();
        });

        timer.start();
    }

    private void loadImage() {
        ImageIcon imageIconShipPlayer = new ImageIcon("resources/player.png");
        ImageIcon imageIconBullet = new ImageIcon("resources/bullet.png");

        this.imageShipPlayer = imageIconShipPlayer.getImage();
        this.imageBullet = imageIconBullet.getImage();
    }

    @Override
    public void shipIsMoved(ShipPlayerActionEvent event) {
        this.shipPlayerActionEvent = event;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (null == shipPlayerActionEvent) return;

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(this.imageShipPlayer,
                shipPlayerActionEvent.getShip().getX(),
                shipPlayerActionEvent.getShip().getY(),
                30, 30, this);
    }
}
