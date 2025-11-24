package KI_301.Shamryk.Lab6;

/**
 * Головний клас-драйвер для тестування параметризованого сховища.
 */
public class Lab6Driver {
    public static void main(String[] args) {
        
        System.out.println("============== ТЕСТ 1: ТЕЛЕВІЗОРИ ==============");
        GoodsStorage<TvSet> techWarehouse = new GoodsStorage<>();

        techWarehouse.addItem(new TvSet("Samsung", 500));
        techWarehouse.addItem(new TvSet("LG", 450));
        techWarehouse.addItem(new TvSet("Sony", 900)); 

        techWarehouse.printStorage();

        
        TvSet mostExpensive = techWarehouse.findMax();
        System.out.println("Найдорожчий телевізор: " + mostExpensive);
        
        // Видаляємо один
        techWarehouse.removeItem(1); // Видалити LG


        
        System.out.println("\n============== ТЕСТ 2: МЕБЛІ ==============");
        GoodsStorage<Furniture> furnitureWarehouse = new GoodsStorage<>();

        furnitureWarehouse.addItem(new Furniture("Стіл", 75));
        furnitureWarehouse.addItem(new Furniture("Шафа", 200)); // Найвища
        furnitureWarehouse.addItem(new Furniture("Стілець", 45));

        furnitureWarehouse.printStorage();

        Furniture highest = furnitureWarehouse.findMax();
        System.out.println("Найвищі меблі: " + highest);
    }
}