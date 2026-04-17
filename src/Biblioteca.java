import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Añadir libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Buscar libro por título
    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // Listar todos los libros
    public void listarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
