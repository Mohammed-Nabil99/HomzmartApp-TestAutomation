package Category;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTests extends BaseTests {

    @Test(priority = 1,alwaysRun = true)
    public void testFurnitureCategory() throws InterruptedException {
       var categoryPage= homePage.clickCategory();
       categoryPage.clickFurniture();
       categoryPage.clickShowResults();
       String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
       Assert.assertTrue(itemTxt.contains("Sofa") || itemTxt.contains("Bed") ||
               itemTxt.contains("Chair") || itemTxt.contains("Crib") || itemTxt.contains("Table"));
       categoryPage.clickHome();
    }

    @Test
    public void testStorageCategory() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickStorage();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Unit Drawer") || itemTxt.contains("Buffet") ||
                itemTxt.contains("Display Unit") || itemTxt.contains("Shoe Rack") ||
                itemTxt.contains("Bathroom Storage") || itemTxt.contains("Kitchen Storage") ||
                itemTxt.contains("Wardrobe") || itemTxt.contains("Dressing") ||
                itemTxt.contains("Clothes Hanger") || itemTxt.contains("Bookcase") ||
                itemTxt.contains("Commode") || itemTxt.contains("Makeup Vanity") ||
                itemTxt.contains("Coffee Corner"));
        categoryPage.clickHome();
    }

        @Test
    public void testHomeDecorCategory() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickHomeDecor();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Rugs") || itemTxt.contains("Decorative Accessories") ||
                itemTxt.contains("Tableware") || itemTxt.contains("Mirror") ||
                itemTxt.contains("Boho Decor") || itemTxt.contains("Door") ||
                itemTxt.contains("Pet Supply"));

    }

    @Test
    public void testOfficeFurnitureCategory() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickOfficeFurniture();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Office Chair") || itemTxt.contains("Wooden Desk") ||
                itemTxt.contains("Steel Desk") || itemTxt.contains("Office Furniture") ||
                itemTxt.contains("Office Storage") || itemTxt.contains("Office Accessory") ||
                itemTxt.contains("Gaming Furniture") || itemTxt.contains("Managers Desk") ||
                itemTxt.contains("Meeting Table") || itemTxt.contains("Work Station") ||
                itemTxt.contains("Reception Counter") || itemTxt.contains("Safebox") ||
                itemTxt.contains("Kids Office Furniture") || itemTxt.contains("Kids Office Chair") ||
                itemTxt.contains("Kids Desk")  || itemTxt.contains("Architectural Desk"));
    }

    @Test
    public void testLightingCategory() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickLighting();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Lamp") || itemTxt.contains("Light") ||
                itemTxt.contains("Chandelier") || itemTxt.contains("Spot") ||
                itemTxt.contains("Neon") || itemTxt.contains("Bulb") ||
                itemTxt.contains("LED"));
    }

    @Test
    public void testFabricAndBedding() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickFabricAndBedding();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("mattress") || itemTxt.contains("Pillow") ||
                itemTxt.contains("Steel Desk") || itemTxt.contains("Towel") ||
                itemTxt.contains("Cover") || itemTxt.contains("Curtain") ||
                itemTxt.contains("Cushion") || itemTxt.contains("Table Runner") ||
                itemTxt.contains("Wall Decor") || itemTxt.contains("protector") ||
                itemTxt.contains("cover") || itemTxt.contains("Blanket") ||
                itemTxt.contains("Bedding")|| itemTxt.contains("Mattress"));
    }

    @Test
    public void testKitchenAndBathroom() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickKitchenAndBathroom();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("CUP") || itemTxt.contains("Water") ||
                itemTxt.contains("Mug") || itemTxt.contains("Pan") ||
                itemTxt.contains("Bowl") || itemTxt.contains("Plate") ||
                itemTxt.contains("Dinnerware") || itemTxt.contains("Serveware") ||
                itemTxt.contains("Cooking") || itemTxt.contains("Kitchen") ||
                itemTxt.contains("Tray") || itemTxt.contains("Holder") ||
                itemTxt.contains("Coaster")|| itemTxt.contains("Serving") ||
                itemTxt.contains("Food") || itemTxt.contains("Board") ||
                itemTxt.contains("Shower") || itemTxt.contains("Bathtub") ||
                itemTxt.contains("Mirror") || itemTxt.contains("Bathroom"));
    }


    @Test
    public void testAppliances() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickAppliances();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Iron") || itemTxt.contains("Juicer") ||
                itemTxt.contains("Kettle") || itemTxt.contains("Vacuum") ||
                itemTxt.contains("Fryer") || itemTxt.contains("Filter") ||
                itemTxt.contains("Steamer") || itemTxt.contains("Food") ||
                itemTxt.contains("Oven") || itemTxt.contains("Blender") ||
                itemTxt.contains("Tea") || itemTxt.contains("Coffee") ||
                itemTxt.contains("Maker")|| itemTxt.contains("Grill") ||
                itemTxt.contains("Smoker") || itemTxt.contains("Cook") ||
                itemTxt.contains("Hood") || itemTxt.contains("Toaster") ||
                itemTxt.contains("Fan") || itemTxt.contains("Air") ||
                itemTxt.contains("Heater") || itemTxt.contains("Refrigerator") ||
                itemTxt.contains("Freezer") || itemTxt.contains("TV") ||
                itemTxt.contains("Dryer") || itemTxt.contains("Wash") ||
                itemTxt.contains("Water") || itemTxt.contains("Dispenser"));
    }


    @Test
    public void testSports() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickSports();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Treadmill") || itemTxt.contains("Bike") ||
                itemTxt.contains("Orbitrac") || itemTxt.contains("Machine") ||
                itemTxt.contains("Sport") || itemTxt.contains("machine") ||
                itemTxt.contains("Dummbell") || itemTxt.contains("Bar") ||
                itemTxt.contains("fitness") || itemTxt.contains("Sports") ||
                itemTxt.contains("Gym") || itemTxt.contains("Camping") ||
                itemTxt.contains("Rechargeable") ||  itemTxt.contains("الجيم") );
    }


    @Test
    public void tesElectronics() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickElectronics();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Power") || itemTxt.contains("Strip") ||
                itemTxt.contains("Security") || itemTxt.contains("Monitor") ||
                itemTxt.contains("Screen") || itemTxt.contains("Printer") ||
                itemTxt.contains("Connect") || itemTxt.contains("Keyboard") ||
                itemTxt.contains("Mouses") || itemTxt.contains("Audio") ||
                itemTxt.contains("Video") || itemTxt.contains("Speaker") ||
                itemTxt.contains("Theatre") ||  itemTxt.contains("Intercom") ||
                itemTxt.contains("Webcam") ||  itemTxt.contains("Console") ||
                itemTxt.contains("Cable") ||  itemTxt.contains("Gaming"));
    }

    @Test
    public void testOutdoors() throws InterruptedException {
        var categoryPage= homePage.clickCategory();
        categoryPage.clickOutdoors();
        categoryPage.clickShowResults();
        String itemTxt= categoryPage.getItemTxt();
        System.out.println(itemTxt);
        Assert.assertTrue(itemTxt.contains("Chair") || itemTxt.contains("Swing") ||
                itemTxt.contains("Outdoor") || itemTxt.contains("bag") ||
                itemTxt.contains("Bag") || itemTxt.contains("Tent") ||
                itemTxt.contains("Pergola") || itemTxt.contains("Keyboard") ||
                itemTxt.contains("Beach") || itemTxt.contains("Sofa") ||
                itemTxt.contains("Pool") || itemTxt.contains("Table") ||
                itemTxt.contains("Grill") ||  itemTxt.contains("Fountain") ||
                itemTxt.contains("Floater"));
    }
}
