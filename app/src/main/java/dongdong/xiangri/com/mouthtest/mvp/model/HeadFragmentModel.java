package dongdong.xiangri.com.mouthtest.mvp.model;

import com.google.gson.Gson;

import java.io.IOException;

import dongdong.xiangri.com.mouthtest.BannerEntity;
import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.net.BaseObserver;
import dongdong.xiangri.com.mouthtest.net.Http;
import dongdong.xiangri.com.mouthtest.net.HttpHelper;
import dongdong.xiangri.com.mouthtest.view.HeadFragmentView;
import okhttp3.ResponseBody;

public class HeadFragmentModel implements IContract.Model {

    @Override
    public void getShopCarNet(IContract.View view) {
        HttpHelper.getInstenes().doGet(Http.BANNER_URL, null, new BaseObserver<ResponseBody>() {

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    BannerEntity bannerEntity = new Gson().fromJson(responseBody.string(), BannerEntity.class);
                    ((HeadFragmentView) view).setBanner(bannerEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                ((HeadFragmentView) view).errorRequest(e.getMessage());
            }
        });

    }

    @Override
    public void stopRequest() {

    }
}
