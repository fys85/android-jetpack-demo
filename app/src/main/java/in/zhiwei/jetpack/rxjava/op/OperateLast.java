package in.zhiwei.jetpack.rxjava.op;

import android.util.Log;
import in.zhiwei.jetpack.rxjava.op.base.BaseOp;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: zhiwei.
 * Date: 2018/11/7 0007,20:15.
 */
public class OperateLast extends BaseOp {

    private static String TAG = "OperateLast";

    /*
     * last操作符，只会发送最后一条指令，若无，则发送默认指令
     * 这里也使用了SingleObserver，类似的还有consumer等等
     */
    public static void doSome() {
        Observable.just("A1", "A2", "A3", "A4", "A5", "A6")
                .last("A0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d.isDisposed());
                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.i(TAG, "onSuccess: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }
}
