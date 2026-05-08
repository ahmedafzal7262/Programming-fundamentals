import java.io.File;
import java.util.Scanner;

class IDSUM {
    public static void main(String[] args) {
        File f1 = new File("c:\\temp\\sale.txt");
        Scanner inp;
        String dr;
        String[] prodNames = new String[300];  
        double[] amounts = new double[300];
        int cot = 0;

        try {
            inp = new Scanner(f1);
            dr = inp.nextLine();
            String[] parts;
            String id;                   
            double amt, uPrice, qty;

            while (inp.hasNextLine()) {
                dr = inp.nextLine();
                if (dr.trim().length() == 0) continue;

                parts    = dr.split("\t");
                id = parts[5];                        
                uPrice   = Double.parseDouble(parts[2]);    
                qty      = Double.parseDouble(parts[3]);   
                amt      = uPrice * qty;

                boolean found = false;
                for (int i = 0; i < cot; i++) {
                    if (id[i].equals(id)) {
                        amounts[i] += amt;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    id[cot] = id;
                    amounts[cot]   = amt;
                    cot++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("===== REP ID-WISE TOTAL SALES =====");
            for (int i = 0; i < cot; i++) {
                System.out.println(id[i] + " ---> " + amounts[i]);
            }
        }
    }
}
