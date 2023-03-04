package com.recipe.manager.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.recipe.manager.server.api.RecipeApi;
import com.recipe.manager.server.model.Recipe;
import com.recipe.manager.service.RecipeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecipeController implements RecipeApi {

  private final RecipeService recipeService;

  @Override
  public ResponseEntity<Void> addRecipes(Recipe recipe) {
    log.trace("method called: addRecipes");
    recipeService.addRecipe(recipe);
    return new ResponseEntity<>(CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteRecipe(Integer id) {
    log.trace("method called: deleteRecipe");
    recipeService.deleteRecipe(id);
    return new ResponseEntity<>(NO_CONTENT);
  }

  @Override
  public ResponseEntity<Recipe> getRecipeById(Integer id) {
    log.trace("method called: getRecipeById");
    return ResponseEntity.ok(recipeService.getRecipeById(id));
  }

  @Override
  public ResponseEntity<List<Recipe>> getRecipes() {
    log.trace("method called: getRecipes");
    return ResponseEntity.ok(recipeService.getRecipes());
  }

  @Override
  public ResponseEntity<List<Recipe>> searchRecipes(Boolean isVeg, Integer serving,
      List<String> includedIngredients, List<String> excludedIngredients,
      String searchInstructions) {
    log.trace("method called: searchRecipes");
    return ResponseEntity.ok(recipeService
        .searchRecipe(isVeg, serving, includedIngredients, excludedIngredients, searchInstructions));
  }

  @Override
  public ResponseEntity<Void> updateRecipes(Integer id, Recipe recipe) {
    log.trace("method called: updateRecipes");
    recipeService.updateRecipes(id, recipe);
    return new ResponseEntity<>(OK);
  }
}
