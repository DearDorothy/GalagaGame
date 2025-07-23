package model.field;

import model.field.fieldObject.FieldObject;
import model.field.fieldObject.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Поля. По сути это контейнер объектов, которые могут на нем располагаться.
 * В моей базовой игре, это Корабли Игрока, Корабли Противника.
 * Так же стоит отметить что это класс именно модели, то есть не отвечает за отрисовку объектов на нем.
 * Данный класс в ответе за факт наличия данных объектов на нем, и так же за обработку столкновений объектов.
 * При чем как мне кажется, он даже не обрабатывает их столкновения, а просто фиксирует его.
*/
public class Field {

    private List<Ship> listShips;

    public Field() {
        listShips = new ArrayList<>();
    }

    public List<Ship> createShips(int numberShips) {
        List<Ship> fleetShips = new ArrayList<>();

        for(int currNumShip = 0; currNumShip < numberShips; currNumShip++) {
            Ship currShip = new Ship(0,0);
            fleetShips.add(currShip);
            listShips.add(currShip);
        }

        System.out.println("Успешно создали " + numberShips + " кораблей!!!!!");

        return fleetShips;
    }
}
