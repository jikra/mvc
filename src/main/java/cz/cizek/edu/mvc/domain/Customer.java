package cz.cizek.edu.mvc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cz.cizek.edu.mvc.utility.JsonLocalDateDeserializer;

import java.time.LocalDate;

/**
 * @author jiricizek <jiri.cizek@cleverlance.com>
 */
public class Customer {

    private String name;
    private int age;
    private LocalDate birth;

    @JsonSerialize(using = JsonLocalDateDeserializer.class)
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("firstName")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
