package rolGame;

import java.io.IOException;
import static java.lang.Thread.sleep;

public class Utilities {

    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}
    }

    public void timer(int seg) throws InterruptedException {
        int time = seg * 1000;
        sleep(time);
    }
}
