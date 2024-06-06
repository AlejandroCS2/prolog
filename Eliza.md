# Sistema experto médico con Eliza.
```pl
%INICIO_DE_ELIZA
eliza :-
    writeln('Hola soy eliza, soy un sistema experto medico personal.'),
    readln(Input),
    eliza(Input),!.

%CONDICION_DE_SALIDA
eliza(['adios']) :-
    writeln('Adios, espero haberte ayudado cuidate'), !.

eliza(['Adios']) :-
    writeln('Adios, espero haberte ayudado, cuidate'), !.

%LOGICA_DE_ELIZA
eliza(Input) :-
    template(Stim, Resp, IndStim),
    match(Stim, Input), %ve_si_coincide_stim_e_input
    replace0(IndStim, Input, 0, Resp, R),
    writeln(R),
    readln(Input1),
    eliza(Input1), !.

%TEMPLATES_CON_RESPUESTAS
template([hola, __], ['Hola, en que puedo ayudarte?'], []).
template([gracias, __], ['De nada, es un placer ayudarte'], []).
template([dime, como, me, puedes, ayudar, __], ['Te puedo ayudar a detectar sintomas de enfermedades, decirte a que medico puedes acudir'], []).
template([en, que, me, puedes, ayudar, __], ['Te puedo ayudar a detectar sintomas de enfermedades, decirte a que medico puedes acudir'], []).
template([que, es, lo, que, haces, __], ['Detecto sintomas de enfermedades'], []).
template([eres, doctor, __], ['No, soy un asistente que te ayuda a detectar enfermedades para que vayas al doctor '], []).
template([como, me, puedes, ayudar, __], ['Si te sientes mal y tienes sintomas de alguna enfermedad, yo lo unico que hago es orientarte para que asi tengas una idea de la enfermedad que tienes'], []).
template([me, puedes, ayudar, a, saber, que, enfermedad, tengo, __], ['Claro que si, tu nomas dime que sintomas tienes, para asi saber que enfermedad podrias tener'], []).
template([como, te, llamas, __], ['Me llamo eliza y estoy aqui para ayudarte'], []).
template([hola, como, estas, __], ['Siempre estoy bien, estoy programado para andar siempre al 100 y no enfermo como tu...'], []).
template([me, siento, mal, __], ['¿Estas enfermo, tienes algun sintoma en especifico, algun dolor?'], []).
template([estoy, enfermo, __], ['Te puedo ayudar a decirte que enfermedad tienes dependiendo de tus sintomas y recomendarte algun medico'], []).


%TEMPLATES_CON_BANDERAS
template([que, enfermedad, puedo, tener, si, tengo, s()], [flag], [6]).
template([tengo, s(_)], [flag], [1]).
template([recomiendame, un, doctor, si, tengo, _, _], [flag2], [5]).
template([me, puedes, recomendar, un, doctor, si, tengo, s(_)], [flag2], [7]).
template([que, doctor, me, recomiendas, si, tengo, s(_)], [flag2], [6]).
template([me, puedes, recomendar, un, tratamiento, si, tengo, s(_)], [flag3], [7]).
template([que, tratamiento, me, recomiendas, si, tengo, s(_)], [flag3], [6]).
template([conoces, a, s(_), _], [flag4], [2]).

%COINCIDENCIA_DE_PATRONES
match([], []).
match([], _):- true.

match([S|Stim], [I|Input]) :-
    atom(S),
    S == I,
    match(Stim, Input), !.

match([S|Stim], [_|Input]) :-
    \+ atom(S),
    match(Stim, Input), !.

%REEMPLAZO_DE_INDICES_DE_VALORES_ESPECIFICOS
replace0([], _, _, Resp, R) :- append(Resp, [], R), !.

replace0([I|Index], Input, N, Resp, R) :-
    nth0(I, Input, Atom),
    select(N, Resp, Atom, R1),
    replace0(Index, Input, N, R1, R), !.

%SINTOMAS
replace0([I|_], Input, _, Resp, R) :-
    nth0(I, Input, Atom),
    nth0(0, Resp, X),
    X == flag,
    sintoma(Atom, R).

%MEDICOS.
replace0([I|_], Input, _, Resp, R) :-
    nth0(I, Input, Atom),
    nth0(0, Resp, X),
    X == flag2,
    medico(Atom, R).

%TRATAMIENTOS
replace0([I|_], Input, _, Resp, R) :-
    nth0(I, Input, Atom),
    nth0(0, Resp, X),
    X == flag3,
    tratamiento(Atom, R).

%FAMILIARES
replace0([I|_], Input, _, Resp, R) :-
    nth0(I, Input, Atom),
    nth0(0, Resp, X),
    X == flag4,
    familiar(Atom, R).

%REGLAS_PARA_LOS_SINTOMAS
sintoma(X, R) :-
    sintomas(X),
    (
        %Pancreatitis
        X = dolor_abdominal, R = ['El dolor abdominal puede ser causado por pancreatitis'];
        X = dolor_de_espalda, R = ['El dolor de espalda puede ser causado por pancreatitis'];
        X = abdomen_sensible, R = ['La sencibilidad al tocar el abdomen puede ser causado por pancreatitis'];
        X = fiebre, R = ['La fiebre puede ser causada por pancreatitis'];
        X = pulso_acelerado, R = ['El pulso acelerado puede ser causado por pancreatitis'];
        X = malestar_estomacal, R = ['El malestar estomacal puede ser causado por pancreatitis'];
        X = vomito, R = ['El vomito puede ser causado por pancreatitis'];
        X = heces_grasosas, R = ['Las heces grasosas puede ser causado por pancreatitis'];
        X = nauceas, R = ['Las nauseas pueden ser provocadas por pancreatitis'];
        X = aumento_de_frecuencia_cardiaca, R = ['El aumento de frecuencia cardiaca puede ser caausado por pancreatitis'];
        X = perdida_de_peso_involuntaria, R = ['La perdida de peso involuntaria puede ser causado por pancreatitis'];
        X = perdida_de_apetito, R = ['La perdida de apetito puede ser causada por pancreatitis'];
        X = dificultad_para_respirar, R = ['La dificultad para respirar puede ser causado por pancreatitis'];
        X = heces_malolientes, R = ['Las heces malolientes pueden ser causadas por pancreatitis'];
        X = heces_palidas, R = ['Las heces palidas pueden ser causadas por pancreatitis'];
        X = diarrea, R = ['La diarrea puede ser causada por pancreatitis'];
        X = indigestion, R = ['La indigestion puede ser causada por pancreatitis'];
        X = hinchazon_en_el_abdomen, R = ['La inchazon en el abdomen puede ser causada por pancreatitis'];
        X = cambios_mentales, R = ['Los cambios mentales puede ser sintoma severo causada por pancreatitis'];

        %Tetanos
        X = fiebre, R = ['La fiebre es un sintoma comun del tetanos'];
        X = rigidez_muscular_en_la_mandibula, R = ['La rigidez muscular en la mandibula puede ser un sintoma del tetanos'];
        X = dificultad_para_abrir_la_boca, R = ['La dificultad para abrir la boca puede ser un sintoma del tetanos'];
        X = rigidez_del_cuello, R = ['La rigidez en el cuello puede ser un sintoma del tetanos'];
        X = rigidez_de_musculos_abdominales, R = ['La rigidez de los musculos abdominales puede ser sintoma del tetanos'];
        X = dificultad_para_tragar, R = ['La dificultad para tragar puede ser causado por el tetanos'];
        X = sudor_excesivo, R = ['la sudoracion excesiva puede ser sintoma del tetanos'];
        X = precion_arterial_alta, R = ['la precion arterial alta puede ser causada por tetanos'];
        X = frecuancia_cardiaca_alta, R = ['La frecuancia cardiaca alta puede ser causada por el tetanos'];
        X = espasmos_musculares, R = ['Los espasmos musculares pueden ser causados por el tetanos'];
        X = dificultad_para_respirar, R = ['la dificultad para respirar puede ser causada por el tetanos'];
        X = dificultad_para_hablar, R = ['la dificultad para hablar puede ser causada por el tetanos'];
        X = babeo_excesivo, R = ['el babeo excesivo puede ser un sintoma del tetanos'];
        X = dolor_de_cabeza, R = ['el dolor de cabeza puede ser un sintoma del tetanos'];
        X = irritabilidad, R = ['La la irritabilidad puede ser un sintoma del tetanos'];
        X = anciedad, R = ['La anciedad puede ser probocada por tetanos'];
        
        %Paperas
        X = hinchazon_de_las_glandulas_parotidas, R = ['la hinchazon de las glandulas parotidas puede ser causada por paperas'];
        X = dolor_al_masticar, R = ['El dolor al masticar puede ser un sintoma de las paperas'];
        X = fiebre, R = ['La fiebre puede ser un sintoma de paperas'];
        X = dolor_de_cabeza, R = ['el dolor de cabeza puede ser un sintoma causado por paperas'];
        X = fatiga, R = ['La fatiga puede ser un sintoma causado por paperas'];
        X = debilidad, R = ['La debilidad en general puede ser un sintoma causado por paperas'];
        X = perdida_de_apetito, R = ['La perdida de apetito puede ser un sintoma causado por paperas'];
        X = dolor_de_garganta, R = ['El dolor de garganta puede ser un sintoma causado por paperas'];
        X = malestar_general, R = ['El malestar general puede ser un sintoma de las paperas'];
        X = dolor_de_oidos, R = ['el dolor en los oidos puede ser causado por paperas'];
        X = dolor_abdominal, R = ['El dolor abdominal puede ser causado por paperas'];
        X = nauceas, R = ['las nauseas puede ser sintomas de las paperas'];
        X = vomito, R = ['el vomito puede ser causado por paperas'];
        X = dolor_muscular, R = ['el dolor muscular puede ser un sintoma causado por paperas'];
        X = rigidez_del_cuello, R = ['La rigidez en el cuello es un sintoma que puede ser causado por paperas'];
        X = hinchazon_en_los_testiculos, R = ['la hinchazon de testiculos es un sintoma que puede ser causado por paperas'];
        X = hinchazon_de_ovarios, R = ['la inchazon de ovarios puede ser un sintoma causado por paperas'];
        X = dolor_en_las_articulaciones, R = ['dolor en las articulaciones es un sintoma del las paperas'];
        
        R = ['puede que', X, 'sea un sintoma, solo que no esta registrado en mi base de conocimientos']
    ).

sintoma(X, R) :- \+ sintomas(X), R = ['no se sabe si', X, 'sea un sintoma de alguna enfermedad'].

%SINTOMAS
%Pancreatitis
    sintomas(dolor_abdominal).
    sintomas(dolor_de_espalda).
    sintomas(abdomen_sensible).
    sintomas(fiebre).
    sintomas(pulso_acelerado).
    sintomas(malestar_estomacal).
    sintomas(vomito).
    sintomas(heces_grasosas).
    sintomas(nauceas).
    sintomas(aumento_de_frecuencia_cardiaca).
    sintomas(perdida_de_peso_involuntaria).
    sintomas(perdida_de_apetito).
    sintomas(dificultad_para_respirar).
    sintomas(heces_malolientes).
    sintomas(heces_palidas).
    sintomas(diarrea).
    sintomas(indigestion).
    sintomas(hinchazon_en_el_abdomen).
    sintomas(cambios_mentales).
    
%Tetanos
    sintomas(rigidez_muscular_en_la_mandibula).
    sintomas(dificultad_para_abrir_la_boca).
    sintomas(dificultad_para_hablar).
    sintomas(espasmos_musculares).
    sintomas(rigidez_del_cuello).
    sintomas(rigidez_de_musculos_abdominales).
    sintomas(dificultad_para_tragar).
    sintomas(sudor_excesivo).
    sintomas(precion_arterial_alta).
    sintomas(frecuancia_cardiaca_alta).
    sintomas(babeo_excesivo).
    sintomas(dolor_de_cabeza).
    sintomas(irritabilidad).
    sintomas(anciedad).
    
%Paperas
    sintomas(hinchazon_de_las_glandulas_parotidas).
    sintomas(dolor_al_masticar).
    sintomas(dolor_de_cabeza).
    sintomas(fatiga).
    sintomas(debilidad).
    sintomas(perdida_de_apetito).
    sintomas(dolor_de_garganta).
    sintomas(malestar_general).
    sintomas(dolor_de_oidos).
    sintomas(dolor_muscular).
    sintomas(hinchazon_en_los_testiculos).
    sintomas(hinchazon_de_ovarios).
    sintomas(dolor_en_las_articulaciones).

%BASE_DE_FAMILIA
familiares('alejandroo', 'padre', 'alejandro').
familiares('sara', 'madre', 'alejandro').
familiares('arturo', 'abuelo', 'alejandro').
familiares('gloria', 'abuela', 'alejandro').
familiares('rigoberto', 'primo', 'alejandro').
familiares('danae', 'prima', 'alejandro').
familiares('beto', 'tio', 'alejandro').
familiares('alejandra', 'tia', 'alejandro').
familiares('mariana', 'hermana', 'alejandro').
familiares('alan', 'hermano', 'alejandro').
familiares('alejandro', 'hijo', 'alejandroo').
familiares('alejandro', 'hijo', 'sara').
familiares('alejandro', 'nieto', 'arturo').
familiares('alejandro', 'nieto', 'gloria').
familiares('alejandro', 'primo', 'rigoberto').
familiares('alejandro', 'primo', 'danae').
familiares('alejandro', 'sobrino', 'beto').
familiares('alejandro', 'sobrino', 'alejandra').
familiares('alejandro', 'hermano', 'mariana').
familiares('alejandro', 'hermano', 'alan').

%DEFINIMOS_MEDICOS
medico(X, R) :-
    medicos(X),
    (
        X = pancreatitis, R = ['puedes acudir a un gastroenterologo, cirujando gastrointestinales o un nutricionista'];
        X = tetanos, R = ['puedes acudir a un infectologo que se especialista en tratar enfermedades infecciosas, o un neurologo que se especialista en enfermedades del sistema nervioso.'];
        X = paperas, R = ['acude a un medico general, pediatra, infectologo, etc.'];

        R = ['Puede ser que', X, 'sea una enfermedad solo que en mi base no tengo a quien recomendarte']
    ).

medico(X, R) :- \+ medicos(X), R = ['no se si', X, 'sea una enfermedad, lo siento'].

%BASE_DE_MEDICOS
medicos(pancreatitis).
medicos(tetanos).
medicos(paperas).

%DEFINIMOS_TRATAMIENTOS
tratamiento(X, R) :-
    tratamientos(X),
    (
        X = pancreatitis, R = ['Para el tratamiento de pancreatitis, te recomendaria:

        1- sigue una dieta adecuada.
        Alimentos bajos en grasa: Evita alimentos grasos y fritos. Opta por alimentos bajos en grasa como frutas, verduras, granos enteros y proteinas magras.

        2- evita el alcohol y el tabaco
        el consumo de alcohol y tabaco puede empeorar la pancreatitis

        3- Medicamiento y tratamiento medico - Analgesia: Utiliza medicamentos para el dolor segun las indicaciones del medico.
        4- Manejo de estres y descanso adecuado - Reducir el estres: El estres puede exacerbar los sintomas de la pancreatitis. Practica tecnicas de manejo del estres como la meditacion, el yoga o la respiración profunda.
        5.- Para mayor informacion, puedes acudir a un gastroenterologo, cirujando gastrointestinales o un nutricionista'];

        X = tetanos, R = ['Para el tratamiento de tetanos, te recomendaria:
        
        1- atencion de un medico - Los medicos pueden administrar inmunoglobulina tetanica para neutralizar la toxina del tetanos..
        
        2- Manejo de sintomas - los relajantes musculares se pueden administrar para controlar los espasmpos y rigidez muscular.
        
        3- Cuidado en la UCI - los pacientes con tetanos cronico severo pueden necesitar cuidado en una unidad de cuidados intencivos (UCI) para un monitoreo constante y manejo de complicaciones.'];
        X = paperas, R = ['Para el tratamiento de paperas, te recomendaria:
        
        1- Reposo - Descansar ayuda al cuerpo a combatir la infeccion y recuperarse mas rapido.
        
        2- Hidratacion - Manten una buena hidratacion bebiendo agua, caldos y jugos. Evita bebidas acidas que pueden irritar las glandulas salivales.
        
        3- Uso de analgesicos - Usa medicamentos de venta libre como el paracetamol o el ibuprofeno para reducir el dolor y la fiebre. Evita dar aspirina a los ninios debido al riesgo de sindrome de Reye
        Para mayor informacion, acude a un medico general, pediatra, infectologo, etc.'];

        R = ['puede ser que', X, 'es una enfermedad pero no se que tratamiento darte']
    ).

tratamiento(X, R) :- \+ tratamientos(X), R = ['no se si', X, 'sea una enfermedad lo siento'].

%BASE_DE_TRATAMIENTOS
tratamientos(pancreatitis).
tratamientos(tetanos).
tratamientos(paperas).


%REGLAS_FAMILIA
familiar(X, R) :-
    familiares(X, Relacion, Y),
    (
        R = [X, 'es', Relacion, 'de', Y]
    ).

familiar(X, R) :- \+ familiares(X, _, _), R = ['No tengo informacion sobre', X].


```
Este código está escrito en Prolog y define un sistema experto llamado "Eliza", que simula ser un asistente médico personal. El sistema puede responder preguntas sobre síntomas, enfermedades, médicos, tratamientos, y también puede identificar relaciones familiares. A continuación, se describe en detalle cada parte del código:
## Definicion de templates
```pl
template([hola, __], ['Hola, en que puedo ayudarte?'], []).
template([gracias, __], ['De nada, es un placer ayudarte'], []).
...
```
**template/3** define patrones (Stim) y respuestas (Resp) con índices (IndStim) para sustituciones. La lista de templates cubre diferentes interacciones básicas con el usuario.

## Templates con banderas
```pl
template([que, enfermedad, puedo, tener, si, tengo, s()], [flag], [6]).
template([tengo, s(_)], [flag], [1]).
...
```
Estos templates usan flags (flag, flag2, etc.) para indicar respuestas que requieren lógica adicional, como identificar síntomas, recomendar médicos o tratamientos.
## Coincidencia de patrones.
```pl
match([], []).
match([], _):- true.

match([S|Stim], [I|Input]) :-
    atom(S),
    S == I,
    match(Stim, Input), !.

match([S|Stim], [_|Input]) :-
    \+ atom(S),
    match(Stim, Input), !.

```
**match/2** verifica si una lista de palabras (Stim) coincide con la entrada del usuario (Input). Las listas pueden tener átomos o variables anónimas.
## Reemplazo de indices de valores específicos.
```pl
replace0([], _, _, Resp, R) :- append(Resp, [], R), !.

replace0([I|Index], Input, N, Resp, R) :-
    nth0(I, Input, Atom),
    select(N, Resp, Atom, R1),
    replace0(Index, Input, N, R1, R), !.

```
**replace0/5** sustituye variables en la respuesta (Resp) con valores de la entrada del usuario (Input), usando los índices (Index).
## Reglas para los síntomas.
```pl
sintoma(X, R) :-
    sintomas(X),
    (
        X = dolor_abdominal, R = ['El dolor abdominal puede ser causado por pancreatitis'];
        X = dolor_de_espalda, R = ['El dolor de espalda puede ser causado por pancreatitis'];
        ...
        R = ['puede que', X, 'sea un sintoma, solo que no esta registrado en mi base de conocimientos']
    ).

sintoma(X, R) :- \not sintomas(X), R = ['no se sabe si', X, 'sea un sintoma de alguna enfermedad'].

```
**sintoma/2** identifica posibles enfermedades basadas en síntomas. Verifica si el síntoma está en la base de datos (sintomas/1) y devuelve una respuesta adecuada.
## Base de sintomas
```pl
%Pancreatitis
sintomas(dolor_abdominal).
sintomas(dolor_de_espalda).
...
```
define los síntomas asociados a diversas enfermedades, como pancreatitis, tétanos y paperas.
## Reglas para los médicos
```pl
medico(X, R) :-
    medicos(X),
    (
        X = pancreatitis, R = ['puedes acudir a un gastroenterologo, cirujando gastrointestinales o un nutricionista'];
        X = tetanos, R = ['puedes acudir a un infectologo que se especialista en tratar enfermedades infecciosas, o un neurologo que se especialista en enfermedades del sistema nervioso.'];
        ...
        R = ['Puede ser que', X, 'sea una enfermedad solo que en mi base no tengo a quien recomendarte']
    ).

medico(X, R) :- \not medicos(X), R = ['no se si', X, 'sea una enfermedad, lo siento'].
```
**medico/2** recomienda médicos basándose en la enfermedad identificada.
## Base de médicos
```pl
medicos(pancreatitis).
medicos(tetanos).
medicos(paperas).
```
Define enfermedades para las cuales el sistema puede recomendar médicos.
## Reglas para tratamientos.
```pl
tratamiento(X, R) :-
    tratamientos(X),
    (
        X = pancreatitis, R = ['Para el tratamiento de pancreatitis, te recomendaria: ...'];
        X = tetanos, R = ['Para el tratamiento de tetanos, te recomendaria: ...'];
        ...
        R = ['puede ser que', X, 'es una enfermedad pero no se que tratamiento darte']
    ).

tratamiento(X, R) :- \not tratamientos(X), R = ['no se si', X, 'sea una enfermedad lo siento'].
```
**tratamiento/2** proporciona recomendaciones de tratamiento basadas en la enfermedad.
## Base de tratamientos
```pl
tratamientos(pancreatitis).
tratamientos(tetanos).
tratamientos(paperas).
```
Define enfermedades para las cuales el sistema tiene recomendaciones de tratamiento.
## Reglas familiares.
```pl
familiar(X, R) :-
    familiares(X, Relacion, Y),
    (
        R = [X, 'es', Relacion, 'de', Y]
    ).

familiar(X, R) :- \not familiares(X, _, _), R = ['No tengo informacion sobre', X].
```
**familiar/2** identifica relaciones familiares basadas en la base de datos de familiares.
## Base de datos familiares
```pl
familiares('alejandroo', 'padre', 'alejandro').
familiares('sara', 'madre', 'alejandro').
...
```
Define relaciones familiares específicas para el sistema.

Este sistema experto utiliza patrones predefinidos y reglas lógicas para simular una conversación y proporcionar asistencia médica básica. Cada módulo tiene una función específica que se integra para ofrecer una experiencia coherente y útil para el usuario.
