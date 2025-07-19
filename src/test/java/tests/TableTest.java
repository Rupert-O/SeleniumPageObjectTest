package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TablePage;

public class TableTest extends BaseTest{
    String tableURL = "https://www.morele.net/pokaz_pomoc/976/";
    @Test
    public void verifyColumnNames(){
        driver.get(tableURL);
        TablePage table = new TablePage(driver);
        Assert.assertEquals(table.getRowData(1), table.getColumnHeaders(),
                "Column Headers doesn't match to pattern");
        for(String value : table.getRowData(1)){
            System.out.println(value);
        }
    }

    @Test
    public void verifyNumberOfRowsWithHeader(){
        driver.get(tableURL);
        TablePage table = new TablePage(driver);
        Assert.assertEquals(table.getRow().size(), table.getNumberOfRows(),
                "Incorrect number of rows in table");
    }
}
