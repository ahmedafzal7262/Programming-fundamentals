import java.io.File;
import java.util.Scanner;

class SALESFILEHANDLING {
    public static void main(String[] args) {
        File f1 = new File("c:\\temp\\SALES.txt");
        Scanner inp;
        String dr;

        String[] prodNames = new String[100];
        double[] amounts = new double[100];
        int cot = 0;

        try {
            inp = new Scanner(f1);
            dr = inp.nextLine();
            System.out.println(dr);
            String[] parts;

            String prodName;
            double amt, uPrice, qty;

            while (dr.length() > 0) {
                dr = inp.nextLine();
                System.out.println(dr);
                parts = dr.split("\t");
                prodName = parts[1];
                qty = Double.parseDouble(parts[3]);
                uPrice = Double.parseDouble(parts[2]);
                amt = qty * uPrice;

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
                    amounts[cot] = amt;
                    cot++;
                }
            }

        } catch (Exception e) {
            System.out.println("----------------");
        } finally {
            for (int i = 0; i < cot; i++) {
                System.out.println(prodNames[i] + "---" + amounts[i]);
            }
        }
    }
}