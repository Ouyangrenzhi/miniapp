package com.app.diary;

import android.app.Application;

import com.app.diary.data.DiaryDataSource;
import com.app.diary.data.impl.DiaryDataSourceImpl;
import com.app.diary.db.DbHelper;

public class Miniapp extends Application {

    private static Miniapp instance;//单例

    private DbHelper dbHelper;//数据库操作工具
    private DiaryDataSource diaryDataSource;//备忘录数据源

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取实例
     */
    public static Miniapp getInstance() {
        return instance;
    }

    /**
     * 获取数据库操作工具
     */
    public DbHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DbHelper(this);
        }
        return dbHelper;
    }

    /**
     * 获取备忘录数据源
     */
    public DiaryDataSource getDiaryDataSource() {
        if (diaryDataSource == null) {
            diaryDataSource = new DiaryDataSourceImpl(getDbHelper());
        }
        return diaryDataSource;
    }

}
