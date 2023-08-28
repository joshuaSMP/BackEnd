import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Clase que modela los registros
 */
public class CategoryRegistrador {
    
    private List<Category> categories;
    /**
     * Metodo constructor vacio
     */
    public CategoryRegistrador(){
        this.categories = new ArrayList<>();
    }
    /**
     * Metodo que crea una categoria
     * @param category
     */
    public void createCategory(Category category){
        List<Category> withSameId = categories.stream().filter((t) -> t.getCategory_id() == category.getCategory_id()).collect(Collectors.toList());
        if(withSameId.isEmpty()){
            categories.add(category);
        }
    }
    /**
     * Metodo que enlista las categorias registradas
     */
    public List<Category> getCategories(){
        return categories;
    }
    /**
     * Metodo que regresa las categorias 
     * @param categoryId
     * @return la lista de categorias
     */
    public Category getCategory(int categoryId){
        List<Category> withSameId = categories.stream().filter(c -> c.getCategory_id() == categoryId).collect(Collectors.toList());
        if(withSameId.isEmpty()) return null;
        else return withSameId.get(0);
    }
    /**
     * Metodo que elimina una categoria
     * @param categoryId
     */
    public void deleteCategory(int categoryId){
        categories.removeIf(c -> c.getCategory_id() == categoryId);
    }   
}
