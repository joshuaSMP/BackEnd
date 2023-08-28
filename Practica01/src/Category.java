/**
 * Clase Category 
 */
public class Category{
        /** Atributos*/
        private int category_id;
        private String category;
        private String acronym;
        /**
         * Metodo constructor por parametros que recive
         * @param int category_id
         * @param String category
         * @param String acronym
         */
        public Category(int category_id, String category){
            this.category_id = category_id;
            this.category = category;
        }
        /**
         * Metodo que regresa el valor de category_id
         * @return
         */
        public int getCategory_id() {
            return category_id;
        /**
         * Metodo que modifica category_id
         */
        }
        public void setCategory_id(int categoryId) {
            this.category_id = categoryId;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getAcronym() {
            return acronym;
        }
        public void setAcronym(String acronym) {
            this.acronym = acronym;
        }

}
