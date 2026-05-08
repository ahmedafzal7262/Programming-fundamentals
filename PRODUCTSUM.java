import java.io.File;
import java.util.Scanner;

class PRODCUTSUM {
    public static void main(String[] args) {
        File f1 = new File("c:/temp/sale.txt");
        Scanner inp;
        String dr;
        String[] prodNames = new String[300];
        double[] amounts = new double[300];
        int cot = 0;

        try {
            inp = new Scanner(f1);
            dr=inp.nextLine();
            dr = inp.nextLine(); 
            String[] parts;
            String prodName;
            double amt, uPrice, qty;

            while (dr.length()>0) {
                dr = inp.nextLine();
                 

                parts  = dr.split("\t");
                prodName = parts[1];                        // Product column
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
            System.out.println("===== PRODUCT-WISE TOTAL SALES =====");
            for (int i = 0; i < cot; i++) {
                System.out.println(prodNames[i] + " ---> " + amounts[i]);
            }
        }
    }
}




