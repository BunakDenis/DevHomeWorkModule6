package global.goit.edu.db;

import global.goit.edu.enterprise.LongestProject;
import global.goit.edu.prefs.Prefs;

import java.sql.ResultSet;
import java.time.LocalDate;
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
                .read(new Prefs().getPrefValue(Prefs.QUERY_FIND_LONGEST_PROJECT));

        ResultSet rs = db.executeQuery(sql);

        try {
            while (rs.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setName(rs.getString("name"));
                longestProject.setMonthCount(LocalDate.parse(rs.getString("month_count")));
                result.add(longestProject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}