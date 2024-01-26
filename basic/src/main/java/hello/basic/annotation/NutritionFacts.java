package hello.basic.annotation;

import lombok.Builder;

public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;

    @Builder
    public NutritionFacts(int servingSize) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = 0;
        this.fat = 0;
    }


}