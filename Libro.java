public class Libro {

	private String titulo;
	private String autor;
	private boolean prestado;

	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.prestado = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public boolean estaPrestado() {
		return prestado;
	}

	public void prestar() {
		prestado = true;
	}

	public void devolver() {
		prestado = false;
	}

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
	@Override
	public String toString() {
		return titulo + " de " + autor + (prestado ? " (Prestado)" : " (Disponible)");
	}
}