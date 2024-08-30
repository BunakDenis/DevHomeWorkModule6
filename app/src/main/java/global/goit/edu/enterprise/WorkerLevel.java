package global.goit.edu.enterprise;

public enum WorkerLevel {

    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    private String level;

    WorkerLevel (String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "WorkerLevel{" +
                "level='" + level + '\'' +
                '}';
    }
}
