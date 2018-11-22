package dongdong.xiangri.com.mouthtest.view;

import dongdong.xiangri.com.mouthtest.BannerEntity;
import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;

public interface HeadFragmentView extends IContract.View {
    void setBanner(BannerEntity data);
}