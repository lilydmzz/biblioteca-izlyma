package biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gestiona las operaciones principales de la biblioteca:
 * préstamos, usuarios y categorías.
 */
public class GestorBiblioteca {
	
	private static final int MAX_LIBROSPRESTADOS = 3;
	private List<Prestamo> prestamos = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
	private List<String> listaCategorias= new ArrayList<>();
	
	public GestorBiblioteca() {
        // Categorías predeterminadas
		listaCategorias.add("Novel·la");
		listaCategorias.add("Història");
		listaCategorias.add("Ciència");
		listaCategorias.add("Infantil");
	}
	


    /**
     * Presta un libro a un usuario si está disponible.
     */
	public void prestarLibro(Usuario usuario, Libro libro) {
	    if (libro == null) {
	        System.out.println("Libro no encontrado.");
	        return;
	    }
	    
	    if (usuario.getLibrosPrestados().size() >= MAX_LIBROSPRESTADOS) {
	        System.out.println("El usuario ya tiene el máximo de " + MAX_LIBROSPRESTADOS + " libros prestados.");
	        return;
	    }
	    
		if (!libro.estaPrestado()) {
			libro.prestar();
			Prestamo prestamo = new Prestamo(usuario, libro, LocalDate.now());
			prestamos.add(prestamo);
			
			usuario.agregarHistorialPrestado(libro);
			
			usuario.agregarLibro(libro);
			
			System.out.println(usuario.getNombre() + " ha cogido el libro: " + libro.getTitulo());
			libro.aumentarNumeroDeVecesPrestado();
		} else {
			System.out.println("Este libro ya está prestado.");
		}
	}
	
    /**
     * Registra la devolución de un libro.
     */
    public void devolverLibro(Usuario usuario, Libro libro) {
        if (libro == null) return;
        libro.devolver();
        usuario.devolverLibro(libro);
        System.out.println(usuario.getNombre() + " ha devuelto: \"" + libro.getTitulo() + "\"");
    }
    
    
	public void anadirUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	public void eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
    /**
     * Lista todos los usuarios registrados.
     */
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + " - " + usuarios.get(i));
        }
    }
    /**
     * Busca un usuario por nombre y lo muestra por consola.
     */
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

    /**
     * Lista todos los libros de la biblioteca.
     */
    public void listarLibros() {
        List<Libro> libros = Biblioteca.getLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + " - " + libros.get(i));
        }
    }
	

    /**
     * Añade una nueva categoría a la lista.
     */
	public void anadirCategorias(String categoria) {
		listaCategorias.add(categoria);	
		System.out.println("Se ha añadido " + categoria + " correctamente!!\n");
	}
	
    /**
     * Muestra todas las categorías disponibles con su índice.
     */
	public void mostrarCategorias() {
		int numero = 0;
        System.out.println("Categorías disponibles:");
		for(String categorias : listaCategorias) {
			System.out.println(numero  + ": " + categorias + "\n");
			numero++;
		}
	}
    /**
     * Asigna una categoría (por índice) a un libro.
     */
	public void asignarCategoriasLibros(int numero, Libro libro) {
        if (libro == null) {
            System.out.println("El libro no existe.");
            return;
        }  
		if(listaCategorias.size() > numero && numero >= 0) {
			libro.setCategoria(listaCategorias.get(numero));
			System.out.println("Añadido " +  libro.getTitulo()+ " a " +  listaCategorias.get(numero));
		}else {
			System.out.println("Ese numero no existe dentro de la lista de categorias, añadela si quieres tenerla..");
		}
	}
    /**
     * Devuelve y muestra los libros de una categoría concreta.
     */
	public List<Libro> librosPorCategoria(int numeroCategoria){
	    List<Libro> librosPorCategorias = new ArrayList<>();
	    if(listaCategorias.size() <= numeroCategoria ||  numeroCategoria < 0){
            System.out.println("Índice de categoría inválido.");
            return librosPorCategorias;
	    }
	    
        String nombreCategoria = listaCategorias.get(numeroCategoria);
        System.out.println("Libros en \"" + nombreCategoria + "\":");
        
	    for(Libro libro : Biblioteca.getLibros()) {
			if(listaCategorias.size() > numeroCategoria &&
				(nombreCategoria.equals(libro.getCategoria()))) {
				librosPorCategorias.add(libro);
				System.out.println(libro.getTitulo());
			}
		}

        if (librosPorCategorias.isEmpty()) {
            System.out.println("Ningún libro en esta categoría");
        }
		return librosPorCategorias;
	}
	
	
    /**
     * Muestra el total de préstamos de todos los libros de una categoría.
     */
	public void totalPrestamosCategoria(int numeroCategoria) {
		 List<Libro> librosPorCategoria = librosPorCategoria(numeroCategoria);
		 int numeroTotalPrestadas = 0;
		 for(Libro libro : librosPorCategoria) {
			 numeroTotalPrestadas += libro.getNumeroDeVecesPrestado();
		 }
		 if ( numeroTotalPrestadas >0) {
			 System.out.println("El numero total de prestamos por esta categoria es: " + numeroTotalPrestadas);
		 }else {
			 System.out.println("No hay ningun prestamo por esta categoria");
		 }
	}
	
	
	
    /**
     * Muestra los libros ordenados de más a menos prestados,
     * con el porcentaje sobre el total de préstamos.
     */
	public void librosMasPrestados(List<Libro> libros) {
	    if (libros.isEmpty() || prestamos.isEmpty()) {
	        System.out.println("No hay datos de préstamos.");
	        return;
	    }

	    List<Libro> copia = new ArrayList<>(libros);
	    Collections.sort(copia);

	    System.out.println("Libros más prestados:");
	    int contador = 1;
	    for (Libro libro : copia) {
	        double porcentaje = (libro.getNumeroDeVecesPrestado() * 100.0) / prestamos.size();
	        System.out.println(contador  + " - " + libro.getTitulo() + ": " + libro.getNumeroDeVecesPrestado() + " veces (" + porcentaje + "%)");
	        contador ++;
	    }
	}
	
    /**
     * Muestra los usuarios ordenados de más a menos activos (por libros leídos).
     */
    public void lectoresActivos() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        List<Usuario> copia = new ArrayList<>(usuarios);
        Collections.sort(copia);
        System.out.println("Lectores más activos:");
        for (Usuario usuario : copia) {
            System.out.println(usuario.getNombre() + ": " +
            usuario.cantidadDeLibrosPrestados() + " libro(s) leído(s)");
        }
    }
    



}