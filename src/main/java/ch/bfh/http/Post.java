package ch.bfh.http;

import javax.swing.text.html.HTML;
import java.util.Date;

public class Post {
    private String id;
    private String name;
    private String firstName;
    private String zip;
    private String city;

    public Post() {

    }

    public Post(String title, String description, String content, String city) {
        this.name = title;
        this.firstName = description;
        this.zip = content;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

