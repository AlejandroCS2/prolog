# 20 funciones de clisp
- ***Suma***: hace una suma.
```lsp
(+ 3 4)
```
- ***Resta***: hace una resta.
```lsp
(- 3 4)
```
- ***Multiplicación***: hace una multiplicación.
```lsp
(* 3 4)
```
- ***Divición***: hace una divición.
```lsp
(/ 3 4)
```
- ***setq***: Asigna un valor a una variable.
```lsp
(setq x 10)
```
- ***List***: Crea una lista.
```lsp
(setq x 10)
```
- ***Car***: devuelve el primer valor de una lista.
```lsp
(car '(1 2 3))
```
- ***cdr***: devuelve la lista sin el primer elemento.
```lsp
(cdr '(1 2 3))
```
- ***cons***: añade un elemento al principio de una lista.
```lsp
(cons 0 '(1 2 3))
```
- ***append***: concatena listas.
```lsp
(append '(1 2 ) '(3 4))
```
- ***length***: devuelve la longitud de la lista.
```lsp
(length '(1 2 3))
```
- ***reverse***: invierte una lista.
```lsp
(reverse '(1 2 3))
```
- ***nth***: devuelve el enésimo elemento de una lista.
```lsp
(nth 1 '(1 2 3))
```
- ***member***: comprueba si un elemento.
```lsp
(member 2 '(1 2 3))
```
- ***remove***: Elimina todas las ocurrencias de un elemento de una lista.
```lsp
(remove 2 '(1 2 3 2))
```
- ***mapcar***: Aplica una funcion a cada elemento de una lista y devuelve una lista de resultados.
```lsp
(mapcar #'(lambda (x) (* x x)) '(1 2 3))
```
- ***sort***: ordena una lista.
```lsp
(sort '(3 1 2) #'<)
```
- ***format***: Imprime texto con formato
```lsp
(format t "Hola, ~a" "mundo")
```
- ***read***: lee una expresión de la entrada estandar y la evalúa.
```lsp
(read);Si escribes 5 en la entrada estándar, evaluará a 5.
```
- ***eval***: evalúa la expreción.
```lsp
(eval '(+ 2 3))
```
Estas son algunas funciones básicas en CLISP, aún hay más de donde salieron estas funciones.
