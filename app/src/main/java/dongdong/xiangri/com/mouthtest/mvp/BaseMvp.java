package dongdong.xiangri.com.mouthtest.mvp;

import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;

public interface BaseMvp <M extends IContract.Model,V extends IContract.View,P extends BasePersenter> {
    M createModel();

    V createView();

    P createPresenter();
}