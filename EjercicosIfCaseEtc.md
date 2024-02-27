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
    (cond ((and (>= cantidad 5) (< cantidad 12))
        (setq descuento1 (* precio cantidad 0.85))
        (setq desTotal1 (- descuento1 precio))
        (print " El total mas el descuento de 15% es: ")
        (print desTotal1))
    ((>= cantidad 12)
        (setq descuento2 (* precio cantidad 0.7))
        (setq desTotal2 (- descuento2 precio))
        (print " El total mas el descuento de 30% es: ")
        (print desTotal2))
    (t (setq total (* precio cantidad))
        (print "El total sin descuento es: ")
        (print total)))
)
```
2.   Escriba un programa para determinar si un solicitante puede lograr
     un préstamo. Deberá pedir los siguientes datos para cada
     solicitante: Nombre, historia crediticia(‘b’buena o ‘m’ mala),
     cantidad pedida, salario anual, y valor de otras propiedades.  El
     banco solo considerará a los solicitantes con un estado de crédito
     bueno.  De aquellos, solo aceptara los que tengan mas de 6 puntos.
     Los puntos se obtienen como sigue: 5 puntos si el salario es 50%
     del préstamo o más.  3 puntos si el salario es por lo menos 25%
     pero menos de 50% del préstamo.  1 punto si el salario es por lo
     menos 10% pero menos de 25% del préstamo.  5 puntos si se tiene
     otra propiedad del doble del préstamo o mas.  3 puntos si se tiene
     otra propiedad igual al préstamo pero menor del doble.
```lsp
(defun calcular-puntos (salario-anual cantidad-pedida valor-propiedades)
  (let ((puntos 0)
        (porcentaje-salario (/ salario-anual cantidad-pedida))
        (propiedades-multiplo (>= valor-propiedades (* 2 cantidad-pedida)))
        (propiedades-igual (and (<= valor-propiedades (* 2 cantidad-pedida))
                                 (> valor-propiedades cantidad-pedida))))
    (when (>= porcentaje-salario 0.5) (setq puntos (+ puntos 5)))
    (when (and (>= porcentaje-salario 0.25) (< porcentaje-salario 0.5)) (setq puntos (+ puntos 3)))
    (when (and (>= porcentaje-salario 0.1) (< porcentaje-salario 0.25)) (setq puntos (+ puntos 1)))
    (when propiedades-multiplo (setq puntos (+ puntos 5)))
    (when propiedades-igual (setq puntos (+ puntos 3)))
    puntos))

(defun puede-lograr-prestamo (nombre historia-crediticia cantidad-pedida salario-anual valor-propiedades)
  (cond ((char= historia-crediticia #\b) ; Buena historia crediticia
         (let ((puntos (calcular-puntos salario-anual cantidad-pedida valor-propiedades)))
           (if (> puntos 6)
               (format t "El solicitante ~a puede lograr el prestamo." nombre)
               (format t "El solicitante ~a no puede lograr el prestamo." nombre))))
        (t (format t "El solicitante ~a no puede lograr el prestamo debido a su historia crediticia mala." nombre))))

(defun main ()
  (format t "Ingrese el nombre del solicitante: ")
  (setq nombre (read-line))
  (format t "Ingrese la historia crediticia (b para buena, m para mala): ")
  (setq historia-crediticia (read-char))
  (format t "Ingrese la cantidad pedida: ")
  (setq cantidad-pedida (read))
  (format t "Ingrese el salario anual: ")
  (setq salario-anual (read))
  (format t "Ingrese el valor de otras propiedades: ")
  (setq valor-propiedades (read))
  (puede-lograr-prestamo nombre historia-crediticia cantidad-pedida salario-anual valor-propiedades))

(main)
```
