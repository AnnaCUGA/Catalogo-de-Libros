//paqueterías que se usaron para el programa
package com.example.library;
import com.example.library.service.BookService;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

public class LibraryApplication implements CommandLineRunner {
    //creamos la clase que implementa el método commandLineRunner, usando nuestras clases BookService y AuthorService 
    private BookService bookService;

    private AuthorService authorService;

    public static void main(String[] args) {
        //creamos el main, es decir, el programa que usa el usuario
        SpringApplication.run(LibraryApplication.class, args);
    }

    //Creamos el menú de inicio, usando while para que el programa no cierre hasta que el usuario decida cerrarlo
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Bienvenido a este programa que busca información sobre libros, para comenzar seleccione una opción colocando el número:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Listar libros por título");
            System.out.println("7. Listar autores por nombre");
            System.out.println("8. Buscar los 5 libros más populares");
            System.out.println("9. Mostrar estadísticas de la base de datos");
            System.out.println("10. Top 10 libros más descargados");
            System.out.println("11. Salir");

            //cargamos el scanner donde estará la entrada del usuario
            int option = scanner.nextInt();
            scanner.nextLine();

            //Según la opción que decida el usuario se hará una cosa diferente
            switch (option) {
                case 1:
                    //se pide el título del libro, después se buscará ese libro usando la función de búsqueda por título y lo mostraremos
                    System.out.println("Ingrese el título del libro:");
                    String title = scanner.nextLine();
                    System.out.println(bookService.findBookByTitle(title));
                    break;
                    //muestra la lista de los libros
                case 2:
                    System.out.println(bookService.listBooks());
                    break;
                case 3:
                    //muestra la lista de autores
                    System.out.println(authorService.listAuthors());
                    break;
                case 4:
                    //muestra los autores que están vivos en cierto año que determina el usuario
                    System.out.println("Ingrese el año:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(authorService.findAuthorsAliveInYear(year));
                    break;
                case 5:
                    //Según el idioma que haya colocado el usuario, se muestran los libros en ese idioma, si es que hay
                    System.out.println("Ingrese el idioma:");
                    String language = scanner.nextLine();
                    System.out.println(bookService.findBooksByLanguage(language));
                    break;
                case 6: 
                    //Lista una serie de libros que tengan un título equivalente al dado por el usuario
                    System.out.println("Ingrese el título del libro:");
                    String partialTitle = scanner.nextLine();
                    System.out.println(bookService.findBooksByTitle(partialTitle));
                    break;
                    //muestra una lista de autores según el nombre parecido al dado por el usuario
                case 7:
                    System.out.println("Ingrese el nombre del autor:");
                    String name = scanner.nextLine();
                    System.out.println(authorService.findAuthorsByName(name));
                    break;
                case 8:
                    //muestra top 5 libros más populares
                    System.out.println(bookService.findTop5MostPopularBooks());
                    break;
                case 9:
                    //muestra las estadísticas
                    showDatabaseStatistics();
                    break;
                case 10:
                    //muestra el top 10 de libros
                    System.out.println(bookService.findTop10MostDownloadedBooks());
                    break;
                    //si el usuario escoge esta opción se cierra el programa
                case 11:
                    System.exit(0);
                default:
                    //en caso que el usuario ponga alguna cosa no considerada en el menú, el programa suelta error y volvemos a soltar el menú
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void showDatabaseStatistics() {
        //aquí se debe mostar como se mostrarán las estadísticas de la base de datos
        System.out.println("Estadísticas de la base de datos...");
        
    }
}
