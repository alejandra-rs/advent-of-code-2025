# Día 6a - *Trash Compactor*

En este día ayudamos a unos cefalópodos con sus deberes de matemáticas. Sus problemas tienen un formato distinto a los nuestros, que debemos controlar.

## Modelado conceptual

![Modelado conceptual](../images/day06.png)

## Técnicas comunes

A continuación proponemos ejemplos en este día de las técnicas y líneas prinicipales del proyecto.

### Patrones creacionales
* **Factory Method:** usado tanto en la clase CephalopodWorksheetReader (`CephalopodWorksheetReader.from(String worksheet)`) como en la clase Operator (`Operator.from(String operator)`).

### Lógica estructural
* **Principio de Responsabilidad Única (SRP):**
    * *WorksheetSolver*: Gestiona las distintas clases para obtener el resultado final.
    * *CephalopodWorksheetReader*: Transforma los datos de entrada en una serie de operaciones comprensibles por *CephalopodWorksheetReader*.
    * *Operator*: Conoce la ejecución de la operación matematica asociada a cada símbolo.
    * *Operation*: Vincula los operandos y el operador para calcular su resultado.
* **Alta Modularidad y Bajo Acoplamiento:** *WorksheetSolver* depende de la interfaz *WorksheetReader* para *entender* las matemáticas cefalópodas. Esto permite cambiar el formato de entrada sin afectar al motor de cálculo.
* **Inmutabilidad**: Todas las clases implementadas son inmutables.

### Clean Code
* **Programación declarativa y funcional**: Todos los métodos implementados hacen uso de streams y Fluent APIs, evitando complejidad ciclomática. Se destaca el uso de `StreamSupport` para convertir un iterador en un stream.
* **Good naming**: Los nombres utilizados para los métodos hacen que el código sea legible y auto-explicativo.

## Otras técnicas utilizadas
* **Tell, Don't Ask**: `WorksheetSolver` ordena al `WorksheetReader` que genere las operaciones, y ordena a `Operation` a autoejecutarse. La operación, a su vez ordena a `Operator` que aplique el operador sobre los operandos. De esta forma, ningún objeto es un puro contenedor de datos, sino que contienen su lógica conductual propia.
* **Patrón Iterator**: El uso de RowIterator permite iterar sobre los datos de entrada generando una serie de operaciones.
* **Principio de Sustitución de Liskov (LSP):** El uso de la interfaz WorksheetReader permite abstraer la forma en la que se leen las operaciones. De esta forma, se puede intercambiar de forma sencilla el lector, sin que altere el funcionamiento del resto de clases. Esto es precisamente lo que hacemos en la siguiente parte del ejercicio.
* **Replace Conditional With Polymorphism**: El uso del enumerado `Operator` permite deshacernos de condicionales en `Operation`, que verificaran el tipo de operador.
* **Inyección de dependencia**: `Operator` conoce cómo debe operar gracias a una inyección de dependencia. La función `Function<LongStream, Long>` de su campo operation indica cómo debe actuar, desacoplando la aritmética de la definición del operador.
