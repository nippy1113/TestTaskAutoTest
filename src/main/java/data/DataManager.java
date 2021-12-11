package data;

public class DataManager {
    private static DataManager INSTANCE = null;

    private DataManager() {
    }

    /**
     * Метод ленивой инициализации веб драйвера
     *
     * @return WebDriver - возвращает веб драйвер
     */
    public static DataManager getDataManager() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

}
