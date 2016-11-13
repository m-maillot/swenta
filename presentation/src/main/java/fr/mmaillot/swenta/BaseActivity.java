package fr.mmaillot.swenta;

import android.support.v7.app.AppCompatActivity;

/**
 * Base activity used to inject {@link SwentaApplication}
 */
public abstract class BaseActivity extends AppCompatActivity {

    public SwentaApplication getApp() {
        return (SwentaApplication) getApplication();
    }
}
