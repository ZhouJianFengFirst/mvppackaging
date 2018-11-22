package dongdong.xiangri.com.mouthtest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import dongdong.xiangri.com.mouthtest.base.BaseActivity;
import dongdong.xiangri.com.mouthtest.mvp.model.MainModel;
import dongdong.xiangri.com.mouthtest.presenter.MainPresenter;
import dongdong.xiangri.com.mouthtest.view.MainView;

public class MainActivity extends BaseActivity<MainModel, MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.getShopCarNet();
    }
    @Override
    public MainModel createModel() {

        return new MainModel();
    }
    @Override
    public MainView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setShopCarString(String data) {
        Log.d("Tagger", data + ">>>>");
    }

    @Override
    public void showToast(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}