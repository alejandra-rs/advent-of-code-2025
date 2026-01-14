# Advent of Code - 2025

Resolución de los ejercicios del Advent of Code 2025, con los fundamentos, principios y técnicas aprendidos en la asignatura de Ingeniería de Software II.

## Características generales

#### Patrones creacionales
* **Factory Method**: Creación de objetos delegada a métodos estáticos como .with() o .from(). Esto permite ocultar la complejidad del tratamiento de los datos de entrada, y oculta la real creación de los objetos.

#### Lógica estructural
* **Principio de Responsabilidad Única (SRP)**: Cada clase tiene una responsabilidad única y clara. De esta forma, se facilita el mantenimiento y la comprensión del código.
* **Alta Modularidad y Bajo Acoplamiento**: Logramos cumplir estos principios cuando las distintas responsabilidades del código funcionan de forma independiente. Gracias a este paradigma, podríamos modificar o extender una parte del sistema sin afectar al resto del código.
* **Inmutabilidad**: Todas las clases deberían no poderse modificar una vez creadas. Es crítico para la trazabilidad, es decir, para poder llevar un seguimiento del código.
* **Tell, Don't Ask**: En lugar de utilizar las clases como contenedores de información, las dotamos de todas sus funcionalidades inherentes. Esto facilita el encapsulamiento y permite abstraer correctamente el comportamiento del modelo.

#### Clean Code
* **Programación Declarativa y Funcional**: El uso de streams, clases anónimas y Fluent APIs permiten leer el código como si se tratara de una frase. Utilizando este paradigma, facilitamos la abstracción y evitamos complejidad ciclomática.
* **Good naming**: Los métodos tienen nombres autoexplicativos, facilitando la abstracción.

En cada ejercicio se indicarán ejemplos del cumplimiento de estos conceptos.

## Índice

Estos son todos los ejercicios realizados. Para cada uno de ellos, se indican qué técnicas o estrategias adicionales se han implementado.

| Día     | Título                | Documentación                   | Main                                     | Test                                     | Técnicas y Estrategias Adicionales                                                                          |
|---------|-----------------------|---------------------------------|------------------------------------------|------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| **01a** | *Secret Entrance*     | [Documentación](doc/day01-a.md) | [Main](src/main/java/software/aoc/day01) | [Test](src/test/java/software/aoc/day01) |                                                                                                             |
| **01b** | *Secret Entrance*     | [Documentación](doc/day01-b.md) | [Main](src/main/java/software/aoc/day01) | [Test](src/test/java/software/aoc/day01) | LSP, Replace Conditional With Polymorphism, inyección de dependencia.                                       |
| **02a** | *Gift Shop*           | [Documentación](doc/day02-a.md) | [Main](src/main/java/software/aoc/day02) | [Test](src/test/java/software/aoc/day02) | Encapsulación de RegEx                                                                                      |
| **02b** | *Gift Shop*           | [Documentación](doc/day02-b.md) | [Main](src/main/java/software/aoc/day02) | [Test](src/test/java/software/aoc/day02) | Encapsulación de RegEx                                                                                      |
| **03a** | *Lobby*               | [Documentación](doc/day03-a.md) | [Main](src/main/java/software/aoc/day03) | [Test](src/test/java/software/aoc/day03) |                                                                                                             |
| **03b** | *Lobby*               | [Documentación](doc/day03-b.md) | [Main](src/main/java/software/aoc/day03) | [Test](src/test/java/software/aoc/day03) | Patrón Iterator, Ocultación de información.                                                                 |
| **04a** | *Printing Department* | [Documentación](doc/day04-a.md) | [Main](src/main/java/software/aoc/day04) | [Test](src/test/java/software/aoc/day04) |                                                                                                             |
| **04b** | *Printing Department* | [Documentación](doc/day04-b.md) | [Main](src/main/java/software/aoc/day04) | [Test](src/test/java/software/aoc/day04) | Inmutabilidad y Persistencia de Estados, `Stream.iterate()`.                                                |
| **05a** | *Cafeteria*           | [Documentación](doc/day05-a.md) | [Main](src/main/java/software/aoc/day05) | [Test](src/test/java/software/aoc/day05) | Short-circuit Evaluation                                                                                    |
| **05b** | *Cafeteria*           | [Documentación](doc/day05-b.md) | [Main](src/main/java/software/aoc/day05) | [Test](src/test/java/software/aoc/day05) | Null Pattern, Reducción personalizada de streams, Fusión inmutable.                                         |
| **06a** | *Trash Compactor*     | [Documentación](doc/day06-a.md) | [Main](src/main/java/software/aoc/day06) | [Test](src/test/java/software/aoc/day06) | Patrón Iterator, LSP, Replace Conditional With Polymorphism, inyección de dependencia.                      |
| **06b** | *Trash Compactor*     | [Documentación](doc/day06-b.md) | [Main](src/main/java/software/aoc/day06) | [Test](src/test/java/software/aoc/day06) | Modularidad vía LSP                                                                                         |
| **07a** | *Laboratories*        | [Documentación](doc/day07-a.md) | [Main](src/main/java/software/aoc/day07) | [Test](src/test/java/software/aoc/day07) | Inmutabilidad en propagación, manejo de casos límite.                                                       |
| **07b** | *Laboratories*        | [Documentación](doc/day07-b.md) | [Main](src/main/java/software/aoc/day07) | [Test](src/test/java/software/aoc/day07) | Programación Dinámica.                                                                                      |
| **08a** | *Playground*          | [Documentación](doc/day08-a.md) | [Main](src/main/java/software/aoc/day08) | [Test](src/test/java/software/aoc/day08) | Inmutabilidad en fusión de circuitos.                                                                       |
| **08b** | *Playground*          | [Documentación](doc/day08-b.md) | [Main](src/main/java/software/aoc/day08) | [Test](src/test/java/software/aoc/day08) |                                                                                                             |
| **09a** | *Movie Theater*       | [Documentación](doc/day09-a.md) | [Main](src/main/java/software/aoc/day09) | [Test](src/test/java/software/aoc/day09) | Null Pattern                                                                                                |
| **09b** | *Movie Theater*       | [Documentación](doc/day09-b.md) | [Main](src/main/java/software/aoc/day09) | [Test](src/test/java/software/aoc/day09) | Patrón Memoize.                                                                                             |
| **10a** | *Factory*             | [Documentación](doc/day10-a.md) | [Main](src/main/java/software/aoc/day10) | [Test](src/test/java/software/aoc/day10) |                                                                                                             |
| **10b** | *Factory*             | [Documentación](doc/day10-b.md) | [Main](src/main/java/software/aoc/day10) | [Test](src/test/java/software/aoc/day10) | Divide y Vencerás, Patrón Memoize, Mónadas                                                                  |
| **11a** | *Reactor*             | [Documentación](doc/day11-a.md) | [Main](src/main/java/software/aoc/day11) | [Test](src/test/java/software/aoc/day11) |                                                                                                             |
| **11b** | *Reactor*             | [Documentación](doc/day11-b.md) | [Main](src/main/java/software/aoc/day11) | [Test](src/test/java/software/aoc/day11) | Patrón Memoize, inmutabilidad de estados.                                                                   |
| **12a** | *Christmas Tree*      | [Documentación](doc/day12-a.md) | [Main](src/main/java/software/aoc/day12) | [Test](src/test/java/software/aoc/day12) | Patrón Memoize, Replace Conditional With Polymorphism, inyección de dependencia, inmutabilidad de la región |