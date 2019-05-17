package com.sadikul.sample.rxandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sadikul.sample.rxandroid.Model.Task;
import com.sadikul.sample.rxandroid.Observables.BasicObservable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    CompositeDisposable disposable = new CompositeDisposable();
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Example of basic observable and observer
        createBasicObservable();
    }

    private void createBasicObservable() {
        BasicObservable.getTaskList()
                .subscribe(new Observer<Task>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(Task task) {
                        String title = titleText.getText().toString();
                        titleText.setText(title +"\n"+ task.getDescription());
                        Log.d(TAG, "onNext: " + task.getDescription() + " " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onNext: " + e.getMessage() + " " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: " + Thread.currentThread().getName());
                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
