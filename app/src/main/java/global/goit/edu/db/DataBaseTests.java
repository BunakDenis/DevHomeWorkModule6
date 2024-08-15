package global.goit.edu.db;


import global.goit.edu.enterprise.LongestProject;
import global.goit.edu.enterprise.MaxProjectsClient;
import global.goit.edu.enterprise.MaxSalaryWorker;
import global.goit.edu.enterprise.YoungestEldestWorker;

import java.util.List;

public class DataBaseTests {

    public static void main(String[] args) {
/*        DatabaseInitService.main(null);
        DatabasePopulateService.main(null);*/

        DatabaseQueryService dbQueryService = new DatabaseQueryService(Database.getInstance());

        List<LongestProject> longestProject = dbQueryService.findLongestProject();
        longestProject.forEach(System.out::println);

        List<MaxProjectsClient> maxProjectsClient = dbQueryService.findMaxProjectsClient();
        maxProjectsClient.forEach(System.out::println);

        List<MaxSalaryWorker> maxSalaryWorkers = dbQueryService.findMaxSalaryWorker();
        maxSalaryWorkers.forEach(System.out::println);

        List<YoungestEldestWorker> youngestEldestWorkers = dbQueryService.findYoungestEldestWorkers();
        youngestEldestWorkers.forEach(System.out::println);

        dbQueryService.printProjectPrices();

    }
}