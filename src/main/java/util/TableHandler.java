package util;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byTagName;

public class TableHandler {
    public static SelenideElement findCellByLabels(String verticalLabel,
                                                   String horizontalLabel,
                                                   SelenideElement table){
        int verticalIndex = 1;
        SelenideElement tableBody = table.$(byCssSelector("tbody.track--pricing-body"));
        ElementsCollection rows = tableBody.$$(byTagName("tr"));
        for (SelenideElement row :
                rows) {
            SelenideElement currentVerticalLabel = row.$$(byTagName("td")).first();
            if (currentVerticalLabel.innerText().contains(verticalLabel)){
                break;
            }
            else {
                verticalIndex++;
            }
        }

        int horizontalIndex = 1;
        SelenideElement tableHead = table.$(byCssSelector("thead.track--pricing-head")).$(byCssSelector("tr.Pricings-name"));
        ElementsCollection tableHeaders = tableHead.$$(byTagName("th"));
        for (SelenideElement tableHeader :
                tableHeaders) {
            if (tableHeader.innerText().contains(horizontalLabel)){
                break;
            }
            else {
                horizontalIndex++;
            }
        }

        return tableBody.$x(String.format(".//tr[%d]/td[%d]", verticalIndex, horizontalIndex));
    }


}