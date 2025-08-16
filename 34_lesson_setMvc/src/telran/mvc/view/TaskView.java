package telran.mvc.view;

import telran.mvc.model.entities.Task;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskView {
    private static  final DateTimeFormatter FMT
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public void showTasks(List<Task> tasks){
        if( tasks == null || tasks.isEmpty()){
            System.out.println("the Task list is empty\n");
            return;
        }
        System.out.println("Task list: ");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("%d. %s at [%s]\n", 1+i, t.getContent(), t.getCreatedAt().format(FMT));
        }
        System.out.println();

        // %d = целые числа
        // %s = стринги
        // %c = чары
        // %f = даблы и флоаты %.2f = два знака после запятой

    }
    public void showMessage( String message){
        System.out.println(message);
    }
    public void showHelp(){
        System.out.println("""
                Commands:
                - just text - add task
                - list - show task list
                - help - show help
                - exit - exit
                """);
    }
}
