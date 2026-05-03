import java.util.Scanner;

class BinaryAssignment {

    
    public static int[] toBinaryArray(int num) {
        int temp = num;
        int count = 0;

        
        while (temp > 0) {
            temp = temp / 2;
            count++;
        }

        int[] binary = new int[count];
        temp = num;

        
        for (int i = count - 1; i >= 0; i--) {
            binary[i] = temp % 2;
            temp = temp / 2;
        }

        return binary;
    }

    
    public static String toBinaryString(int num) {
        int temp = num;
        String binary = "";

        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp = temp / 2;
        }

        return binary;
    }

    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int a = keyb.nextInt();

        
        String builtIn = Integer.toBinaryString(a);
        System.out.println("\nPart (a) - Built-in Method:");
        System.out.println("Binary of " + a + " = " + builtIn);

       
        int[] arrayResult = toBinaryArray(a);
        System.out.println("\nPart (b) - Binary as Array:");
        System.out.print("Binary = ");
        for (int bit : arrayResult) {
            System.out.print(bit);
        }

        
        String stringResult = toBinaryString(a);
        System.out.println("\n\nPart (c) - Binary as String:");
        System.out.println("Binary = " + stringResult);

        keyb.close();
    }
}
