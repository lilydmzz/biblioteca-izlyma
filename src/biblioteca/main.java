package biblioteca;
public class main {
    public static void __main(String[] args)__ {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("El Quijote", "Cervantes");
        GestorBiblioteca gestorBiblioteca = new GestorBiblioteca();

        System.out.println();
        Usuario usuario1 = new Usuario("Pepe");
        Usuario usuario2 = new Usuario("Izarbe");
        gestorBiblioteca.prestarLibro(usuario2, libro1);
        gestorBiblioteca.anadirUsuario(usuario1);
        gestorBiblioteca.anadirUsuario(usuario2);

        biblioteca.iniciadorBiblioteca();

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        System.out.println();
        System.out.println("Listar usuarios");
        gestorBiblioteca.listarUsuarios();
        System.out.println();

        System.out.println("Listar libros");
        gestorBiblioteca.listarLibros();
        System.out.println();

        usuario1.agregarLibro(libro2);
        usuario1.buscarUsuarios(gestorBiblioteca, "Pepe");
        gestorBiblioteca.prestarLibro(usuario2, libro1);
        gestorBiblioteca.prestarLibro(usuario1, libro1);
        gestorBiblioteca.prestarLibro(usuario2, biblioteca.buscarLibro("DIARIO DE GREG 1: UN PRINGAO TOTAL"));
        gestorBiblioteca.prestarLibro(usuario1, biblioteca.buscarLibro("MINECRAFT OFICIAL: BASES EPICAS"));
        gestorBiblioteca.prestarLibro(usuario2, biblioteca.buscarLibro("MINECRAFT :DIARIO DE UN ALDEANO PRINGAO"));

        System.out.println();

        usuario2.revisarHistorialPrestados();
        System.out.println();
        System.out.println("Disponiblidad de libros");

        libro1.disponibilidadLibro();
        libro2.disponibilidadLibro();

        System.out.println("--------------------");
        gestorBiblioteca.anadirCategorias("Romance");
        gestorBiblioteca.gestionCategorias();
        gestorBiblioteca.anadirCategoriasLibros(3, biblioteca.buscarLibro("DIARIO DE GREG 1: UN PRINGAO TOTAL"));
        gestorBiblioteca.anadirCategoriasLibros(3, biblioteca.buscarLibro("DIARIO DE GREG 1: UN PRINGAO TOTAL"));
        gestorBiblioteca.anadirCategoriasLibros(3, biblioteca.buscarLibro("MINECRAFT OFICIAL: BASES EPICAS"));
        gestorBiblioteca.anadirCategoriasLibros(3, biblioteca.buscarLibro("MINECRAFT :DIARIO DE UN ALDEANO PRINGAO"));

        System.out.println("--------------------");

        gestorBiblioteca.librosMasPrestados(biblioteca.__libros__);

        System.out.println("--------------------");

        gestorBiblioteca.lectoresActivos();

        System.out.println("--------------------");
        gestorBiblioteca.anadirCategoriasLibros(1, libro1);
        gestorBiblioteca.llibresPerCategoria(1);
        System.out.println("--------------------");
        gestorBiblioteca.numeroTotalDePrestecsCategoria(3);
    }
}