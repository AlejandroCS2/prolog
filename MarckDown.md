# 20 funciones de clisp
- Suma:
```lsp
(+ 3 4)
```
- Resta:
```lsp
(- 3 4)
```
- Multiplicación:
```lsp
(* 3 4)
```
- Divición:
```lsp
(/ 3 4)
```
- Setq: Asigna un valor a una variable
```lsp
(setq x 10)
```
- List: Crea una lista
```lsp
(setq x 10)
```
- Car: devuelve el primer valor de una lista
```lsp
(car '(1 2 3))
```
- cdr: devuelve la lista sin el primer elemento
```lsp
(cdr '(1 2 3))
```
- cons: añade un elemento al principio de una lista
```lsp
(cons 0 '(1 2 3))
```

#Cálculo de 10 areas

```lsp
(defun cuadrado()
    (princ "Dame el lado: ")
    (setq num1 (read))
    (setq resultado (expt num1 2 ))
    (write resultado)
)
(defun rectangulo()
    (princ "Dame la base: ")
    (setq num1 (read))
    (princ "Dame la altura: ")
    (setq num2 (read))
    (setq resultado (* num1 num2 ))
    (write resultado)
)
(defun triangulo()
    (princ "Dame la base: ")
    (setq num1 (read))
    (princ "Dame la altura: ")
    (setq num2 (read))
    (setq resultado (/ ( * num1 num2 ) 2 ))
    (write resultado)
)
(defun circulo()
    (princ "Dame el radio: ")
    (setq num1 (read))
    (setq resultado (* pi (* num1 num1 )))
    (write resultado)
)
(defun trapecio()
    (princ "Dame la base 1: ")
    (setq num1 (read))
    (princ "Dame la base 2: ")
    (setq num2 (read))
    (princ "Dame la altura: ")
    (setq num3 (read))
    (setq resultado (/ (* (+ num1 num2) num3) 2))
    (write resultado)
)
(defun rombo()
    (princ "Dame la diagonal 1: ")
    (setq num1 (read))
    (princ "Dame la diagonal 2: ")
    (setq num2 (read))
    (setq resultado (* num1 num2 0.5))
    (write resultado)
)
```
