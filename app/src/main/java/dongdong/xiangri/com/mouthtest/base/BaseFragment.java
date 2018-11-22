package dongdong.xiangri.com.mouthtest.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import dongdong.xiangri.com.mouthtest.mvp.BaseMvp;
import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;

public abstract class BaseFragment<M extends IContract.Model, V extends IContract.View, P extends BasePersenter> extends Fragment implements BaseMvp<M, V, P> {
    protected P persenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        persenter = createPresenter();
        if (persenter != null) {
            persenter.registerModel(createModel());
            persenter.registerView(createView());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.destory();
        }
    }
}
