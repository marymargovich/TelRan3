package telran.mvc;

import telran.mvc.controller.TaskController;
import telran.mvc.model.services.TaskModel;
import telran.mvc.view.TaskView;

public class MVCAppl {
    public static void main(String[] args) {


        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        controller.start();

    }
}
