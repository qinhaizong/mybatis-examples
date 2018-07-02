package org.haizong.mybatis.example;

public class City {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "state='" + state + '\'' +
                '}';
    }
}
