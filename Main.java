public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("El Quijote", "Cervantes");
        GestorBiblioteca gestorBiblioteca = new GestorBiblioteca();
        
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        biblioteca.listarLibros();
        System.out.println();
        Usuario usuario1 = new Usuario("Pepe");
        Usuario usuario2 = new Usuario("Izarbe");
        usuario1.anadirUsuario(gestorBiblioteca, usuario1);
        usuario1.anadirUsuario(gestorBiblioteca, usuario2);
        usuario1.agregarLibro(libro2);
        usuario1.buscarUsuarios(gestorBiblioteca, "Pepe");
        gestorBiblioteca.prestarLibro(usuario2, libro1);
        gestorBiblioteca.prestarLibro(usuario2, libro2);
        
        System.out.println();
       
        usuario2.revisarHistorialPrestados();
   
    }
}