import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {

	private List<Prestamo> prestamos = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();

	public GestorBiblioteca() {
	}

	public void prestarLibro(Usuario usuario, Libro libro) {

		if (!libro.estaPrestado()) {
			libro.prestar();
			Prestamo prestamo = new Prestamo(usuario, libro, LocalDate.now());
			prestamos.add(prestamo);
			
			usuario.agregarHistorialPrestado(libro);
			
			usuario.agregarLibro(libro);
			
			System.out.println(usuario.getNombre() + " ha cogido el libro: " + libro.getTitulo());
		} else {
			System.out.println("Este libro ya está prestado.");
		}
	}
	public void anadirUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	public void eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public void listarUsuarios(){

		for(int i = 0; i < usuarios.size(); i++) {
			System.out.println();
			System.out.print((i+1) + " ~ " );
			System.out.print(usuarios.get(i));
		}

	}
	public void buscarUsuarios( String n){
		boolean fin = false;

		for(int i = 0; i < usuarios.size() && !fin ; i++) {
			Usuario user = usuarios.get(i);
			if(user.getNombre().equals(n)) {
				System.out.println(usuarios.get(i));
				fin = true;
			}
		} 
		if (!fin) {
			System.out.println("No se ha encontrado el usuario");
		}
	}

}