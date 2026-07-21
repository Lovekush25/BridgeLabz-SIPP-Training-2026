public class MealGenerator {

    public static <T extends MealPlan> void generateMeal(Meal<T> meal) {
        System.out.println("Generated Meal Plan : " + meal.getMealPlan().getMealType());
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegetarian =
                new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> vegan =
                new Meal<>(new VeganMeal());

        Meal<KetoMeal> keto =
                new Meal<>(new KetoMeal());

        vegetarian.displayMeal();
        vegan.displayMeal();
        keto.displayMeal();

        System.out.println();

        generateMeal(vegetarian);
        generateMeal(vegan);
        generateMeal(keto);
    }
}