package testpkg;

import java.util.List;

public class forth_dpth_frst {

    public static boolean searchPath(int[][] mz, int x, int y, List<Integer> path) {
        if (mz[x][y] == 9) { //Reached final Location
            path.add(x);
            path.add(y);
            return true;
        }

        if (mz[x][y] == 0 || mz[x][y] == 5) { // Not Visited node or Pointer Position
            mz[x][y] = 2;// Visited Node

            int dx = 1;
            int dy = 0;
            if (searchPath(mz, x + dx, y + dy, path)) {// Go down
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(mz, x + dx, y + dy, path)) {// Go right
                path.add(x);
                path.add(y);
                return true;
            }
            dx = -1;
            dy = 0;
            if (searchPath(mz, x + dx, y + dy, path)) {// Go up
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = -1;
            if (searchPath(mz, x + dx, y + dy, path)) {// Go left
                path.add(x);
                path.add(y);
                return true;
            }
        }
//        mz[y][x]=0;
        return false;
    }
}
