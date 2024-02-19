# Ejercicios para aprender a usar **car** y **cdr**.
```lsp
;Primer problema
    (car (cdddr (cdddr (cdr '(a b c d e f g h))))); H
    (car (cdddr (cdddr '(a b c d e f g h)))); G
    (car (cddddr (cdr '(a b c d e f g h)))); F
    (car (cdr (cdr '(a b c d e f g h)))); C
;Segundo problema
    (car (cdr (car (cdr '((a) (b d) ((1 2) 3)))))); d
    (car (cdr (caar (cdr (cdr '((a) (b d) ((1 2) 3))))))); 2
    (caar (cddr '((a) (b d)( (1 2) 3)))); (1 2)
    (car (cdr (car (cddr '((a) (b d) ((1 2) 3))))));3
```
