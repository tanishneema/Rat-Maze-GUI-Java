package testpkg;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class thrd_view extends JFrame {

    /**
     * Conventions:
     *
     * maze[row][col]
     *
     * Values: 0 = not-visited node 1 = wall (blocked) 2 = visited node 9 =
     * target node
     */
    static int r, c, sr, sc, er, ec;
    static int[][] mz, tm;
    private final List<Integer> path = new ArrayList<Integer>();
    private int pi;

    thrd_view(int l, int b, int sl, int sb, int el, int eb, int[][] ar) {
        r = l;
        c = b;
        sr = sl;
        sc = sb;
        er = el;
        ec = eb;
        mz = ar.clone();
        tm = ar;
        mz[sr][sc] = 5;
        String[] args = null;
        main(args);
    }

    public thrd_view() {
        setTitle("Maze Solver");
        setSize((c * 40) + 18, (r + 1) * 40);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forth_dpth_frst.searchPath(mz, sr, sc, path);
        pi = path.size() - 2;

        // new Timer().schedule(new TimerTask() { //for auto run
        // @Override
        // public void run() {
        // update();
        // repaint();
        // }
        // }, 100, 500);
        // }//This is new function
        // public void update() {
        // if (pi < 0) {
        // pi = 0;
        // }
        // }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(8, 30);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Color color;
                switch (mz[i][j]) {
                    case 1:
                        color = Color.BLACK;
                    case 6:
                        color = Color.GREEN;
                    case 9:
                        color = Color.RED;
                    case 8:
                        color = Color.PINK;
                    default:
                        color = Color.WHITE;
                }
                ; // draw the maze
                g.setColor(color);
                g.fillRect(40 * j, 40 * i, 40, 40);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(40 * j, 40 * i, 40, 40);
            }
        }
        g.setColor(Color.gray);
        g.fillOval(sc * 40, sr * 40, 40, 40);
        mz[sr][sc] = 8;

        if (path.isEmpty()) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {

            }
            dispose();
            new fth_dnmc(r, c, sr, sc, er, ec, mz);
        } else {
            for (int i = 0; i < path.size(); i += 2) {// draw the path list
                int pX = path.get(i);
                int pY = path.get(i + 1);
                g.setColor(Color.GREEN);
                g.fillRect(pY * 40, pX * 40, 40, 40);
            }
        }
        // draw the ball on path
        if (path.size() > 0) {
            int pX = path.get(pi);
            int pY = path.get(pi + 1);
            g.setColor(Color.gray);
            g.fillOval(pY * 40, pX * 40, 40, 40);
            mz[pX][pY] = 8;

        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect(40 * j, 40 * i, 40, 40);
            }
        }
    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            pi -= 2;
            if (pi < 0 || pi == 0) {
                pi = 0;
            } else {
                int pX = path.get(pi);
                int pY = path.get(pi + 1);
                mz[pX][pY] = 5;
                dispose();
                new fth_dnmc(r, c, pX, pY, er, ec, mz);
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                thrd_view view = new thrd_view();
                view.setVisible(true);
            }
        });
    }
}
