package me.anil.imageloader.context;

import android.app.Application;
import android.content.Context;

import me.anil.imageloader.daggermodules.ObjectGraph;



public class AppContext extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.Builder.build(this);

    }

    public static ObjectGraph graph(Context context) {
        return AppContext.of((AppContext) context.getApplicationContext()).objectGraph;

    }

    private static AppContext of(AppContext context) {
        return context;
    }
}
