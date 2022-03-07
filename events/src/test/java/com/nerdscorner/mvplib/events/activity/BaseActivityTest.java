package com.nerdscorner.mvplib.events.activity;

import org.greenrobot.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.nerdscorner.mvplib.events.TestApplication;
import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.model.BaseEventsModel;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.events.view.BaseActivityView;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class BaseActivityTest {
    private BaseActivityPresenter presenter;

    private BaseActivity baseActivity;
    private final Bus bus = Bus.Companion.getDefaultBus();

    @Before
    public void setUp() {
        baseActivity = Robolectric.buildActivity(BaseActivity.class).create().get();
        presenter = Mockito.spy(
                new BaseActivityPresenter<>(
                        new MockBaseActivityView(baseActivity),
                        new BaseEventsModel(),
                        bus
                )
        );
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
    public void itShouldNotRegisterPresenterOnBusDueToLackOfSubscriptions() {
        baseActivity.presenter = presenter;
        baseActivity.onResume();
        assertFalse(bus.isRegistered(baseActivity.presenter));
    }

    @Test
    public void itShouldRegisterPresenterOnBus() {
        baseActivity.presenter = new PresenterWithSubscription(baseActivity);
        baseActivity.onResume();
        assertTrue(bus.isRegistered(baseActivity.presenter));
    }

    @Test
    public void itShouldCallPresenterOnPause() {
        baseActivity.presenter = presenter;
        baseActivity.onPause();
        verify(presenter).onPause();
    }

    @Test
    public void itShouldUnregisterPresenterFromBus() {
        baseActivity.presenter = new PresenterWithSubscription(baseActivity);
        baseActivity.onResume();
        baseActivity.onPause();
        assertFalse(bus.isRegistered(baseActivity.presenter));
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

    class PresenterWithSubscription extends BaseActivityPresenter<BaseActivityView, BaseEventsModel> {

        PresenterWithSubscription(@NonNull BaseActivity activity) {
            super(new MockBaseActivityView(activity), new BaseEventsModel(), bus);
        }

        @Subscribe
        public void onEvent(Object event) {
        }
    }

    class MockBaseActivityView extends BaseActivityView {

        MockBaseActivityView(@NonNull BaseActivity activity) {
            super(activity);
        }
    }
}