package dongdong.xiangri.com.mouthtest.mvp.persenter;

import java.lang.ref.WeakReference;

import dongdong.xiangri.com.mouthtest.mvp.contract.IContract;

public abstract   class BasePersenter<M extends IContract.Model,V extends IContract.View> implements IContract.Persenter<M,V> {

    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<V>(view);
    }

    @Override
    public V getView() {
         return wrf == null ? null : wrf.get();
    }

    @Override
    public void destory() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }
    protected abstract void onViewDestroy();
}
