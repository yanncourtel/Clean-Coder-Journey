package formtemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloWorldShould {

    @Test public void
    sayHiToJack() {
        var helloWorld = new HelloWorld();

        Assertions.assertEquals("Hi Jack", helloWorld.SayHi("Jack"));
    }
}
