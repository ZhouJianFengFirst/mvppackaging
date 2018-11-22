package dongdong.xiangri.com.mouthtest.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import dongdong.xiangri.com.mouthtest.BannerEntity;
import dongdong.xiangri.com.mouthtest.R;
import dongdong.xiangri.com.mouthtest.base.BaseFragment;
import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;
import dongdong.xiangri.com.mouthtest.mvp.model.HeadFragmentModel;
import dongdong.xiangri.com.mouthtest.mvp.persenter.BasePersenter;
import dongdong.xiangri.com.mouthtest.presenter.HeadFragmentPresenter;
import dongdong.xiangri.com.mouthtest.view.HeadFragmentView;

public   class HeadFragment<M extends HeadFragmentModel , V extends HeadFragmentView, P extends HeadFragmentPresenter>  extends BaseFragment implements HeadFragmentView {

    private View view;
    private List<String> iamges = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    @BindView(R.id.banner)
     BGABanner banner;
    private HeadFragmentPresenter headFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_head, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        headFragmentPresenter.getBannerData();

    }

    @Override
    public IContract.Model createModel() {
        return new HeadFragmentModel();
    }

    @Override
    public IContract.View createView() {
        return this;
    }

    @Override
    public BasePersenter createPresenter() {
       headFragmentPresenter =  new HeadFragmentPresenter();
        return headFragmentPresenter;
    }

    @Override
    public void setBanner(BannerEntity data) {
        for (int i = 0 ; i <data.getData().size(); i ++){
            iamges.add(data.getData().get(i).getIcon().replace("https","http"));
            names.add(data.getData().get(i).getTitle());
        }
        banner.setAdapter(new BGABanner.Adapter<ImageView,String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                Log.d("Tager",model);
                Picasso.with(getActivity()).load(model).fit().into(itemView);
            }
        });
        banner.setData(iamges,names);
    }

    @Override
    public void showToast(String info) {
        Toast.makeText(getActivity(),info,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorRequest(String msg) {
        Log.d("Tagger",msg+">>>>>");
    }
}
