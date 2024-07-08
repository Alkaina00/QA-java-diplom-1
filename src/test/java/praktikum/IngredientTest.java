package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final String nameIngredient;
    private final float priceIngredient;
    private IngredientType ingredientType;

    public IngredientTest(String nameIngredient, float priceIngredient, IngredientType ingredientType){
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {null, 3.0f, null},
                {"", Float.MIN_VALUE, IngredientType.SAUCE},
                {"unknown", Float.MAX_VALUE, IngredientType.FILLING},
                {"$#%#^#&#$%", 0.0f, IngredientType.FILLING},
                {"1234", 0.0f, IngredientType.FILLING},
                {"$^$_BigBun343455344345344434579385793gggggggggg", 3.0f, IngredientType.FILLING}
        };
    }

    @Before
    public void setup(){
        ingredient = new Ingredient(ingredientType, nameIngredient, priceIngredient);
    }

    @Test
    public void getNameTest(){
        String resultName = ingredient.getName();
        Assert.assertEquals("Наименование ингредиента не соответствует ожидаемому!", nameIngredient, resultName);
    }

    @Test
    public void getPriceTest(){
        float resultPrice = ingredient.getPrice();
        Assert.assertEquals("Цена ингредиента не соответствует ожидаемому!", priceIngredient, resultPrice, 0.0f);
    }

    @Test
    public void getTypeTest(){
        IngredientType resultType = ingredient.getType();
        Assert.assertEquals("Тип ингредиента не соответствует ожидаемому!", ingredientType, resultType);
    }
}
