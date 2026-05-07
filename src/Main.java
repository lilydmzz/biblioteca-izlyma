public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("El Quijote", "Cervantes");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        biblioteca.listarLibros();
    }
}