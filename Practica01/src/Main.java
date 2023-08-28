import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Clase Main 
 */
public class Main{

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        CategoryRegistrador bd = new CategoryRegistrador();
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("-----------------------Menú-----------------------");
            System.out.println("Selecccione la opción deseada");
            System.out.println(" 1. Crear una categoria");
            System.out.println(" 2. Listar las categorias existenes ");
            System.out.println(" 3. Buscar alguna categoria por su id");
            System.out.println(" 4. Eliminar alguna categoria con su id");
            System.out.println("--Pulse cualquier otro numero para salir del menu--");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        createCategory(bd);
                        break;
                    case 2:
                        getCategories(bd);
                        break;
                    case 3:
                        getCategory(bd);
                        break;
                    case 4:
                        deleteCategory(bd);
                        break;
                    default:
                        opcion = 0;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("--La opcion que ingreso es incorrecta, por favor ingrese un valor valido--");
                scanner.next();
            }
            System.out.println();
        }
    }

    private static void createCategory(CategoryRegistrador bd) {
        System.out.println("--Ponle un nombre a tu nueva categoria--");
        System.out.println("Asignale un id a tu categoria:");
        System.out.println("EL id debe de ser un numero entero");
        int id = scanner.nextInt();

        Category existingCategory = bd.getCategory(id);
        if (existingCategory != null) {
            System.out.println("--Ya existe ese id en otra categoria, asignele otro id por favor--");
        } else {
            System.out.println("Escribe el nombre de la categoria:");
            scanner.nextLine();
            String name = scanner.nextLine();
            Category category = new Category(id, name);
            bd.createCategory(category);
        }
    }

    private static void getCategories(CategoryRegistrador bd) {
        System.out.println("- Lista de categorías");
        List<Category> categories = bd.getCategories();
        if (categories.isEmpty()) {
            System.out.println("No existen categorias registradas");
        }

        for (Category c : bd.getCategories()) {
            String message = c.getCategory_id() + " - " + c.getCategory();
            System.out.println(message);
        }
    }

    private static void getCategory(CategoryRegistrador bd) {
        System.out.println("- Buscar categoría por id");
        System.out.println("Ingrese el id que quiere buscar:");
        int id = scanner.nextInt();
        Category category = bd.getCategory(id);
        if (category != null) {
            String message = category.getCategory_id() + " - " + category.getCategory();
            System.out.println(message);
        } else {
            System.out.println("No existe una categoria con el id ingresado");
        }
    }

    private static void deleteCategory(CategoryRegistrador bd) {
        System.out.println("- Eliminar categoría");
        System.out.println("Escribe el id de la categoria que quiere eliminar:");
        int id = scanner.nextInt();
        bd.deleteCategory(id);
    }
    
}
