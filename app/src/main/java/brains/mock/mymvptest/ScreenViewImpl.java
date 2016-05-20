package brains.mock.mymvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ScreenViewImpl extends AppCompatActivity implements ScreenView, View.OnClickListener {
    
    private ScreenPresenter mScreenPresenter;

    private TextView vText;
    private Button vButtonStart;
    private Button vButtonClear;
    private ProgressBar vProgressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreenPresenter = new ScreenPresenterImpl(this);

        vText = (TextView) findViewById(R.id.text);
        vButtonStart = (Button) findViewById(R.id.buttonStart);
        vButtonClear = (Button) findViewById(R.id.buttonClear);
        vProgressBar = (ProgressBar) findViewById(R.id.progress);

        vButtonStart.setOnClickListener(this);
        vButtonClear.setOnClickListener(this);
    }

    @Override
    public void showSomeMessage(String message) {
        vText.setText(message);
    }

    @Override
    public void showLoading() {
        vProgressBar.setVisibility(View.VISIBLE);
        vButtonStart.setVisibility(View.GONE);
        vButtonClear.setVisibility(View.GONE);
        vText.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        vProgressBar.setVisibility(View.GONE);
        vButtonStart.setVisibility(View.VISIBLE);
        vButtonClear.setVisibility(View.VISIBLE);
        vText.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearText() {
        vText.setText("");
    }

    // TODO AlexTsymbal: probably it makes sense to implement clickListener in presenter!?!?!?
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStart:
                mScreenPresenter.onStartButtonClicked();
                break;
            case R.id.buttonClear:
                mScreenPresenter.onClearButtonClicked();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mScreenPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mScreenPresenter.onStop();
    }
}
