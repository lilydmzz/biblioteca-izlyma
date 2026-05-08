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

 ### `Biblioteca.java`
Gestiona el catálogo general de libros
 
- **`iniciadorBiblioteca()`** — carga tres libros de ejemplo al arrancar la aplicación
- **`agregarLibro(Libro)`** — añade un nuevo libro al catálogo
- **`borrarLibro(String)`** — elimina un libro por título, este avisa si no existe
- **`buscarLibro(String)`** — devuelve el libro que coincida con el título
- **`listarLibros()`** — muestra todos los libros del catálogo
---
 
### `Libro.java`
Representa un libro de la biblioteca
 
- **`prestar()`** — marca el libro como prestado
- **`devolver()`** — marca el libro como disponible
- **`disponibilidadLibro()`** — informa si el libro está disponible o no
- **`aumentarNumeroDeVecesPrestado()`** — incrementa en 1 el contador de préstamos
- **`compareTo(Libro)`** — ordena de mayor a menor número de préstamos
---
 
### `Usuario.java`
Representa a un usuario registrado
 
- **`agregarLibro(Libro)`** — añade un libro a los prestamos actuales
- **`devolverLibro(Libro)`** — elimina un libro de sus prestamos
- **`agregarHistorialPrestado(Libro)`** — guarda el libro en el historial total del mismo usuario
- **`cantidadDeLibrosPrestados()`** — devuelve el total de libros leídos (los actuales mas los del mismo historial)
- **`mostrarLibrosPrestados()`** — devuelve un texto con los libros que tiene ahora mismo
- **`revisarHistorialPrestados()`** — muestra todos los libros que ha tenido alguna vez
- **`compareTo(Usuario)`** — ordena de mayor a menor número de libros prestados
---
 
### `Prestamo.java`
Representa el registro de un préstamo entre un usuario y un libr
 
- **`Prestamo(Usuario, Libro, LocalDate)`** — crea el préstamo y calcula automáticamente la fecha de devolución a 2 semanas
- **`getUsuario()`** — devuelve el usuario que esta asociado al préstamo
- **`getLibro()`** — devuelve el libro asociado a ese préstamo
- **`getFechaDevolucion()`** — devuelve la fecha límite
---
 
### `GestorBiblioteca.java`
Clase central que coordina todas las operaciones. Tanto préstamos, usuarios y categorías.
 
- **`prestarLibro(Usuario, Libro)`** — verifica disponibilidad del libro, registra el préstamo y actualiza el historial. El limite es de 3 libros
- **`devolverLibro(Usuario, Libro)`** — marca el libro como disponible y lo retira de los préstamos del usuario
- **`anadirUsuario(Usuario)`** / **`eliminarUsuario(Usuario)`** — gestiona el alta y baja de usuarios
- **`listarUsuarios()`** / **`buscarUsuarios(String)`** — muestra o localiza usuarios registrados
- **`anadirCategorias(String)`** / **`mostrarCategorias()`** — gestiona la lista de categorías disponibles
- **`asignarCategoriasLibros(int, Libro)`** — asigna una categoría a un libro
- **`librosPorCategoria(int)`** — devuelve y muestra los libros de una categoría concreta
- **`librosMasPrestados(List<Libro>)`** — ordena los libros de mayor a menor préstamos con porcentaje
- **`lectoresActivos()`** — ordena los usuarios por cantidad de libros leídos
- **`totalPrestamosCategoria(int)`** — suma el total de préstamos de todos los libros de una categoría
---
 
### `main.java`
Gestiona el menú interactivo por consola
 
- Inicializa la biblioteca con libros y usuarios de ejemplo al arrancar
- Presenta un menú principal con 5 secciones: Libros, Usuarios, Préstamos, Categorías y Estadísticas
- **`validarOpcion()`** — lee y valida la entrada numérica del usuario de forma segura

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
 - `Izarbe Lanuza Orna`
