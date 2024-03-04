# Examen de prolog unidad 1
```lsp
; Ejercicio 1
(defun suma(a b)
    (+ a b)

)
(defun peticion()
    (print "ingrese un valor: ")
    (setq a (read))
    (print "ingrese otro valor: ")
    (setq b (read))
    (suma a b)
)
;ejercicio 2
(defun suma2()
    (print "ingrese un valor que sea mayor o igual a 2")
    (setq num1 (read))
    (print "ingrese otro valor que no sea mayor a 2")
    (setq num2 (read))
    (cond ((and (<= num1 2) (<= num2 2))
        (+ num1 num2))
    (t (print "uno de los 2 valores e mayor a 2, vuelve a intentarlo")
    (suma2)))
)
;ejercicio3
(defun ejercicio3()
    (setq x1 '(coche moto tren))
    (setq x2 '(eduardo pedro antonio))

    (setq concat_list (append x1 x2))
    (setq longitud (length concat_list))

    (format t "La lista concatenada es: ~a~%" concat_list)
    (format t "La longitud de la lista concatenada es: ~a~%" longitud)

    (setq elementos_finales (list (car (last x1)) (car (last x2))))
    (format t "La lista de elementos finales es: ~a~%" elementos_finales)

    (setq lista_1 (list (nth 2 x1) (nth 3 x2)))
    (setq lista_2 (list (list (nth 2 x1)) (list (nth 3 x2))))
    (setq lista_3 (list (list (nth 2 x1)) (nth 3 x2)))

    (format t "Lista 1: ~a~%" lista_1)
    (format t "Lista 2: ~a~%" lista_2)
    (format t "Lista 3: ~a~%" lista_3)
)
```
