package com.asksky.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.asksky.greendaotest.entity.User;
import com.asksky.greendaotest.util.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mResult;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        mResult = (TextView) findViewById(R.id.result_tv);
        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //增
                mUser = new User(System.currentTimeMillis(), "AskSky", "man");
                DBHelper.getInstance().getSession().getUserDao().insert(mUser);
                Log.d(TAG, "添加一条数据！");
            }
        });
        findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删
//                DBHelper.getInstance().getSession().getUserDao().deleteByKey(mUser.getId());
//                DBHelper.getInstance().getSession().getUserDao().delete(mUser);
                DBHelper.getInstance().getSession().getUserDao().deleteAll();
            }
        });
        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //改
                List<User> users = DBHelper.getInstance().getSession().getUserDao().loadAll();
                if (users.isEmpty()) {
                    return;
                } else {
                    mUser = users.get(0);
                }
                mUser = new User(mUser.getId(), "AskSky2", "man");
                DBHelper.getInstance().getSession().update(mUser);
            }
        });
        findViewById(R.id.select_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查
                List<User> users = DBHelper.getInstance().getSession().getUserDao().loadAll();
                String str = "";
                for (User user : users) {
                    Log.d(TAG, user.toString());
                    str += user.toString();
                    str += "\n";
                }
                mResult.setText(str);

            }
        });


    }
}
