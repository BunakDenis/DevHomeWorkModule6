package global.goit.edu.db;

import global.goit.edu.enterprise.*;
import global.goit.edu.prefs.Prefs;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private Database db;

    public DatabaseQueryService(Database db) {
        this.db = db;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String sql = new SqlFileReader()
                .read(new Prefs().getPrefValue(Prefs.QUERY_FIND_LONGEST_PROJECT_FILE_PATH));

        try {
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setName(rs.getString("name"));
                longestProject.setMonthCount(rs.getLong("month_count"));
                result.add(longestProject);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        List<MaxProjectsClient> result = new ArrayList<>();

        String sql = new SqlFileReader()
                .read(new Prefs().getPrefValue(Prefs.QUERY_FIND_MAX_PROJECTS_CLIENT_FILE_PATH));

        try {
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                MaxProjectsClient client = new MaxProjectsClient();
                client.setName(rs.getString("name"));
                client.setProjectCount(rs.getInt("project_count"));
                result.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();

        try {

            String sql = new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.QUERY_FIND_MAX_SALARY_WORKER_FILE_PATH)
            );
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();

                maxSalaryWorker.setName(rs.getString("name"));
                maxSalaryWorker.setSalary(rs.getInt("salary"));
                result.add(maxSalaryWorker);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> result = new ArrayList<>();

        try {

            String sql = new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.QUERY_FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH)
            );

            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                YoungestEldestWorker worker = new YoungestEldestWorker();

                worker.setType(rs.getString("type"));
                worker.setName(rs.getString("name"));
                worker.setBirthday(rs.getDate("birthday").toLocalDate());

                result.add(worker);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void printProjectPrices() {
        List<ProjectPrice> projectPrices = new ArrayList<>();

        try {
            String sql = new SqlFileReader().read(
                    new Prefs().getPrefValue(Prefs.QUERY_PRINT_PROJECT_PRICES_FILE_PATH)
            );

            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                ProjectPrice projectPrice = new ProjectPrice();

                projectPrice.setProjectId(rs.getInt("project_id"));
                projectPrice.setPrice(rs.getInt("price"));
                projectPrices.add(projectPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        projectPrices.forEach(System.out::println);
    }
}