# Ejercicios con if, case, when, etc.
1.   Una tienda que vende pantalones Dickies al menudeo y al mayoreo
     tiene las siguientes tarifas, si se compran menos de 5 pantalones
     estos se cobran a su precio normal, en caso de que se copren 5 o
     mas pero menos de 12 , se les descuenta el 15% en cada pantalon, si
     se compran mas de 12 se les descuenta 30% en cada pantalon.
     Escriba un programa que pida como dato de entrada el numero de
     pantalones que se desean comprar y con ello imprima el total a
     pagar por la compra hecha.
```lsp
(defun ejercicio1()
    (setq Precio '20)
    (princ "Cuantos pantalones va a comprar: ")
    (setq cantidad (read))
    (cond ((>= 5 cantidad)
        (setq descuento1 (* precio cantidad 0.15))
        (setq desTotal1 (- precio descuento1))
        (print " El total mas el descuento de 15% es: " desTotal1))
    ((>= cantidad 12)
        (setq descuento2 (* precio cantidad 0.30))
        (setq desTotal2 (- precio descuento2))
        (print " El total mas el descuento de 30% es: " desTotal2))
      (t (print "El total sin descuento es: " * precio cantidad)))
)
```
