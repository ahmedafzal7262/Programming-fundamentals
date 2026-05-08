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

                if (salesMap.containsKey(id)) {
                    salesMap.put(prodName, salesMap.get(id) + amt);
                } else {
                    salesMap.put(id, amt);
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
