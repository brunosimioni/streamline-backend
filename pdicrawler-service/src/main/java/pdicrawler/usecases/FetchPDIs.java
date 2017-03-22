package pdicrawler.usecases;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pdicrawler.interfaces.GoogleSheetsAdapter;

import java.util.List;

/**
 * Created by bsimioni on 21/03/17.
 */
@Component
public class FetchPDIs {

    @Autowired
    GoogleSheetsAdapter sheetsAdapter;

    public void fetchPdi() {
        try
        {
            Sheets service = sheetsAdapter.getSheetsService();

            String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
            String range = "Class Data!A2:E";
            ValueRange response = service.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
            List<List<Object>> values = response.getValues();
            if (values == null || values.size() == 0) {
                System.out.println("No data found.");
            } else {
                System.out.println("Name, Major");
                for (List row : values) {
                    // Print columns A and E, which correspond to indices 0 and 4.
                    System.out.printf("%s, %s\n", row.get(0), row.get(4));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
