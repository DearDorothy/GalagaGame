package model;

import model.field.Field;
import model.field.fieldObject.FieldObject;
import model.field.fieldObject.Ship;
import model.manager_ships.EnemyCommander;
import model.manager_ships.Player;

import java.util.List;

/**
 * Класс Игры. Его задача управлять самой игрой.
 * То-есть он по сути является как бы менеджером для всех классов в модели.
 * Но опять же прям менеджера делать сомнительно, так как попахивает божественным классом.
 * А это не есть хорошо. Но пыть же суть остается все та же, класс Игра мозг модели.
 * */
public class Game {

    private Player player;

    private EnemyCommander enemyCommander;

    private Field field;

    public Game(Player player, EnemyCommander enemyCommander, Field field) {
        this.player = player;
        this.enemyCommander = enemyCommander;
        this.field = field;
        startGame();
    }

    /**
     * Начать игру
     * */
    public void startGame() {
        transferShipsToCommanders();

        System.out.println("Игра успешно стартовала и исполнила все свои действия!!!!");
    }

    /**
     * Узнать кол-ов, которое нужно Игроку, кораблей
     */
    private int numberShipsPlayerHave() {
        return player.getNumberShips();
    }


    /**
     * Узнать кол-во, которое нужно Вражескому Командиру, кораблей
     */
    private int numberShipsEenemyCommanderHave() {
        return enemyCommander.getNumberShipsForPilots();
    }

    /**
     * Передать флот кораблей (Игроку/Вражескому командиру)
     */
    private void transferShipsToCommanders() {

        int numberPlayerShips = numberShipsPlayerHave();
        int numberEnemyCommanderShips = numberShipsEenemyCommanderHave();

        // Сказать полю создать соответсвующее кол-во кораблей
        List<Ship> fleetShipsPlayer = field.createShips(numberPlayerShips);
        List<Ship> fleetShipsEnemyCommander = field.createShips(numberEnemyCommanderShips);

        // Передать созданные корабли командирам
        player.setFleetShips(fleetShipsPlayer);
        enemyCommander.setFleetShipsForPilots(fleetShipsEnemyCommander);

        System.out.println("Игра успешно передала корабли командирам!!!!!");

    }

}
