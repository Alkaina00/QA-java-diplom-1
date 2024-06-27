package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    private final float price = 10.0f;


    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals("Булочка не соответствует ожидаемому!", bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        Assert.assertEquals("Ожидался 1 ингредиент!", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ожидалось 0 ингредиентов!", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals( 2, burger.ingredients.size());
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        float resultPrice = price*4;

        Assert.assertEquals("Цена не соответствует ожидаемому", resultPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest(){
        final String nameBun = "Big bun";
        final String nameIngredient = "hot sauce";

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        float resultPrice = price*3;
        String resultReceipt = String.format("(==== %s ====)\r\n= sauce %s =\r\n(==== %s ====)\r\n\r\nPrice: %.6f\r\n", nameBun, nameIngredient, nameBun, resultPrice);

        Assert.assertEquals("Рецепт не соответствует ожидаемому", resultReceipt, burger.getReceipt());
    }


}
