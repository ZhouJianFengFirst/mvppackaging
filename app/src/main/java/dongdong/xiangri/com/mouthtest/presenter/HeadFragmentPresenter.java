package dongdong.xiangri.com.mouthtest.presenter;

import dongdong.xiangri.com.mouthtest.mvp.model.HeadFragmentModel;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;
import dongdong.xiangri.com.mouthtest.view.HeadFragmentView;

public  class HeadFragmentPresenter extends BasePersenter<HeadFragmentModel,HeadFragmentView> {
    @Override
    protected void onViewDestroy() {
        if (model != null) {
            model.stopRequest();
        }
    }

    public void getBannerData(){
        model.getShopCarNet(getView());
    }
}
