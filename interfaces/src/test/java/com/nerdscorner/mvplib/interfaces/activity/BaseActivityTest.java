package com.nerdscorner.mvplib.interfaces.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.TestApplication;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class BaseActivityTest {
    @Mock BaseActivityPresenter presenter;

    private BaseActivity baseActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseActivity = Robolectric.buildActivity(BaseActivity.class).create().get();
    }

    @Test
    public void itShouldCallPresenterOnStart() {
        baseActivity.presenter = presenter;
        baseActivity.onStart();
        verify(presenter).onStart();
    }

    @Test
    public void itShouldCallPresenterOnResume() {
        baseActivity.presenter = presenter;
        baseActivity.onResume();
        verify(presenter).onResume();
    }

    @Test
    public void itShouldCallPresenterOnPause() {
        baseActivity.presenter = presenter;
        baseActivity.onPause();
        verify(presenter).onPause();
    }

    @Test
    public void itShouldCallPresenterOnStop() {
        baseActivity.presenter = presenter;
        baseActivity.onStop();
        verify(presenter).onStop();
    }

    @Test
    public void itShouldCallPresenterOnBackPressed() {
        baseActivity.presenter = presenter;
        baseActivity.onBackPressed();
        verify(presenter).onBackPressed();
    }

    @Test
    public void itShouldCallPresenterOnCreateOptionsMenu() {
        baseActivity.presenter = presenter;
        Menu mockMenu = mock(Menu.class);
        baseActivity.onCreateOptionsMenu(mockMenu);
        verify(presenter).onCreateOptionsMenu(mockMenu);
    }

    @Test
    public void itShouldCallPresenterOnOptionsItemSelected() {
        baseActivity.presenter = presenter;
        MenuItem mockMenuItem = mock(MenuItem.class);
        baseActivity.onOptionsItemSelected(mockMenuItem);
        verify(presenter).onOptionsItemSelected(mockMenuItem);
    }

    @Test
    public void itShouldCallPresenterOnActivityResult() {
        baseActivity.presenter = presenter;
        int requestCode = 14;
        int resultCode = 114;
        Intent mockedData = mock(Intent.class);
        baseActivity.onActivityResult(requestCode, resultCode, mockedData);
        verify(presenter).onActivityResult(requestCode, resultCode, mockedData);
    }

    @Test
    public void itShouldCallPresenterOnRequestPermissionsResult() {
        baseActivity.presenter = presenter;
        int requestCode = 14;
        String[] permissions = new String[3];
        int[] grantResults = new int[2];
        baseActivity.onRequestPermissionsResult(requestCode, permissions, grantResults);
        verify(presenter).onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Test
    public void itShouldCallPresenterOnConfigurationChanged() {
        baseActivity.presenter = presenter;
        Configuration mockedConfiguration = mock(Configuration.class);
        baseActivity.onConfigurationChanged(mockedConfiguration);
        verify(presenter).onConfigurationChanged(mockedConfiguration);
    }

    @Test
    public void itShouldCallPresenterOnSaveInstanceState() {
        baseActivity.presenter = presenter;
        Bundle mockedBundle = mock(Bundle.class);
        baseActivity.onSaveInstanceState(mockedBundle);
        verify(presenter).onSaveInstanceState(mockedBundle);
    }

    @Test
    public void itShouldCallPresenterOnRestoreInstanceState() {
        baseActivity.presenter = presenter;
        Bundle mockedBundle = mock(Bundle.class);
        baseActivity.onRestoreInstanceState(mockedBundle);
        verify(presenter).onRestoreInstanceState(mockedBundle);
    }
}