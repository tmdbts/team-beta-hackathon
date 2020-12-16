package org.academiadecodigo.jupiter.persistance.dao;

import java.util.List;

public interface Dao<T extends Model> {


        // Gets a list of the model type
        List<T> findAll();


        //Gets the model
        T findById(Integer id);


        // Saves or updates the model
        T saveOrUpdate(T modelObject);


        // Deletes the model
        void delete(Integer id);


        //Filter recipes with ids
        List<T> shuffleRecipesById(List<Integer> blackListedIds, List<Integer> recipeIds);

}
