package com.sadikul.sample.rxandroid.Observables;

import android.util.Log;

import com.sadikul.sample.rxandroid.Model.DataSource;
import com.sadikul.sample.rxandroid.Model.Task;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class BasicObservable {
    /***
     * Create observable from list of TaskDataList
     * Add data on list in shceduler background thread
     * Observe that data on main thread
     * @return Task observable as list
     */
    public static Observable<Task> getTaskList(){
        return Observable.fromIterable(DataSource.getObserList())//formiterable
                        .subscribeOn(Schedulers.io())//working on background thread
                        .filter(new Predicate<Task>() {
                            @Override
                            public boolean test(Task task) throws Exception {
                                Thread.sleep(1*1000);
                                return task.isCompleted();//return data only if task is completed
                            }
                        })
                    .observeOn(AndroidSchedulers.mainThread());//observe on Main thread
    }

}
