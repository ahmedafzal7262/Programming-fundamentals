import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class SALESHASHMAP{
    public static void main(String[] args) {
        File f1 = new File  ("c:\\temp\\SALES.txt");
        Scanner inp;
        String dr;
        HashMap<String,Double> hm = new HashMap<>();
        try {
            inp = new  Scanner(f1);
            dr = inp.nextLine();
            System.out.println(dr);
            String[] parts;

            String prodName;
            double amt,uPrice,qty;

            while(dr.length()>0){
                 dr=inp.nextLine();
                 System.out.println(dr);
                 parts= dr.split("\t");
                 prodName=  parts[1];
                 qty=Double.parseDouble(parts[3]);
                 uPrice=Double.parseDouble(parts[2]);
                 amt=qty* uPrice;
                 if(hm.containsKey(prodName)){
                    double preAmt = hm.get(prodName);
                    amt+=preAmt;
                    hm.put(prodName,amt);
                 }
                 else{
                    hm.put(prodName,amt);
                 }
            } 
    
        } 
        catch (Exception e) {
            System.out.println("----------------");
        }
        finally{
            for(Map.Entry<String,Double> me: hm.entrySet()){
                
                   System.out.println(me.getKey()+"---"+ me.getValue());

            }
      
          }
      }
    }