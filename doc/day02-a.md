# Día 2a - *Gift Shop*

Implementación de la base de datos de una tienda de regalos, que tiene que identificar entre una serie de rangos los IDs de productos inválidos.

## Modelado conceptual

![Modelado conceptual](../images/day02.png)

## Técnicas comunes

A continuación proponemos ejemplos en este día de las técnicas y líneas prinicipales del proyecto.

### Patrones creacionales
* **Factory Method:** usado tanto en la clase Range (`Range.from(String range)`) como en la clase GiftShopDatabase (`GiftShopDatabase.from(String ranges)`).

### Lógica estructural
* **Principio de Responsabilidad Única (SRP):**
  * *GiftShopDatabase*: Actúa como motor de búsuqueda, coordinando y agregando los datos existentes.
  * *Range*: Sabe convertir la entrada (*10-26*) a un objeto de su tipo, conociendo los límites del intervalo y cómo iterar sobre ellos.
  * *Product*: Responsable de almacenar el id y comprobar si es válido.
* **Alta Modularidad y Bajo Acoplamiento:** La *GiftShopDatabase* desconoce el formato de las órdenes de entrada, solo conoce objetos Range y Product. Esto protege al sistema contra cambios en el formato del *input*.
* **Inmutabilidad**: Todas las clases implementadas son inmutables.

### Clean Code
* **Programación declarativa y funcional**: El uso de streams y Fluent APIs en los métodos facilita la comprensión del código y evita la complejidad ciclomática. Por ejemplo, al leer `sumInvalidIds()` entendemos perfectamente la serie de acciones tomadas: transforma rangos en una serie de números, los convierte en productos, filtra los inválidos y suma los IDs restantes.
* **Good naming**: Los métodos desarrollados tienen nombres autoexplicativos, que promueven la abstracción.

## Otras técnicas utilizadas
* **Encapsulación de RegEx**: La lógica que comprueba los IDs inválidos se encuentra encapsulada en la clase Product (`^([0-9]+)\\1$`). Esto nos permite cambiarla de forma sencilla en caso de ser necesario, sin tener que modificar cualquier otra clase. Es precisamente esto lo que realizamos en la parte 2b, demostrando la modularidad del código.