package global.goit.edu.enterprise;

import java.util.Objects;

public class ProjectPrice {

    private int projectId;
    private long price;

    public ProjectPrice() {

    }

    public ProjectPrice(int projectId, long price) {
        this.projectId = projectId;
        this.price = price;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPrice that = (ProjectPrice) o;
        return projectId == that.projectId && price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, price);
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
