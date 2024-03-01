# personajes 
```lsp
(defparameter *nodes*  '((femenino (
							(poderes (aire (Hola rayo))		
									 (fuego(Hola fuego))		
									 (tierra(Hola Tierra))		
									 (agua (poder de agua)))))
						 (masculino(
							(aire (Hola rayo))		
							(fuego(Hola fuego))		
							(tierra(Hola Tierra))		
									(agua (poder de agua))))
						 (ovni(
							   (aire (Hola rayo))		
							   (fuego(Hola fuego))		
							   (tierra(Hola Tierra))		
							   (agua (poder de agua)))
						  )
						 (aleatorio(
							   (aire (Hola rayo))		
							   (fuego(Hola fuego))		
							   (tierra(Hola Tierra))		
									(agua (poder de agua)))
						  )


						 )

  )
(defun adivina()
  (format t "Piensa en un personaje y responde a las preguntas.~%")
  (let ((current-nodes *nodes*))
    (loop
      (if (null current-nodes)
          (format t "No se encontraron más personajes.~%")
          (progn
            (format t "¿Es tu personaje femenino? (s/n): ")
            (let ((respuesta (read)))
              (cond
                ((equal respuesta 's)
                 (progn
                   (format t "Tu personaje es femenino. Aquí están sus datos:~%")
                   (dolist (atributos (cadr (assoc 'femenino *nodes*)))
                     (dolist (atributo atributos)
                       (format t "~a~%" atributo))))
                 (return))
                ((equal respuesta 'n)
                 (setq current-nodes (cdr current-nodes))
                 (if (null current-nodes)
                     (format t "No se encontraron más personajes.~%")
                     (format t "¿Es tu personaje masculino? (s/n): ")))
                (t
                 (format t "Respuesta no válida. Por favor responde 's' o 'n'.~%")
                )
              )
            )
           )
      )
    )
  )
)
```
