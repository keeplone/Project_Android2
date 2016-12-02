package com.example.keeplone.project_android2;

import java.util.List;

/**
 * Created by keeplone on 02/12/2016.
 */

public class FoodResult {

    private List<FoodsBean> foods;

    public List<FoodsBean> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodsBean> foods) {
        this.foods = foods;
    }

    public static class FoodsBean {
        /**
         * id : 1
         * menu : Individual Egg & Spinach Bowls
         * directions : Whisk together all ingredients in a medium mixing bowl. Lightly mist 4 (1\/2 cup) ramekins with nonstick cooking spray and evenly divide egg mixture into bowls.
         * food_img : http://www.office365thailand.com/food/Egg.jpg
         */

        private String id;
        private String menu;
        private String directions;
        private String food_img;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMenu() {
            return menu;
        }

        public void setMenu(String menu) {
            this.menu = menu;
        }

        public String getDirections() {
            return directions;
        }

        public void setDirections(String directions) {
            this.directions = directions;
        }

        public String getFood_img() {
            return food_img;
        }

        public void setFood_img(String food_img) {
            this.food_img = food_img;
        }
    }
}
