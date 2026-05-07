
package biblioteca;

import java.util.Scanner;

public class main {

	static Biblioteca biblioteca = new Biblioteca();
	static GestorBiblioteca gestor = new GestorBiblioteca();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		biblioteca.iniciadorBiblioteca();
		gestor.anadirUsuario(new Usuario("Pepe"));
		gestor.anadirUsuario(new Usuario("Izarbe"));
		
		System.out.println(" - Bienvenido a la biblioteca MIL - \n");
		int opcion = -1;
		while (opcion != 0) {
			System.out.println("\n1.Libros  2.Usuarios  3.Prestamos  4.Categorias  5.Estadisticas  0.Salir");
			opcion = validarOpcion();
			switch (opcion) {
			case 1: 
				menuLibros(); 
				break;
			case 2: 
				menuUsuarios(); 
				break;
			case 3: 
				menuPrestamos(); 
				break;
			case 4: 
				menuCategorias(); 
				break;
			case 5: 
				menuEstadisticas(); 
				break;
			case 0: 
				System.out.println("Hasta luego!"); 
				break;
			default: 
				System.out.println("Opcion no valida."); 
				break;
			}
			
		}
		
		
	}

	private static void menuLibros() {
		System.out.println("1.Listar  2.Añadir  3.Buscar  4.Eliminar");
		int op = validarOpcion();
		switch (op) {
		case 1:
			gestor.listarLibros();
			break;
		case 2:
			System.out.print("Titulo: "); String titulo = sc.next();
			System.out.print("Autor: ");  String autor = sc.next();
			biblioteca.agregarLibro(new Libro(titulo, autor));
			System.out.println("Libro añadido.");
			break;
		case 3:
			System.out.print("Titulo: ");
			Libro l = biblioteca.buscarLibro(sc.next());
			System.out.println(l != null ? l : "No encontrado.");
			break;
		case 4:
			System.out.print("Titulo: ");
			biblioteca.borrarLibro(sc.next());
			break;
		default:
			System.out.println("Opcion no valida.");
			break;
		}
	}

	private static void menuUsuarios() {
		System.out.println("1.Listar  2.Añadir  3.Buscar  4.Eliminar  5.Historial");
		int op = validarOpcion();
		switch (op) {
		case 1:
			gestor.listarUsuarios();
			break;
		case 2:
			System.out.print("Nombre: ");
			gestor.anadirUsuario(new Usuario(sc.next()));
			System.out.println("Usuario añadido.");
			break;
		case 3:
			System.out.print("Nombre: ");
			gestor.buscarUsuarios(sc.next());
			break;
		case 4:
			System.out.print("Nombre: ");
			Usuario u = gestor.buscarUsuarioObjeto(sc.next());
			if (u != null) {
				gestor.eliminarUsuario(u);
				System.out.println("Eliminado.");
			} else {
				System.out.println("No encontrado.");
			}
			break;
		case 5:
			System.out.print("Nombre: ");
			Usuario u2 = gestor.buscarUsuarioObjeto(sc.next());
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
		int op = validarOpcion();
		System.out.print("Nombre usuario: ");
		Usuario u = gestor.buscarUsuarioObjeto(sc.next());
		System.out.print("Titulo libro: ");
		Libro l = biblioteca.buscarLibro(sc.next());
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
		int op = validarOpcion();
		switch (op) {
		case 1:
			gestor.mostrarCategorias();
			break;
		case 2:
			System.out.print("Categoria: ");
			gestor.anadirCategorias(sc.next());
			break;
		case 3:
			gestor.mostrarCategorias();
			System.out.print("Numero: "); int idx = validarOpcion();
			System.out.print("Titulo: ");
			Libro l = biblioteca.buscarLibro(sc.next());
			gestor.asignarCategoriasLibros(idx, l);
			break;
		case 4:
			gestor.mostrarCategorias();
			System.out.print("Numero: ");
			gestor.librosPorCategoria(validarOpcion());
			break;
		default:
			System.out.println("Opcion no valida.");
			break;
		}
	}

	private static void menuEstadisticas() {
		System.out.println("1.Mas prestados  2.Lectores activos  3.Prestamos por categoria");
		int op = validarOpcion();
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

			gestor.totalPrestamosCategoria(validarOpcion());
			break;
		default:
			System.out.println("Opcion no valida.");
			break;
		}
	}

	private static int validarOpcion() {

		String opcion = sc.next();
		int opcion1 = (int) opcion.charAt(0);
		int menu = 10;
		if (opcion1 > 47 && opcion1 < 58) {
			menu = (int) opcion1-48;
		}

		return menu;

	}
	
	private static void saltos() {
		
		for(int i = 0; i < 50;i++) {
			System.out.println();
		}
	}
}