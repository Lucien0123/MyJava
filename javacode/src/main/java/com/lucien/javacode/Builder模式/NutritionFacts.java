package com.lucien.javacode.Builder模式;

/**
 * Created by lucien on 2017/11/22.
 * 营养成分
 *
 * 构建器模式：如果类的构造器或者静态工厂有很多的参数（超过四个），并且有些参数在大多是情况下是可选则赋值时；
 * 推荐使用构建器。
 * JavaBeans模式阻止了把类做成不可变的可能，需要程序猴花费额外的时间来确保它的线程安全:
 *
 */
public class NutritionFacts {

    /* 将类的属性设置为final的目的是实现不可变类，
     * 该类的每个实例都必须在创建的时候就提供，并在整过对象的生命周期内固定不变 */
    private final int servingSize;
    private final int servings;
    private final int calories;  //卡路里
    private final int fat;       //脂肪
    private final int sodium;    //纳
    private final int carbohydrate; //碳水化合物，糖

    public static class Builder{
        // necessary params
        private final int servingSize;
        private final int servings;

        // optional params
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate;

        public Builder (int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
