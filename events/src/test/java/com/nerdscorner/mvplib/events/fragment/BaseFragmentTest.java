package com.nerdscorner.mvplib.events.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentController;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class BaseFragmentTest {
    @Mock BaseFragmentPresenter presenter;

    private MockBaseFragment baseFragment;
    private EventBus bus = EventBus.getDefault();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockBaseFragment mockBaseFragment = new MockBaseFragment();
        baseFragment = SupportFragmentController.of(mockBaseFragment).create().get();
    }

    @Test
    public void itShouldCallPresenterOnStart() {
        baseFragment.setPresenter(presenter);
        baseFragment.onStart();
        verify(presenter).onStart();
    }

    @Test
    public void itShouldCallPresenterOnResume() {
        baseFragment.setPresenter(presenter);
        baseFragment.onResume();
        verify(presenter).onResume();
    }

    @Test
    public void itShouldNotRegisterPresenterOnBusDueToLackOfSubscriptions() {
        baseFragment.setPresenter(presenter);
        baseFragment.onResume();
        assertFalse(bus.isRegistered(baseFragment.getPresenter()));
    }

    @Test
    public void itShouldRegisterPresenterOnBus() {
        baseFragment.setPresenter(new PresenterWithSubscription(baseFragment));
        baseFragment.onResume();
        assertTrue(bus.isRegistered(baseFragment.getPresenter()));
    }

    @Test
    public void itShouldCallPresenterOnPause() {
        baseFragment.setPresenter(presenter);
        baseFragment.onPause();
        verify(presenter).onPause();
    }

    @Test
    public void itShouldUnregisterPresenterFromBus() {
        baseFragment.setPresenter(new PresenterWithSubscription(baseFragment));
        baseFragment.onResume();
        baseFragment.onPause();
        assertFalse(bus.isRegistered(baseFragment.getPresenter()));
    }

    @Test
    public void itShouldCallPresenterOnStop() {
        baseFragment.setPresenter(presenter);
        baseFragment.onStop();
        verify(presenter).onStop();
    }

    @Test
    public void itShouldCallPresenterOnCreateOptionsMenu() {
        baseFragment.setPresenter(presenter);
        Menu mockMenu = mock(Menu.class);
        MenuInflater mockMenuInflater = mock(MenuInflater.class);
        baseFragment.onCreateOptionsMenu(mockMenu, mockMenuInflater);
        verify(presenter).onCreateOptionsMenu(mockMenu, mockMenuInflater);
    }

    @Test
    public void itShouldCallPresenterOnOptionsItemSelected() {
        baseFragment.setPresenter(presenter);
        MenuItem mockMenuItem = mock(MenuItem.class);
        baseFragment.onOptionsItemSelected(mockMenuItem);
        verify(presenter).onOptionsItemSelected(mockMenuItem);
    }

    @Test
    public void itShouldCallPresenterOnConfigurationChanged() {
        baseFragment.setPresenter(presenter);
        Configuration mockedConfiguration = mock(Configuration.class);
        baseFragment.onConfigurationChanged(mockedConfiguration);
        verify(presenter).onConfigurationChanged(mockedConfiguration);
    }

    @Test
    public void itShouldCallPresenterOnSaveInstanceState() {
        baseFragment.setPresenter(presenter);
        Bundle mockedBundle = mock(Bundle.class);
        baseFragment.onSaveInstanceState(mockedBundle);
        verify(presenter).onSaveInstanceState(mockedBundle);
    }

    class PresenterWithSubscription extends BaseFragmentPresenter<BaseFragmentView, BaseModel> {
        PresenterWithSubscription(@NonNull BaseFragment fragment) {
            super(new MockBaseFragmentView(fragment), new BaseModel());
        }

        @Subscribe
        public void onEvent(Object event) {
        }
    }

    class MockBaseFragmentView extends BaseFragmentView {
        MockBaseFragmentView(@NonNull BaseFragment fragment) {
            super(fragment);
        }
    }

    public static class MockBaseFragment extends BaseFragment {
    }
}