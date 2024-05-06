#20 Templates en Prolog.
```prolog
eliza:-	writeln('Hola , mi nombre es  Eliza tu  chatbot,
	por favor ingresa tu consulta,
	usar solo minÃºsculas sin . al final:'),
	readln(Input),
	eliza(Input),!.
eliza(Input):- Input == ['Adios'],
	writeln('Adios. espero poder verte ayudado.'), !.
eliza(Input):- Input == ['Adios', '.'],
	writeln('Adios. espero poder verte ayudado.'), !.
eliza(Input) :-
	template(Stim, Resp, IndStim),
	match(Stim, Input),
	% si he llegado aquÃ­ es que he
	% hallado el template correcto:
	replace0(IndStim, Input, 0, Resp, R),
	writeln(R),
	readln(Input1),
	eliza(Input1), !.

template([eliza, quien, es, el, hijo, de, s(_)], [flagfam],[6]).
template(_, ['Please', explain, a, little, more, '.'], []).
% Template para identificar el padre de una persona
template([eliza, quien, es, el, padre, de, s(_)], [flagfam],[6]).
% Template para solicitar más detalles cuando no se entiende la pregunta
template(_, ['Could', you, please, provide, more, details, '?'], []).
% Template para preguntar sobre la edad de una persona
template([eliza, cuanto, años, tiene, s(_)], ['I', am, sorry, but, I, cannot, provide, personal, information], [4]).
% Template para preguntar por el significado de una palabra
template([eliza, que, significa, s(_)], ['I', am, sorry, but, I, am, unable, to, provide, definitions], [3]).
% Template para preguntar por una ubicación específica
template([eliza, donde, está, s(_)], ['I', am, not, able, to, provide, location, information], [4]).
% Template para responder a preguntas genéricas sobre Eliza
template([quien, eres, tú], ['I', am, Eliza, your, chatbot, assistant], []).
% Template para solicitar más información sobre un tema
template([podrías, explicar, más, sobre, s(_)], ['Please', provide, more, details, about, the, topic], [4]).
% Template para preguntar por recomendaciones
template([tienes, alguna, recomendación, sobre, s(_)], ['I', do, not, have, specific, recommendations], [4]).
% Template para preguntar por una fecha específica
template([eliza, que, ocurrió, en, s(_)], ['I', am, not, able, to, provide, historical, information], [4]).
% Template para responder preguntas de sí o no
template([eliza, es, s(_)], ['I', cannot, answer, yes, or, no, questions], [2]).
% Template para solicitar repetir la pregunta
template([podrías, repetir, la, pregunta], ['Could', you, please, repeat, the, question], []).
% Template para preguntar por la hora actual
template([eliza, que, hora, es], ['I', am, not, able, to, provide, the, current, time], []).
% Template para preguntar por una película o libro
template([has, visto, la, película, s(_)],[no, la, he, visto], [5]).
% Template para preguntar por el clima
template([eliza, cómo, está, el, clima, hoy], ['I', am, not, able, to, provide, current, weather, information], []).
% Template para preguntar por un evento futuro
template([eliza, qué, va, a, pasar, en, s(_)], ['I', am, not, able, to, predict, future, events], [6]).
% Template para responder a una declaración genérica
template([eliza, s(_)], ['Could', you, please, elaborate, further], [1]).
% Template para preguntar por una comida o receta
template([has, probado, la, comida, s(_)],[no, la, he, probado], [5]).
% Template para preguntar por un pasatiempo o actividad
template([te, gusta, s(_)], ['I', do, not, have, preferences], [3]).
% Template para preguntar por una enfermedad o síntoma
template([eliza, qué, pasa, si, s(_)], ['I', am, not, able, to, provide, medical, advice], [5]).
% Template para responder a una pregunta sobre emociones
template([cómo, te, sientes], ['I', am, an, AI, and, do, not, experience, feelings], []).
padre(juan, luis).		 
padre(juan, antonio).
padre(luis, carlos). 
familia(X,R) :- padre(X,Y), R=["El  hijo de ", X, "es", Y].		 
		 
match([],[]).
match([], _):- true.

match([S|Stim],[I|Input]) :-
	atom(S), % si I es un s(X) devuelve falso
	S == I,
	match(Stim, Input),!.

match([S|Stim],[_|Input]) :-
% I es un s(X), lo ignoro y continÃºo con el resto de la lista
	\+atom(S),
	match(Stim, Input),!.

replace0([], _, _, Resp, R):- append(Resp, [], R),!.

replace0([I|_], Input, _, Resp, R):-
	nth0(I, Input, Atom),
	nth0(0, Resp, X),
	X == flagfam,
	familia(Atom, R).
		 
		 
replace0([I|Index], Input, N, Resp, R):-
	length(Index, M), M =:= 0,
	nth0(I, Input, Atom),
	select(N, Resp, Atom, R1), append(R1, [], R),!.

replace0([I|Index], Input, N, Resp, R):-
	nth0(I, Input, Atom),
	length(Index, M), M > 0,
	select(N, Resp, Atom, R1),
	N1 is N + 1,
	replace0(Index, Input, N1, R1, R),!.
```
