package testpkg;

import java.util.Random;

public class snd_dnmc {

    static int r, c, sr, sc, er, ec;

    snd_dnmc(int l, int b, int sl, int sb, int el, int eb) {
        r = l;
        c = b;
        sr = sl;
        sc = sb;
        er = el;
        ec = eb;
        String[] args = null;
        main(args);
    }

    public static void main(String[] args) {
        Random rc = new Random();
        int[][] mz = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {// allocating each block dynamically
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    mz[i][j] = 1;// boundry
                } else if (i == er && j == ec) {
                    mz[i][j] = 9;// end point
                } else if (i == sr && j == sc) {
                    mz[i][j] = 5;//start point
                } else {
                    if (rc.nextInt(2) == 0) {
                        mz[i][j] = 0;//not visited node
                    } else {
                        mz[i][j] = 1;//wall
                    }
                }
            }
        }
        new thrd_view(r, c, sr, sc, er, ec, mz);
    }
}
