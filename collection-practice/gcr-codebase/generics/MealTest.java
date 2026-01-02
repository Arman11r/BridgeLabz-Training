// meal interface
interface MealPlan {
    void showMeal();
}

// meal types
class VegetarianMeal implements MealPlan{
    public void showMeal () {
        System.out.println(" vegetarian meal ");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal () {
        System.out.println("keto meal " );
    }
}

// generic meal handler
class Meal <T extends MealPlan>{
    T meal;

    Meal(T meal ) {
        this.meal = meal;
    }

    void serveMeal () {
        meal.showMeal ();
    }
}

public class MealTest{

    // generic method
    static <T extends MealPlan> void generateMeal (T m){
        m.showMeal() ;
    }

    public static void main(String[] args ) {

        Meal<VegetarianMeal> veg = new Meal<> (new VegetarianMeal());
        Meal<KetoMeal> keto = new Meal<>  (new KetoMeal());

        veg.serveMeal() ;
        generateMeal(new KetoMeal());
    }
}