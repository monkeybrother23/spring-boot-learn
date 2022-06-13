package com.albert.learn.jdbc.model;

import java.util.StringJoiner;

/**
 * @author Albert
 * @date 2022/6/13
 */
public class UserModel {
    private String id;
    private String name;
    private String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserModel.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("age='" + age + "'")
                .toString();
    }
}
