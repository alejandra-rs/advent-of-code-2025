# Día 7a - *Laboratories*

Simulación de la propagación de un láser. El haz se desplaza verticalmente, pero puede dividirse y propagarse horizontalmente al interactuar con *splitters*.

## Modelado conceptual

![Modelado conceptual](../images/day07.png)

## Técnicas comunes

A continuación proponemos ejemplos en este día de las técnicas y líneas prinicipales del proyecto.

### Patrones creacionales
* **Factory Method:** usado en las clases TachyonManifold (`TachyonManifold.from(String grid)`), TachyonGrid (`TachyonGrid.from(String grid)`) y TachyonCell (`TachyonCell.from(int val)`).

### Lógica estructural
* **Principio de Responsabilidad Única (SRP):**
    * *TachyonManifold*: Contiene la lógica de propagación de los láseres por las celdas.
    * *TachyonGrid*: Conoce la estructura y las dimensiones del mapa.
    * *TachyonCell*: Mantiene la información relacionada a una celda específica del mapa.
* **Alta Modularidad y Bajo Acoplamiento:** `TachyonManifold` y `TachyonGrid` son completamente independientes. Por tanto, `TachyonGrid` no necesita saber cómo se implementa el contenedor de datos para saber cómo se propaga el láser.
* **Inmutabilidad**: Todas las clases implementadas son inmutables.

### Clean Code
* **Programación declarativa y funcional**: Todos los métodos implementados hacen uso de streams y Fluent APIs, evitando complejidad ciclomática. También se usa recursión, pues *el estado de una fila depende de como se haya propagado en la fila anterior*. Esto facilita la abstracción.
* **Good naming**: Los nombres utilizados para los métodos hacen que el código sea legible y auto-explicativo.

## Otras técnicas utilizadas
* **Tell, Don't Ask**: TachyonManifold no extrae la matriz de celdas para operar. En su lugar, le pide a la rejilla la celda en una posición (`grid.at(row, col)`).
* **Inmutabilidad en la propagación**: La propagación del láser sobre las distintas filas se realiza creando nuevas filas, manteniendo la inmutabilidad y trazabilidad del código.
* **Casos límite**: En caso de llegar al límite del mapa, `TachyonGrid` devuelve *EMPTY*. Esto permite evitar comprobaciones adicionales, simplificando los métodos de `TachyonManifold`.
