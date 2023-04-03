package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SomeTest {

    @Test
    public void Test1()
    {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Game game = new Game();
        game.add("Cedric");
        game.roll(12);
        game.wrongAnswer();
        game.roll(2);
        game.roll(13);
        game.wasCorrectlyAnswered();
        game.roll(13);
        Approvals.verify(baos.toString());
        System.setOut(old);

    }

    @Test
    public void Test2()
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        Game game = new Game();
        game.add("Cedric");
        game.add("Eloïse");
        game.roll(1);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        Approvals.verify(baos.toString());
        System.setOut(old);
    }

    @Test
    public void Test3()
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        Game game = new Game();
        game.add("Cedric");
        game.add("Eloïse");
        game.roll(1);
        game.wrongAnswer();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        game.roll(2);
        game.wasCorrectlyAnswered();
        Approvals.verify(baos.toString());
    }
}
