# Día 8b - *Playground*

Se deben conectar todas las cajas entre ellas hasta formar un único circuito. Una vez hecho eso, hay que multiplicar las coordenadas x de las dos últimas cajas conectadas.

## Modelado conceptual

![Modelado conceptual](../images/day08.png)

## Evolución del diseño
Únicamente se ha eliminado el límite de cajas conectadas en Playground (pues tenemos que conectar todas las cajas), y se ha modificado `CircuitSet` para que contenga las últimas cajas conectadas. De esta forma, hemos adaptado el código de la primera parte con muy pocos cambios, totalmente transparentes al resto de clases.