package model;

public class classesModel {
    String Name;
    String Code;
    String Link;
    String Teacher;
    String Time;

    public classesModel() {
    }

    public classesModel(String name, String code, String link, String teacher,String time) {
        Name = name;
        Code = code;
        Link = link;
        Teacher = teacher;
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

}
