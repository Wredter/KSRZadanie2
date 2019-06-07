package KSRZadanie2.View;

public class MainController {
    DataContext dataContext;

    public MainController() {
        dataContext = new DataContext();
    }

    public void ResetDataContext() {
        dataContext = new DataContext();
    }
}
