package com.nerdscorner.mvplib.interfaces.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.presenter.BaseFragmentPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class BaseFragmentTest {
    @Mock BaseFragmentPresenter presenter;

    private MockBaseFragment baseFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockBaseFragment mockBaseFragment = new MockBaseFragment();
        baseFragment = SupportFragmentController.of(mockBaseFragment).create().get();
    }

    @Test
    public void itShouldCallPresenterOnStart() {
        baseFragment.presenter = presenter;
        baseFragment.onStart();
        verify(presenter).onStart();
    }

    @Test
    public void itShouldCallPresenterOnResume() {
        baseFragment.presenter = presenter;
        baseFragment.onResume();
        verify(presenter).onResume();
    }

    @Test
    public void itShouldCallPresenterOnPause() {
        baseFragment.presenter = presenter;
        baseFragment.onPause();
        verify(presenter).onPause();
    }

    @Test
    public void itShouldCallPresenterOnStop() {
        baseFragment.presenter = presenter;
        baseFragment.onStop();
        verify(presenter).onStop();
    }

    @Test
    public void itShouldCallPresenterOnCreateOptionsMenu() {
        baseFragment.presenter = presenter;
        Menu mockMenu = mock(Menu.class);
        MenuInflater mockMenuInflater = mock(MenuInflater.class);
        baseFragment.onCreateOptionsMenu(mockMenu, mockMenuInflater);
        verify(presenter).onCreateOptionsMenu(mockMenu, mockMenuInflater);
    }

    @Test
    public void itShouldCallPresenterOnOptionsItemSelected() {
        baseFragment.presenter = presenter;
        MenuItem mockMenuItem = mock(MenuItem.class);
        baseFragment.onOptionsItemSelected(mockMenuItem);
        verify(presenter).onOptionsItemSelected(mockMenuItem);
    }

    @Test
    public void itShouldCallPresenterOnConfigurationChanged() {
        baseFragment.presenter = presenter;
        Configuration mockedConfiguration = mock(Configuration.class);
        baseFragment.onConfigurationChanged(mockedConfiguration);
        verify(presenter).onConfigurationChanged(mockedConfiguration);
    }

    @Test
    public void itShouldCallPresenterOnSaveInstanceState() {
        baseFragment.presenter = presenter;
        Bundle mockedBundle = mock(Bundle.class);
        baseFragment.onSaveInstanceState(mockedBundle);
        verify(presenter).onSaveInstanceState(mockedBundle);
    }

    @Test
    public void itShouldCallPresenterOnRestoreInstanceState() {
        baseFragment.presenter = presenter;
        Bundle mockedBundle = mock(Bundle.class);
        baseFragment.onViewStateRestored(mockedBundle);
        verify(presenter).onViewStateRestored(mockedBundle);
    }

    public static class MockBaseFragment extends BaseFragment {
    }
}