# personajes 
```lsp
(defparameter *jugadores* '((femenino
                               (jugadoras
                                (diana-taurasi (Descripcion
                                                (ella "Hola rayo")))
                                (sue-bird (Descripcion
                                                (ella "Hola rayo")))
                                (Maya-Moore (Descripcion
                                                (ella "Hola rayo")))
                                (Tamika-Catchings (Descripcion
                                                (ella "Hola rayo")))
                                (Lisa-Leslie (Descripcion
                                                (ella "Hola rayo")))
                                (Sheryl-Swoopes (Descripcion
                                                (ella "Hola rayo")))
                                (Tina-Thompson (Descripcion
                                                (ella "Hola rayo")))
                                (Candace-Parker (Descripcion
                                                (ella "Hola rayo")))
                                (Breanna-Stewart (Descripcion
                                                (ella "Hola rayo")))
                                ;; Agrega más jugadoras aquí
                               )
                               )
                              (masculino
                               (jugadores
                               (estados-unidos
                                (michael-jordan (Descripcion
                                                (el "Hola rayo")))
                                (lebron-james (Descripcion
                                                (el "Hola rayo")))
                                (Kobe-Bryant (Descripcion
                                                (el "Hola rayo")))
                                (Shaniquille-O'Neal (Descripcion
                                                (el "Hola rayo")))
                                (Magic-Johnson (Descripcion
                                                (el "Hola rayo")))
                                (Larry-Bird (Descripcion
                                                (el "Hola rayo")))
                                (Tim-Duncan (Descripcion
                                                (el "Hola rayo")))
                                (Kareem-Abdul-Jabbar (Descripcion
                                                (el "Hola rayo")))
                                )
                                (nigeria
                                  (Hakeem-Olajuwon (Descripcion
                                                (el "Hola rayo"))) 
                                )
                                (alemania
                                  (Dirk-Nowitzki (Descripcion
                                                (el "Hola rayo")))
                                )
                              )
                            )
                          )
)
(defun adivinador()
    (print "piensa en un jugador/a de basketball")
    (print "tu personaje es Masculino o femenino? (m/f): ")
    (setq respuesta (read-char))
    (cond ( (char= respuesta #\f)
                (car(cdr (assoc 'femenino *jugadores*))))
            ((char= respuesta #\m)
                (car(cdr (assoc 'masculino *jugadores*))))
            (t (print "ingrese una letra valida"))
    ) 
)
```
