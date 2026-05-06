//Añadido de lo que me mandó el Marcos 


import java.util.Scanner;

public class Main {

    static Biblioteca biblioteca = new Biblioteca();
    static GestorBiblioteca gestor = new GestorBiblioteca();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        biblioteca.iniciadorBiblioteca();
        gestor.anadirUsuario(new Usuario("Pepe"));
        gestor.anadirUsuario(new Usuario("Izarbe"));

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n1.Libros  2.Usuarios  3.Prestamos  4.Categorias  5.Estadisticas  0.Salir");
            opcion = leerEntero();
            switch (opcion) {
                case 1: menuLibros(); break;
                case 2: menuUsuarios(); break;
                case 3: menuPrestamos(); break;
                case 4: menuCategorias(); break;
                case 5: menuEstadisticas(); break;
                case 0: System.out.println("Hasta luego!"); break;
                default: System.out.println("Opcion no valida."); break;
            }
        }
    }

    private static void menuLibros() {
        System.out.println("1.Listar  2.Añadir  3.Buscar  4.Eliminar");
        int op = leerEntero();
        switch (op) {
            case 1:
                gestor.listarLibros();
                break;
            case 2:
                System.out.print("Titulo: "); String titulo = sc.nextLine();
                System.out.print("Autor: ");  String autor = sc.nextLine();
                biblioteca.agregarLibro(new Libro(titulo, autor));
                System.out.println("Libro añadido.");
                break;
            case 3:
                System.out.print("Titulo: ");
                Libro l = biblioteca.buscarLibro(sc.nextLine());
                System.out.println(l != null ? l : "No encontrado.");
                break;
            case 4:
                System.out.print("Titulo: ");
                biblioteca.borrarLibro(sc.nextLine());
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    private static void menuUsuarios() {
        System.out.println("1.Listar  2.Añadir  3.Buscar  4.Eliminar  5.Historial");
        int op = leerEntero();
        switch (op) {
            case 1:
                gestor.listarUsuarios();
                break;
            case 2:
                System.out.print("Nombre: ");
                gestor.anadirUsuario(new Usuario(sc.nextLine()));
                System.out.println("Usuario añadido.");
                break;
            case 3:
                System.out.print("Nombre: ");
                gestor.buscarUsuarios(sc.nextLine());
                break;
            case 4:
                System.out.print("Nombre: ");
                Usuario u = gestor.buscarUsuarioObjeto(sc.nextLine());
                if (u != null) {
                    gestor.eliminarUsuario(u);
                    System.out.println("Eliminado.");
                } else {
                    System.out.println("No encontrado.");
                }
                break;
            case 5:
                System.out.print("Nombre: ");
                Usuario u2 = gestor.buscarUsuarioObjeto(sc.nextLine());
                if (u2 != null) {
                    u2.revisarHistorialPrestados();
                } else {
                    System.out.println("No encontrado.");
                }
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    private static void menuPrestamos() {
        System.out.println("1.Prestar  2.Devolver");
        int op = leerEntero();
        System.out.print("Nombre usuario: ");
        Usuario u = gestor.buscarUsuarioObjeto(sc.nextLine());
        System.out.print("Titulo libro: ");
        Libro l = biblioteca.buscarLibro(sc.nextLine());
        if (u == null || l == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }
        switch (op) {
            case 1:
                gestor.prestarLibro(u, l);
                break;
            case 2:
                gestor.devolverLibro(u, l);
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    private static void menuCategorias() {
        System.out.println("1.Ver  2.Añadir  3.Asignar  4.Libros por categoria");
        int op = leerEntero();
        switch (op) {
            case 1:
                gestor.mostrarCategorias();
                break;
            case 2:
                System.out.print("Categoria: ");
                gestor.anadirCategorias(sc.nextLine());
                break;
            case 3:
                gestor.mostrarCategorias();
                System.out.print("Numero: "); int idx = leerEntero();
                System.out.print("Titulo: ");
                Libro l = biblioteca.buscarLibro(sc.nextLine());
                gestor.asignarCategoriasLibros(idx, l);
                break;
            case 4:
                gestor.mostrarCategorias();
                System.out.print("Numero: ");
                gestor.librosPorCategoria(leerEntero());
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    private static void menuEstadisticas() {
        System.out.println("1.Mas prestados  2.Lectores activos  3.Prestamos por categoria");
        int op = leerEntero();
        switch (op) {
            case 1:
                gestor.librosMasPrestados(Biblioteca.getLibros());
                break;
            case 2:
                gestor.lectoresActivos();
                break;
            case 3:
                gestor.mostrarCategorias();
                System.out.print("Numero: ");
                gestor.totalPrestamosCategoria(leerEntero());
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    private static int leerEntero() {
        System.out.print("Opcion: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}