# Ejercicios para aprender a usar **car** y **cr**.
```lsp
;Primer problema
    (car (cdddr (cdddr (cdr '(a b c d e f g h))))); H
    (car (cdddr (cdddr '(a b c d e f g h)))); G
    (car (cddddr (cdr '(a b c d e f g h)))); F
    (car (cdr (cdr '(a b c d e f g h)))); C
;Segundo problema


    (caar (cddr '((a) (b d)( (1 2) 3)))); (1 2)
```
