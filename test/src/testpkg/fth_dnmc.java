package testpkg;

// import java.util.ArrayList;
// import java.util.List;
import java.util.Random;

public class fth_dnmc {

    static int r, c, sr, sc, er, ec;
    static int[][] mz;

    fth_dnmc(int l, int b, int sl, int sb, int el, int eb, int[][] ar) {
        r = l;
        c = b;
        sr = sl;
        sc = sb;
        er = el;
        ec = eb;
        mz = ar.clone();
        String[] args = null;
        main(args);
    }

    public static void main(String[] args) {
        Random rc = new Random();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {// allocating each block dynamically
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    mz[i][j] = 1;
                } else if (i == er && j == ec) {
                    mz[i][j] = 9;
                } else if (mz[i][j] == 8) {
//                    mz[i][j] = 8;
                } else {
                    if (rc.nextInt(2) == 0) {
                        mz[i][j] = 0;
                    } else {
                        mz[i][j] = 1;
                    }
                }
            }
        }
        new thrd_view(r, c, sr, sc, er, ec, mz);
    }
}
