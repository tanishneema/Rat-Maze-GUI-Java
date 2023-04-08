package testpkg;

import javax.swing.JOptionPane;

public class fst_size {

    public static void main(String[] args) {
        boolean tst = true;
        while (tst) {
            try {//Taking all values from JPanel
                int l = Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of Rows"));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Enter the Number of Columns"));
                int sl = Integer.parseInt(JOptionPane.showInputDialog("Row of START Point"));
                int sb = Integer.parseInt(JOptionPane.showInputDialog("Column of START Point"));
                int el = Integer.parseInt(JOptionPane.showInputDialog("Row of END Point"));
                int eb = Integer.parseInt(JOptionPane.showInputDialog("Column of END Point"));
                if (el > l || eb > b || sl > l || sb > b || (el == sl && eb == sb) || el < 0 || eb < 0 || sl < 0 || sb < 0) {
                    JOptionPane.showMessageDialog(null, "Please try Re-Entering it.", "Error Entering Size", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Great, we are good to go.", "Strating with Rate Maze", JOptionPane.PLAIN_MESSAGE);
                    new snd_dnmc((l + 2), (b + 2), sl, sb, el, eb);
                    tst = false;
                }
            } catch (Exception e) {
                tst=false;
            }
        }
    }
}
