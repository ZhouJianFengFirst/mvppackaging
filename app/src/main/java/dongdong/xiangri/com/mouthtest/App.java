package dongdong.xiangri.com.mouthtest;

import android.app.Application;

import dongdong.xiangri.com.mouthtest.net.Http;
import dongdong.xiangri.com.mouthtest.net.HttpHelper;

public  class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.getInstenes().init(Http.BASE_URL);
    }
}
