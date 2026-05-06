package biblioteca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    // Lista estática compartida de todos los libros de la biblioteca
    static List<Libro> libros;
    
    public static List<Libro> getLibros() {
		return libros;
	}

	
	public Biblioteca() {
        this.libros = new ArrayList<>();
    }
	
    /**
     * Carga unos libros iniciales de ejemplo en la biblioteca.
     */
	public void iniciadorBiblioteca() {
		agregarLibro(new Libro("DIARIO DE GREG 1: UN PRINGAO TOTAL", "Jeff Kinney")); 
		agregarLibro(new Libro("MINECRAFT OFICIAL: BASES EPICAS", "Mojang Ab")); 
		agregarLibro(new Libro("MINECRAFT :DIARIO DE UN ALDEANO PRINGAO", "Planeta Junior")); 
	}
	//borrar libro
	public void borrarLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null) {
            libros.remove(libro);
        } else {
            System.out.println("No se encontró el libro: " + titulo);
        }
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
