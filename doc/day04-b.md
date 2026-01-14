# Día 4b - *Printing Department*

Ahora el elevador debe ir quitando todos los rollos a los que pueda acceder, hasta que no quede ninguno accesible. Debe contar el total de rollos que ha quitado. 

## Modelado conceptual

![Modelado conceptual](../images/day04.png)

## Evolución del diseño

Estas son las modificaciones introducidas en este código frente a la primera parte:

* **Generación de estados**: Ahora el almacén es capaz de actualizarse cuando el elevador elimine todos los rollos accesibles en esa iteración.

## Nuevas técnicas utilizadas

* **Inmutabilidad y Persistencia en la generación de estados**: Al generar un nuevo estado, en el método `Warehouse next()`, generamos un nuevo almacén con las modificaciones realizadas. Esto garantiza la inmutabilidad del modelo, y permite realizar un seguimiento sobre la evolución del almacén. 
* **Iteración sobre los estados del almacén**: Mediante `Stream.iterate()` vamos generando nuevos estados del almacén, hasta que el método `next()` nos devuelva `null`.
