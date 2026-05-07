package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    static List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Añadir libro a la biblioteca
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Buscar libro por título ignorando acentos
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
    	if(libros.size() > 0) {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    	} else {
    		System.out.println("No hay libros...");
    	}
    	
    }
}
