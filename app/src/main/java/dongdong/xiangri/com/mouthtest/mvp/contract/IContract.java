package dongdong.xiangri.com.mouthtest.mvp.contract;

public interface IContract {

    interface Model {
        void getShopCarNet(View view);

        void stopRequest();
    }

     interface Persenter<M extends IContract.Model,V extends View> {
        /**
         * 注册model
         * @param model
         */
        void registerModel(M model);

        /**
         * 注册view层
         * @param view
         */
        void registerView(V view);

        /**
         * 获取view
         */
        V getView();


        /**
         * 销毁动作
         */
        void destory();
    }

     interface View {
        void showToast(String info);
    }
}
