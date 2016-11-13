package fr.mmaillot.swenta;

import android.app.Application;

import fr.mmaillot.swenta.executor.JobExecutor;
import fr.mmaillot.swenta.executor.UIExecutor;
import timber.log.Timber;

/**
 * Main application use as Singleton for UI
 */
public class SwentaApplication extends Application {

    private final JobExecutor mJobExecutor = new JobExecutor();
    private final UIExecutor mUIExecutor = new UIExecutor();

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * @return the job executor for async task
     */
    public JobExecutor getJobExecutor() {
        return mJobExecutor;
    }

    /**
     * @return the UI executor for post processing (should be performed on UI)
     */
    public UIExecutor getUIExecutor() {
        return mUIExecutor;
    }
}
