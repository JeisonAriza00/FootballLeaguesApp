# Challenge de Condor Labs para Android: #FootballLeaguesApp

El siguiente repositorio contiene el desarrollo de una aplicación para dispositivos móviles con SO Android que permite revisar la lista de equipos que conforman una liga de futbol y ver su detalle.

#API TheSportsDB

Se tuvo acceso al API Tutorial de la sección Devs, donde se pudo observar la estructura de la API de items y búsqueda, que permite traer la información de ligas de futbol, equipos y eventos.

```
https://www.thesportsdb.com/api.php
https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?l=Spanish%20la%20Liga
https://www.thesportsdb.com/api/v1/json/2/eventslast.php?id=133738
```

#Pantallas de la App

La propusta que se llevó a cabo fue implementar unas pantallas que mostraran los equipos de una liga y su detalle.

- **Pantalla de Splash**: Una pantalla de duración corta que sera la introducción y dara inicio a la app.
- **Pantalla de Equipos**: Esta pantalla listara los equipos que conforman una liga de futbol en este caso la liga de futbol de España - Liga Santander.
- **Pantalla de detalle de equipo**: En esta pantalla se mostrará información relevante del equipo de futbol seleccionado.

#Arquitectura

La arquitectura que se ideo para este proyecto fue usar un patrón MVVM (Model-View-ViewModel) para facilitar el desarrollo y la separación de la lógica del negocio con la interfaz gráfica.


Jeison Ariza.