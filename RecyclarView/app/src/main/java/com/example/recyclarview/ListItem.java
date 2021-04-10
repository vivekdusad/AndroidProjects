package com.example.recyclarview;

public class ListItem {
    private String heading;
    private String description;

    public ListItem(String item, String description) {
        this.heading = item;
        this.description = description;
    }

    public void ListItem(String heading,String description){

    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
