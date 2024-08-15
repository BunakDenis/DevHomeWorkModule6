package global.goit.edu.enterprise;

import java.util.Objects;

public class MaxProjectsClient {

    private String name;
    private int projectCount;

    public MaxProjectsClient() {

    }
    public MaxProjectsClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxProjectsClient client = (MaxProjectsClient) o;
        return projectCount == client.projectCount && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectCount);
    }

    @Override
    public String toString() {
        return "MaxProjectClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
