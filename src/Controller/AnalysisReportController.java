package Controller;

public class AnalysisReportController {

    public static void generateReport(String selectedItem){
        String query = "SELECT " + selectedItem  + ", COUNT(*) FROM BOOK" + "GROUP BY BOOKNAME,AUTHOR,PUBLISHER,CATEGORY";
    }


}
