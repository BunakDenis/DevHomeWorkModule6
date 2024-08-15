package global.goit.edu.enterprise;

import java.time.LocalDate;
import java.util.Objects;

public class YoungestEldestWorker {

    private String type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorker() {

    }

    public YoungestEldestWorker(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YoungestEldestWorker that = (YoungestEldestWorker) o;
        return Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, birthday);
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
