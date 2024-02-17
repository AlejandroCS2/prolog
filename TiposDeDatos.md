# Tipos de datos  
En esta practica se abordarán 3 códigos en 6 diferentes tipos de lenguajes de programación que son:  
- Java
- Python
- C
- Perl
- Go
- Rust

Conciste en crear un programa (por cada lenguage) donde calculamos un factorial, la pocisión de un número de fibonacci y si una palabra es palíndroma.
## Calcular el factorial de un número
### Código en java:
```java
import java.util.Scanner;
public class factorial {
    public static void main(String[] args) {
        
        Scanner dato = new Scanner(System.in);
        System.out.println("Escribe el numero para calcular el factorial: ");
        int numero=dato.nextInt();
        long factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
    public static long calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }
}
```
**Tipo de dato que maneja el lenguaje:** El lenguaje Java maneja tipos de datos primitivos como int, long, boolean, etc. así como tipos de datos de referencia como String, Scanner, etc. En este código, se utiliza principalmente tipos de datos primitivos (int y long) y un tipo de dato de referencia (Scanner).  
**La diciplina de tipos:** Java es un lenguaje de programación fuertemente tipado, lo que significa que los tipos de datos de todas las variables deben ser declarados explícitamente y deben coincidir con el tipo de dato esperado en todas las operaciones. Además, Java es un lenguaje de programación estáticamente tipado, lo que significa que los tipos de datos de las variables se verifican en tiempo de compilación.  
**Paradigma de lenguaje utilizado:** En este código se utiliza clases y métodos estáticos, lo que indica un enfoque orientado a objetos.  
**La estructura que lleva las funciones o métodos:** En Java, las funciones o métodos se definen dentro de clases. En este código, se tiene una clase llamada factorial que contiene un método main y un método calcularFactorial. El método main es el punto de entrada de la aplicación Java, mientras que el método calcularFactorial es un método estático que realiza el cálculo del factorial de un número dado. El método calcularFactorial utiliza recursión para calcular el factorial.  
### Código en Python
```python
def calcular_factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * calcular_factorial(n - 1)

if __name__ == "__main__":
    numero = 10
    factorial = calcular_factorial(numero)
    print(f"El factorial de {numero} es: {factorial}")
```
**Tipo de dato que maneja el lenguaje:** Python es un lenguaje de programación dinámicamente tipado, lo que significa que no es necesario declarar el tipo de datos de una variable antes de usarla. El tipo de datos de una variable es inferido en tiempo de ejecución.  
**La diciplina de tipos:** Python es un lenguaje de programación dinámicamente tipado, lo que significa que no es necesario declarar el tipo de datos de una variable antes de usarla.    
**Paradigma de lenguaje utilizado:** Python es un lenguaje de programación multiparadigma que soporta programación imperativa, funcional y orientada a objetos. En este código, se utiliza principalmente un enfoque funcional para calcular el factorial recursivamente.  
**La estructura que lleva las funciones o métodos:**  En Python, las funciones se definen utilizando la palabra clave def. En este código, la función calcular_factorial es una función que toma un argumento n y devuelve el factorial de n. La expresión if __name__ == "__main__": se utiliza para comprobar si el script se está ejecutando directamente como un programa principal, y en ese caso, se ejecuta el bloque de código debajo, que calcula el factorial de un número dado e imprime el resultado.  
### Código en C.
```C
#include <stdio.h>

long long calcularFactorial(int n);

int main() {
    int numero;
    printf("Escribe el número para calcular el factorial: ");
    scanf("%d", &numero);

    long long factorial = calcularFactorial(numero);
    printf("El factorial de %d es: %lld\n", numero, factorial);

    return 0;
}

long long calcularFactorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * calcularFactorial(n - 1);
    }
}
```
**Tipo de dato que maneja el lenguaje:** C es un lenguaje de programación que maneja principalmente tipos de datos primitivos, como int, long long, float, double, etc. En este código, se utilizan principalmente tipos de datos enteros (int) y un tipo de dato entero de mayor tamaño (long long) para manejar números grandes.    
**La diciplina de tipos:** C es un lenguaje de programación estáticamente tipado, lo que significa que los tipos de datos de todas las variables deben ser declarados antes de su uso y deben coincidir con el tipo de datos esperado en todas las operaciones. Además, C es un lenguaje de programación débilmente tipado en ciertos aspectos, lo que permite realizar conversiones automáticas entre tipos de datos.      
**Paradigma de lenguaje utilizado:** C es un lenguaje de programación imperativo, lo que significa que se centra en describir cómo se debe realizar una tarea mediante la especificación de una secuencia de instrucciones. En este código, se sigue el paradigma imperativo para calcular el factorial utilizando una función recursiva.   
**La estructura que lleva las funciones o métodos:**  En C, las funciones se definen utilizando la palabra clave int o void seguida del nombre de la función y su lista de parámetros entre paréntesis. En este código, se define la función calcularFactorial que toma un argumento n y devuelve un valor de tipo long long. La función main es el punto de entrada del programa y ejecuta la lógica principal del programa, llamando a la función calcularFactorial para calcular el factorial de un número dado y luego imprime el resultado.  