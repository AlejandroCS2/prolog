def calcular_fibonacci(n):
    if n <= 1:
        return n
    else:
        fibo_anterior = 0
        fibo_actual = 1
        fibonacci = 0
        for i in range(2, n + 1):
            fibonacci = fibo_anterior + fibo_actual
            fibo_anterior = fibo_actual
            fibo_actual = fibonacci
        return fibonacci

if __name__ == "__main__":
    indice = 20
    fibonacci = calcular_fibonacci(indice)
    print(f"El número de Fibonacci en el índice {indice} es: {fibonacci}")
