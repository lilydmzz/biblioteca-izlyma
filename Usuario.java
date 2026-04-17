import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private List<Libro> librosPrestados;

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.librosPrestados = new ArrayList<>();
	}

	public String getNombre() { 
		return nombre; 
	}

	public List<Libro> getLibrosPrestados() { 
		return librosPrestados; 
	}

	public void añadirLibro(Libro libro) { 
		librosPrestados.add(libro); 
	}
	public void devolverLlibro(Libro libro) { 
		librosPrestados.remove(libro); 
	}



}