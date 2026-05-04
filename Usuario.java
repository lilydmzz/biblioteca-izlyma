import java.util.ArrayList;
import java.util.List;


public class Usuario {

	private String nombre;
	private List<Libro> librosPrestados;
	private List<Libro> historialPrestados = new ArrayList<>();

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.librosPrestados = new ArrayList<>();
	}

	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void agregarLibro(Libro libro) {
		librosPrestados.add(libro);
	}

	public void devolverLibro(Libro libro) {
		librosPrestados.remove(libro);
	}

	

	public void agregarHistorialPrestado(Libro libro) {
		historialPrestados.add(libro);
	}

	// modificar usuario
	public void modificarUsuarioNombre(String nombre) {
		setNombre(nombre);  	
	}
	// añadir usuario
	public void anadirUsuario(GestorBiblioteca gestor, Usuario usuario){
		gestor.anadirUsuario(usuario);
	}

	// eliminar usuario
	public void eliminarUsuario(GestorBiblioteca gestor, Usuario usuario){
		gestor.eliminarUsuario(usuario);
	}

	// Listar todos los usuarios
	public void listarUsuarios(GestorBiblioteca gestor){
		gestor.listarUsuarios();

	}

	// Buscar un usuario en concreto
	public void buscarUsuarios(GestorBiblioteca gestor, String n){
		gestor.buscarUsuarios(n); 
	}

	public String mostrarLibrosPrestados() {
		String fin = "Listado de libros prestados: ";
		Boolean entro = false;
		for(int i = 0; i < librosPrestados.size(); i++) {

			Libro libro = (Libro) librosPrestados.get(i);
			fin = fin.concat(libro.getTitulo()).concat(", ");
			entro = true;
		}
		if(entro) {
			return fin;
		} else {
			return "No hay libros prestados...";
		}
	}
	
	public void revisarHistorialPrestados() {

		System.out.println("Historial libros prestados:");
		
		for(int i = 0; i < historialPrestados.size(); i++) {
			Libro libro = historialPrestados.get(i);
			System.out.print(libro.getTitulo() + ":" + libro.getAutor());
			if(i < historialPrestados.size() - 1) {
				System.out.print(", ");
			}
			System.out.println();

		}
	}



	@Override
	public String toString() {
		return "Nombre:" + nombre + "\n" + mostrarLibrosPrestados();
	}


}