package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage{
    public TablePage(WebDriver driver){
        super(driver);
    }

    private final ArrayList<String> columnHeaders = new ArrayList<String>(
            List.of("Grupa kategorii", "Nazwa kategorii", "Stawka prowizji w procentach")
    );

    private final Integer numberOfRows = 2163;

    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    @FindBy(tagName = "td")
    private List<WebElement> cell;

//    public void fulfillTable(){
//        for(WebElement row : rows){
//            List<WebElement> cellsInRow = row.findElements(By.tagName("td"));
//            System.out.println(cellsInRow.get(1).getText());
//        }
//    }

    public ArrayList<String> getColumnHeaders() {
        return columnHeaders;
    }

    public Integer getNumberOfRows(){
        return numberOfRows;
    }

    public ArrayList<String> getRowData(int rowNumber){
        if(rowNumber>rows.size()){
            System.out.println("Table doesn't contain so much rows. Number of rows: " + rows.size());
        }

        List<WebElement> cellsInRow2 = rows.get(rowNumber-1).findElements(By.tagName("td"));
        ArrayList<String> arrayList= new ArrayList<>();
        cellsInRow2.stream()
                .map(cell -> cell.getText().trim())
                .forEach(arrayList::add);
        return arrayList;
    }

    public List<WebElement> getRow(){
        return rows;
    }

    public List<WebElement> getCell(){
        return cell;
    }

    @Override
    public void waitForPageToBeLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), \"Kontakt\")]/following-sibling::div")));
    }
}
