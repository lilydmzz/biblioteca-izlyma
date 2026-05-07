#  Biblioteca

Una biblioteca desarrollada en Java, esta nos permite el poder administrar libros, usuarios, préstamos y categorías, todo esto desde un menú que se puede interactuar por consola

---

## Estructura del proyecto

```
biblioteca/
├── main.java
├── Biblioteca.java
├── GestorBiblioteca.java
├── Libro.java
├── Usuario.java
└── Prestamo.java
```

---

## Funcionalidades

### Libros
- Listar todos los libros del catálogo
- Añadir un nuevo libro (poniendo el título y el autor)
- Buscar un libro por título
- Eliminar un libro

### Usuarios
- Listar usuarios registrados
- Añadir un nuevo usuario
- Buscar usuario por nombre
- Eliminar usuario
- Ver historial de libros prestados

### Préstamos
- Prestar un libro a un usuario
- Registrar la devolución de un libro
- Límite máximo de 3 libros por usuario

### Categorías
- Ver categorías disponibles
- Añadir una nueva categoría
- Asignar una categoría a un libro
- Listar libros de una categoría concreta
Categorías predeterminadas: `Novela`, `Historia`, `Ciencia`, `Infantil`

### Estadísticas
- **Libros más prestados**: ordenados de mayor a menor con porcentaje sobre el total
- **Lectores más activos**: usuarios ordenados por cantidad de libros leídos
- **Préstamos por categoría**: total de préstamos acumulados en una categoría

---

## Modelos de datos

### `Libro`
| Campo | Tipo | Descripción |
|---|---|---|
| titulo | String | Título del libro |
| autor | String | Autor del libro |
| prestado | boolean | Si está actualmente prestado |
| categoria | String | Categoría asignada (puede ser null) |
| numeroDeVecesPrestado | int | Contador de veces prestado |

### `Usuario`
| Campo | Tipo | Descripción |
|---|---|---|
| nombre | String | Nombre del usuario |
| librosPrestados | List\<Libro\> | Libros que tiene actualmente |
| historialPrestados | List\<Libro\> | Todos los libros prestados alguna vez |

### `Prestamo`
| Campo | Tipo | Descripción |
|---|---|---|
| usuario | Usuario | Usuario que realiza el préstamo |
| libro | Libro | Libro prestado |
| fechaPrestamo | LocalDate | Fecha en que se realizó el préstamo |
| fechaDevolucion | LocalDate | Fecha límite de devolución (+2 semanas) |

---

## Libros de ejemplo (precargados)

Al iniciar la aplicación se cargan automáticamente:
- *Diario de Greg 1: Un Pringao Total* — Jeff Kinney
- *Minecraft Oficial: Bases Épicas* — Mojang Ab
- *Minecraft: Diario de un Aldeano Pringao* — Planeta Junior

Y se registran dos usuarios de prueba: **Pepe** e **Izarbe**.

---

## Colaboradores
 - `Marcos Jalca`
 - `Allison Valeriano`
 - `Izarbe Lanuza`
