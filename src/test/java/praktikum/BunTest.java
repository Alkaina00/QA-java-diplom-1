package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {null, 3.0f},
                {"", Float.MIN_VALUE},
                {"unknown", Float.MAX_VALUE},
                {"$#%#^#&#$%", 0.0f},
                {"1234", 0.0f},
                {"$^$_BigBun343455344345344434579385793gggggggggg", 3.0f}
        };
    }

    @Before
    public void setup(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest(){
        String resultName = bun.getName();
        Assert.assertEquals("Наименование булочки не соответствует ожидаемому!", name, resultName);
    }

    @Test
    public void getPriceTest(){
        float resultPrice = bun.getPrice();
        Assert.assertEquals("Цена булочки не соответствует ожидаемому!", price, resultPrice, 0.0f);
    }
}
