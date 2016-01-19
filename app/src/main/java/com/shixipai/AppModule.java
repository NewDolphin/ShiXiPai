package com.shixipai;


import com.shixipai.interactor.module.InteractorsModule;

import dagger.Module;

/**
 * Created by xiepeng on 16/1/13.
 */
@Module(
        includes = {
                InteractorsModule.class
        },
        injects = {
                ShiXiPaiApp.class
        }
)
public class AppModule {

    private ShiXiPaiApp app;

    public AppModule(ShiXiPaiApp app) {
        this.app = app;
    }

//    @Provides public Application provideApplication() {
//        return app;
//    }
}
