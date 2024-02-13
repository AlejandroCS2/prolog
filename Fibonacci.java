import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args) {
        Scanner dato=new Scanner(System.in);
        int indice;
        System.out.println("Escribe un numero: ");
        indice=dato.nextInt();
        long fibonacci=calcularFibonacci(indice);
        System.out.println("El número de Fibonacci en el índice " +indice+ " es: " +fibonacci);
    }

    public static long calcularFibonacci(int n) {
        if (n<=1){
            return n;
        }else{
            long fiboAnterior=0;
            long fiboActual=1;
            long fibonacci=0;
            for (int i=2;i<=n;i++) {
                fibonacci=fiboAnterior+fiboActual;
                fiboAnterior=fiboActual;
                fiboActual=fibonacci;
            }
            return fibonacci;
        }
    }
}