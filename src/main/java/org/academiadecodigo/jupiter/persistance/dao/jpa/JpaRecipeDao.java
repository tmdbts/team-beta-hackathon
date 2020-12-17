package org.academiadecodigo.jupiter.persistance.dao.jpa;

import org.springframework.stereotype.Repository;

@Repository
public class JpaRecipeDao extends GenericJpaDao<Recipe> implements RecipeDao{

    public JpaRecipeDao() {super(Recipe.class);}
}

