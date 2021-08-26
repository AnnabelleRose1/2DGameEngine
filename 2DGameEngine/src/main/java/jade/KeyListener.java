package jade;

import java.security.Key;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyListener {
    private static KeyListener instance;
    private boolean keyPressed[] = new boolean[350];

    private KeyListener() {

    }

    public static KeyListener get() {
        if (KeyListener.instance == null) {
            KeyListener.instance = new KeyListener();
        }
        return KeyListener.instance;
    }

    public static void keyCallback(long window, int Key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS) {
            get().keyPressed[Key] = true;
        } else if (action == GLFW_RELEASE) {
            get().keyPressed[Key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode) {
            return get().keyPressed[keyCode];
    }
}
