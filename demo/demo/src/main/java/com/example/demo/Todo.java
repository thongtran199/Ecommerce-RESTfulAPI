package com.example.demo;

public class Todo {
    public String title;
    public String content;
    public Todo(){}

    public Todo(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
