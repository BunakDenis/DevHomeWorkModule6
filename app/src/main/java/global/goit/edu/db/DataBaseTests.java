package global.goit.edu.db;


import global.goit.edu.enterprise.LongestProject;

import java.util.List;

public class DataBaseTests {

    public static void main(String[] args) {
/*        DatabaseInitService.main(null);
        DatabasePopulateService.main(null);*/

        DatabaseQueryService dbQueryService = new DatabaseQueryService(Database.getInstance());

        List<LongestProject> longestProject = dbQueryService.findLongestProject();

        longestProject.forEach(System.out::println);

    }
}