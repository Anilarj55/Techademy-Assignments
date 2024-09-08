package com.ust.techademy.module4;

import java.util.Date;

public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager(int size) {
        tasks = new Task[size];
        taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount++] = task;
        } else {
            System.out.println("Task list is full");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskCount) {
            for (int i = index; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[--taskCount] = null;
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager(5);
        System.out.println("Tasks");
        manager.addTask(new Task("Complete project", new Date()));
        manager.addTask(new Task("Study for exams", new Date()));
        manager.displayTasks();
        
        System.out.println("After Task removal");
        manager.removeTask(0);
        manager.displayTasks();
    }
}