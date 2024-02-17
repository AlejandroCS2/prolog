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
- append: concatena listas
```lsp
(append '(1 2 ) '(3 4))
```
- length: devuelve la longitud de la lista
```lsp
(length '(1 2 3))
```
- reverse: invierte una lista
```lsp
(reverse '(1 2 3))
```
- nth: devuelve el enésimo elemento de una lista
```lsp
(nth 1 '(1 2 3))
```
- member: comprueba si un elemento
```lsp
(member 2 '(1 2 3))
```