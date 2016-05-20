package brains.mock.mymvptest;

import android.os.AsyncTask;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ScreenModelImpl implements ScreenModel {

    private ScreenModelCallback mScreenModelCallback;

    private ModelAsync mModelAsync;
    private Random mRandom = new Random();

    public ScreenModelImpl(ScreenModelCallback mScreenModelCallback) {
        this.mScreenModelCallback = mScreenModelCallback;
    }

    @Override
    public void getMessage() {
        mModelAsync = new ModelAsync();
        mModelAsync.execute();
    }

    @Override
    public boolean clear() {
        mModelAsync = null;
        return mRandom.nextBoolean();
    }

    private class ModelAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return String.valueOf(mRandom.nextInt(1000));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mScreenModelCallback.resultText(s);
        }
    }
}
