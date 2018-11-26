package com.nerdscorner.mvplib.commons.mvp.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

public interface Presenter {

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroyView();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration newConfig);

    void onSaveInstanceState(Bundle outState);

    boolean onOptionsItemSelected(MenuItem item);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

    void onRestoreInstanceState(Bundle savedInstanceState);
}
