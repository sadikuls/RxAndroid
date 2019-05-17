package com.sadikul.sample.rxandroid.Model;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    /***
     * Create arraylist on Type Task
     * add all task to list
     * @return task as list
     */
    public static List<Task> getObserList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Talk out the trash",false,3));
        tasks.add(new Task("Make my bed",true,2));
        tasks.add(new Task("Feed me",true,1));
        tasks.add(new Task("Take a long sleep",true,4));
        return  tasks;
    }
}
