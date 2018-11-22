package dongdong.xiangri.com.mouthtest.presenter;

import dongdong.xiangri.com.mouthtest.mvp.model.MainModel;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;
import dongdong.xiangri.com.mouthtest.view.MainView;

public class MainPresenter extends BasePersenter<MainModel, MainView> {

    @Override
    protected void onViewDestroy() {

    }

    public void getShopCarNet() {
        model.getShopCarNet(getView());
    }

}
