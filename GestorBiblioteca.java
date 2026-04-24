import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {

    private List<Prestamo> prestamos;
    private List<Usuario> usuarios;
    
    public GestorBiblioteca() {
        this.prestamos = new ArrayList<>();
    }

    public void prestarLibro(Usuario usuario, Libro libro) {
        if (!libro.estaPrestado()) {
            libro.prestar();
            
            
            

            Prestamo prestamo = new Prestamo(usuario, libro, LocalDate.now());
            prestamos.add(prestamo);

            usuario.agregarLibro(libro);

            System.out.println(usuario.getNombre() + " ha cogido el libro: " + libro.getTitulo());
        } else {
            System.out.println("Este libro ya está prestado.");
        }
    }
}