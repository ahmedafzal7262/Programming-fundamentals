import java.util.Scanner;
class ONLINE2{

    public static void main(String[]args) {
        Scanner keyb = new Scanner(System.in);
        int rows = 3;
        int cols = 3;
        double[][] matrix =new double [rows][cols];
        System.out.println("enter 9 values:");
        
        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                matrix[i][j] = keyb.nextDouble();
            }
        }
        
        for(int i=0; i<rows; i++){
            double sum= 0;
            for(int j=0; j<cols; j++){
                sum+= matrix[i][j];
            }
            System.out.println("row"+ (i+1) + "sum=" + sum);
        }
        
        for (int j=0; j<cols; j++){
            double sum=0;
            for(int i=0; i<rows; i++){
                sum+= matrix[i][j];
            }
            System.out.println("column"+(j+1) + "sum=" + sum);
        }
        
        double main =0;
        for(int i=0; i<rows; i++){
            main+= matrix[i][i];
        }
        System.out.println("daignol=" + main);
        
        
        double rev =0;
        for(int i=0; i<rows; i++){

            rev += matrix[i][cols - i - 1]; 
        }
        System.out.println("reverse diagnol =" + rev);
    }
}