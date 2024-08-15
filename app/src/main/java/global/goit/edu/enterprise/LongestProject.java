package global.goit.edu.enterprise;

import java.time.LocalDate;
import java.util.Objects;

public class LongestProject {

    private String name;
    private long monthCount;

    public LongestProject() {

    }
    public LongestProject(String name, long monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(long monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongestProject that = (LongestProject) o;
        return monthCount == that.monthCount && Objects.equals(name, that.name);
    }
}
