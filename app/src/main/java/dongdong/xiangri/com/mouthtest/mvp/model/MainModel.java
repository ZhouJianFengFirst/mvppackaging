package dongdong.xiangri.com.mouthtest.mvp.model;

import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.view.MainView;

public class MainModel implements IContract.Model {

    @Override
    public void getShopCarNet(IContract.View view) {
        ((MainView) view).setShopCarString("哈哈哈哈");
    }

    @Override
    public void stopRequest() {

    }
}
