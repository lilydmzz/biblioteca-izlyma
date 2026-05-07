package biblioteca;
import java.time.LocalDate;
/**
 * Representa un préstamo de un libro a un usuario en una fecha determinada.
 */
public class Prestamo {

	
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    
    /**
     * Crea un préstamo con devolución prevista a 2 semanas.
     */
    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusWeeks(2);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    @Override
    public String toString() {
        return usuario.getNombre() + " → \"" + libro.getTitulo() +
               "\" | Prestado: " + fechaPrestamo + " | Devolver antes de: " + fechaDevolucion;
    }
    

}