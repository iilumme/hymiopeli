package iilumme.hymiopeli.pelihahmot;

import java.awt.Graphics;

public abstract class Hahmo {

    protected int x;
    protected int y;

    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void siirra(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void piirra(Graphics g);

}


