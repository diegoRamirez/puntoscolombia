# language: es

Característica: Reserva de vuelos para viaje

  Como usuario
  Quiero realizar una reserva
  Para posteriormente avanzar con el pago

  Esquema del escenario: Realizar reserva

    Dado que el usuario se encuentra en la página de búsqueda de vuelos

    Cuando realiza una búsqueda con los siguientes datos
     | fechaSalida   | fechaLlegada   | cantidadAdultos   | cantidadMenores   |
      | <fechaSalida> | <fechaLlegada> | <cantidadAdultos> | <cantidadMenores> |

    Y elige el destino que le interesa <destino> con un precio máximo de <precioMaximo>

    Entonces deberia ver su reserva finalizada exitosamente

    Ejemplos:
    #El precio máximo debe estar entre 100 y 1800
    #La la cantidad de adultos y de menores debe ser máximo 4
      | fechaSalida | fechaLlegada | cantidadAdultos | cantidadMenores | precioMaximo | destino|
      | 15/07/2026  | 18/08/2026   | 4               | 2               | 500          |        |