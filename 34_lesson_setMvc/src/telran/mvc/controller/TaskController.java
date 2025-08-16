package telran.mvc.controller;

import telran.mvc.model.entities.Task;
import telran.mvc.model.services.TaskModel;
import telran.mvc.view.TaskView;

import java.util.Scanner;

public class TaskController {
    private TaskModel model;
    private TaskView view;
    private Scanner scanner = new Scanner(System.in);

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void start(){
        view.showMessage("Task list(console version). Type 'help' for help"  );
        while (true){
            System.out.println(">>>");
            String input = scanner.nextLine();
            if(input == null) continue;
            input = input.trim();
            if(input.equalsIgnoreCase("exit")){
                view.showMessage("Bye");
                break;
            } else if (input.equalsIgnoreCase("help"))
                view.showHelp();
            else if (input.equalsIgnoreCase("list"))
                view.showTasks(model.getTasks());
            else if (input.isEmpty())
                view.showMessage("Empty task not added! please enter text ");
            else {
                model.addTask(new Task( input));
                view.showMessage("Task added");
                view.showTasks(model.getTasks());

            }

        }

    }


}
