package com.lucien.javacode.Builder模式;

/**
 * Created by lucien on 2017/11/22.
 */
public class BuilderClient {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(11, 11)
                .calories(1).fat(12).build();
        System.out.println(nutritionFacts.toString());
    }
}
