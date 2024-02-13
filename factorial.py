def calcular_factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * calcular_factorial(n - 1)

if __name__ == "__main__":
    numero = 10
    factorial = calcular_factorial(numero)
    print(f"El factorial de {numero} es: {factorial}")
