package global.goit.edu.enterprise;

import java.time.LocalDate;

public class LongestProject {

    private String name;
    private LocalDate monthCount;

    public LongestProject() {

    }
    public LongestProject(String name, LocalDate monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(LocalDate monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
