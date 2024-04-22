package org.max.home;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class MyGameTest {

    static List<Door> doors;

    @BeforeAll
    static void beforeAll(){doors = new ArrayList<>();}
    @BeforeEach
    void CreateDoor() {
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }
    @AfterEach
    void afterEach(){doors.clear();}

    @Test
    void gameParadox() {
        Player gamer = new Player("Игрок", false);
        Game game = new Game(gamer, doors);
        Door door = game.round(0);
        Door doors = game.round(1);
        Assertions.assertAll(
                ()->Assertions.assertTrue(door.isPrize()),
                ()->Assertions.assertFalse(doors.isPrize())
        );



    }


}



