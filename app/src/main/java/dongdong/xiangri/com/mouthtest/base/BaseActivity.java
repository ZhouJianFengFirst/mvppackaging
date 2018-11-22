package dongdong.xiangri.com.mouthtest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dongdong.xiangri.com.mouthtest.mvp.BaseMvp;
import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;

public abstract class BaseActivity<M extends IContract.Model, V extends IContract.View, P extends BasePersenter> extends AppCompatActivity implements BaseMvp<M, V, P> {

    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.registerView(createView());
            presenter.registerModel(createModel());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destory();
        }
    }
}
