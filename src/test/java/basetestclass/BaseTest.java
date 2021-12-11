package basetestclass;

import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropertieManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static utils.PropertieConstants.BASE_URL;

public class BaseTest {
    /**
     * Менеджер страничек
     * @see PageManager#getPageManager()
     */
    protected PageManager pageManager = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(PropertieManager.getPropertieManager().getProperty(BASE_URL));
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
