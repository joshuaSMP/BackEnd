package com.product.api.entity;

/**
 * Clase Category 
 */
public class Category{
    /** Atributos*/
    private int category_id;
    private String category;
    private String acronym;
    private int status;
    /**
     * Metodo constructor por parametros que recive
     * @param int category_id
     * @param String category
     * @param String acronym
     */
    public Category(int category_id, String category, String acronym, int status){
        this.category_id = category_id;
        this.category = category;
        this.acronym = acronym;
        this.status = status;
    }
    /**
     * Metodo que regresa el valor de category_id
     * @return int category_id 
     */
    public int getCategory_id() {
        return category_id;
    }
    /**
     * Metodo que modifica la categoria 
     * @param category_id
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    /**
     * Metodo que regresa el valor de la category
     * @return String category 
     */
    public String getCategory() {
        return category;
    }
    /**
     * Metodo que modifica la category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * Metodo que regresa el valor de acronym
     * @return String acronym
     */
    public String getAcronym() {
        return acronym;
    }
    /**
     * Metodo que modifica el acronym 
     * @param acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    /**
     * Metofo que regresa el status 
     * @return int status
     */
    public int getStatus() {
        return status;
    }
    /**
     * Meotodo que modifica el valor de status 
     * @param int status
     */
    public void setStatus(int status){
        this.status = status;
    }
}
