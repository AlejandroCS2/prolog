import java.util.Scanner;
public class palabraPolindroma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una palabra: ");
        String palabra=scanner.nextLine();

        if (esPalindroma(palabra)) {
            System.out.println(palabra + " es palíndroma.");
        } else {
            System.out.println(palabra + " no es palíndroma.");
        }

        scanner.close();
    }

    public static boolean esPalindroma(String palabra) {
        palabra = palabra.toLowerCase(); // Convertir la palabra a minúsculas para ignorar diferencias de mayúsculas
        int i = 0;
        int j = palabra.length() - 1;

        while (i < j) {
            if (palabra.charAt(i) != palabra.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}