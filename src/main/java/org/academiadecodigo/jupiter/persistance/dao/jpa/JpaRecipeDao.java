package org.academiadecodigo.jupiter.persistance.dao.jpa;

public class JpaRecipeDao extends GenericJpaDao<Recipe> implements RecipeDao{

    public JpaRecipeDao() {super(Recipe.class);}
}

