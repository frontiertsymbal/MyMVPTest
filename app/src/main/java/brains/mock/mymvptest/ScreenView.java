package brains.mock.mymvptest;

public interface ScreenView {

    void showSomeMessage(String message);

    void showLoading();

    void hideLoading();

    void clearText();
}
