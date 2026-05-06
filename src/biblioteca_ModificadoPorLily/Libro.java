package biblioteca;
/**
 * Representa un libro de la biblioteca.
 * Implementa Comparable para poder ordenar por número de veces prestado.
 */


public class Libro implements Comparable<Libro>{

	private String titulo;
	private String autor;
	private boolean prestado;
	private String categoria;
	private int numeroDeVecesPrestado;
	
	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.prestado = false;
		categoria = null;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public int getNumeroDeVecesPrestado() {
		return numeroDeVecesPrestado;
	}

	public boolean estaPrestado() {
		return prestado;
	}
    /**
     * Marca el libro como prestado.
     */
	public void prestar() {
		prestado = true;
	}
    /**
     * Marca el libro como devuelto (disponible).
     */
	public void devolver() {
		prestado = false;
	}
    /**
     * Muestra e informa sobre la disponibilidad del libro.
     */
	public boolean disponibilidadLibro() {
		
		
		System.out.print("El libro " + titulo );
		
		if(prestado) {
			System.out.println(" no esta disponible...");  
			return false;
			
		} else {
			System.out.println(" esta disponible.");
			return true;
		}
	}
	
    /**
     * Incrementa en 1 el contador de veces que ha sido prestado.
     */
	public void aumentarNumeroDeVecesPrestado() {
		numeroDeVecesPrestado++;
	}
    /**
     * Ordena de mayor a menor número de préstamos.
     */
	@Override
	public int compareTo(Libro otro) {
		if(this.numeroDeVecesPrestado > otro.numeroDeVecesPrestado) {
			return -1;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
        return "\"" + titulo + "\" de " + autor +
                " | Categoría: " + (categoria != null ? categoria : "Sin categoría") +
                (prestado ? " (Prestado)" : " (Disponible)");	}
}