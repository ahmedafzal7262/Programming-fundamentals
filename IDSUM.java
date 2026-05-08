import java.io.File;
import java.util.Scanner;

class IDSUM {
    public static void main(String[] args) {
        File f1 = new File("c:\\temp\\sale.txt");
        Scanner inp;
        String dr;
        String[] prodNames = new String[300];   // stores Rep IDs
        double[] amounts = new double[300];
        int cot = 0;

        try {
            inp = new Scanner(f1);
            dr = inp.nextLine(); // skip header line
            String[] parts;
            String prodName;                    // holds Rep ID value
            double amt, uPrice, qty;

            while (inp.hasNextLine()) {
                dr = inp.nextLine();
                if (dr.trim().length() == 0) continue;

                parts    = dr.split("\t");
                prodName = parts[5];                        // Rep ID column
                uPrice   = Double.parseDouble(parts[2]);    // Unit Price column
                qty      = Double.parseDouble(parts[3]);    // Qty column
                amt      = uPrice * qty;

                boolean found = false;
                for (int i = 0; i < cot; i++) {
                    if (prodNames[i].equals(prodName)) {
                        amounts[i] += amt;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    prodNames[cot] = prodName;
                    amounts[cot]   = amt;
                    cot++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("===== REP ID-WISE TOTAL SALES =====");
            for (int i = 0; i < cot; i++) {
                System.out.println(prodNames[i] + " ---> " + amounts[i]);
            }
        }
    }
}