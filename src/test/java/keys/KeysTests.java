package keys;

import DataProvider.DataProviderClass;
import HelpClasses.WriteCsvFile;
import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    static List<String[]> csvLines = new ArrayList<String[]>();

    @Test(dataProviderClass = DataProviderClass.class , dataProvider = "Data")
    public void testBackspace(String name){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText(name);
        String[] lineDetails = {name, keyPage.getResult().substring(keyPage.getResult().length() - 1)};
        csvLines.add(lineDetails);

    }

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {

        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    /*
    * This test to take screenshot
    */
    @Test
    public void testScrollToSeventhParagraphAndFailed() {

        homePage.clickInfiniteScroll().scrollToParagraph(7);
        Assert.fail();
    }
    @AfterClass
    public static void afterClass() {
        String[] headers = {"Name","Last letter"};
        WriteCsvFile.writeDataLineByLine("resources/Files/output.csv", csvLines, headers);
    }
}
