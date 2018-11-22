package dongdong.xiangri.com.mouthtest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dongdong.xiangri.com.mouthtest.fragments.HeadFragment;

public class MainActivity extends AppCompatActivity{

    private FragmentManager manager;
    private HeadFragment headfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        headfragment = new HeadFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl,headfragment).commit();
    }

    @OnClick({R.id.btn_head,R.id.btn_me})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_head:
                manager.beginTransaction().replace(R.id.fl,headfragment).commit();
                break;
            case R.id.btn_me:
                break;
        }
    }
}