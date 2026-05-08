import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class IDSUMHASHMAP {
    public static void main(String[] args) {
        File f1 = new File("c:\\temp\\sale.txt");
        Scanner inp;
        String dr;
        HashMap<String, Double> salesMap = new HashMap<String, Double>();

        try {
            inp = new Scanner(f1);
            dr = inp.nextLine(); // skip header line
            String[] parts;
            String prodName;                   // holds Rep ID value
            double amt, uPrice, qty;

            while (inp.hasNextLine()) {
                dr = inp.nextLine();
                if (dr.trim().length() == 0) continue;

                parts    = dr.split("\t");
                prodName = parts[5];                      // Rep ID column
                uPrice   = Double.parseDouble(parts[2]);  // Unit Price column
                qty      = Double.parseDouble(parts[3]);  // Qty column
                amt      = uPrice * qty;

                if (salesMap.containsKey(prodName)) {
                    salesMap.put(prodName, salesMap.get(prodName) + amt);
                } else {
                    salesMap.put(prodName, amt);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("===== REP ID-WISE TOTAL SALES (HASHMAP) =====");
            for (Map.Entry<String, Double> entry : salesMap.entrySet()) {
                System.out.println(entry.getKey() + " ---> " + entry.getValue());
            }
        }
    }
}