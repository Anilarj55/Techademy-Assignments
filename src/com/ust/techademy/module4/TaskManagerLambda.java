package com.ust.techademy.module4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@FunctionalInterface
interface TaskOperation {
    void perform(Task task);
}

class TaskManagerLambda {
    private List<Task> tasks;

    public TaskManagerLambda() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayTasks() {
        tasks.forEach(System.out::println);
    }

    public List<Task> filterTasks(Predicate<Task> condition) {
        return tasks.stream().filter(condition).collect(Collectors.toList());
    }

    public List<Task> sortTasksByDueDate() {
        return tasks.stream().sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate())).collect(Collectors.toList());
    }

    public static void main(String[] args) {
    	TaskManagerLambda manager = new TaskManagerLambda();
        manager.addTask(new Task("Complete project", new Date()));
        manager.addTask(new Task("Study for exams", new Date(System.currentTimeMillis() + 86400000))); // 1 day later

        System.out.println("All Tasks:");
        manager.displayTasks();

        System.out.println("\nFiltered Tasks (due today):");
        List<Task> filteredTasks = manager.filterTasks(task -> task.getDueDate().before(new Date(System.currentTimeMillis() + 86400000)));
        filteredTasks.forEach(System.out::println);

        System.out.println("\nSorted Tasks by Due Date:");
        List<Task> sortedTasks = manager.sortTasksByDueDate();
        sortedTasks.forEach(System.out::println);
    }
}
