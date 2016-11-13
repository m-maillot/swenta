package fr.mmaillot.swenta.executor;

import fr.mmaillot.core.executor.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Executor for foreground tasks
 */
public class UIExecutor implements PostExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
