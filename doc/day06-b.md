# Día 6b - *Trash Compactor*

Modificación de la lógica de lectura de las hojas de ejercicios. En este ejercicio, los distintos números pasan a leerse en vertical.


## Modelado conceptual


![Modelado conceptual](../images/day06.png)

## Evolución del diseño

Únicamente se ha modificado la implementación de `CephalopodWorksheetReader` para cambiar la forma de leer las operaciones. Gracias
a nuestra interfaz `WorksheetReader`, la sustitución de implementaciones se ha realizado de forma rápida y transparente para el resto
de clases del modelo. Esto demuestra la modularidad inherente del Principio de Sustitución de Liskov.