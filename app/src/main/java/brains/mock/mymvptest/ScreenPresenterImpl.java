package brains.mock.mymvptest;

public class ScreenPresenterImpl implements ScreenPresenter, ScreenModelCallback {

    private ScreenView mScreenView;
    private ScreenModel mScreenModel;

    public ScreenPresenterImpl(ScreenView mScreenView) {
        this.mScreenView = mScreenView;
    }

    @Override
    public void onStart() {
        mScreenModel = new ScreenModelImpl(this);
    }

    @Override
    public void onStop() {
        mScreenModel = null;
    }

    @Override
    public void onClearButtonClicked() {
        mScreenView.clearText();
        mScreenModel.clear();
    }

    @Override
    public void onStartButtonClicked() {
        mScreenView.showLoading();
        mScreenModel.getMessage();
    }

    @Override
    public void resultText(String resultText) {
        mScreenView.hideLoading();
        mScreenView.showSomeMessage(resultText);
    }
}
