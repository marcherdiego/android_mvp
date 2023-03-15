package com.github.mvp.events.fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.testing.FragmentScenario;
import com.github.marcherdiego.mvp.events.fragment.BaseFragment;
import com.github.marcherdiego.mvp.events.model.BaseEventsModel;
import com.github.marcherdiego.mvp.events.presenter.BaseFragmentPresenter;
import com.github.marcherdiego.mvp.events.view.BaseFragmentView;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class BaseFragmentTest {
    private static BaseFragmentPresenter presenter;

    private FragmentScenario<MockBaseFragment> fragmentFragmentScenario;
    private final EventBus bus = EventBus.getDefault();
    private MockBaseFragment baseFragment;

    @Before
    public void setUp() {
        MockBaseFragment mockBaseFragment = new MockBaseFragment();

        presenter = Mockito.spy(
                new BaseFragmentPresenter<>(
                        new MockBaseFragmentView(mockBaseFragment),
                        new BaseEventsModel()
                )
        );
        fragmentFragmentScenario = FragmentScenario.launch(MockBaseFragment.class);
        fragmentFragmentScenario.onFragment(fragment -> baseFragment = fragment);
    }

    private void setPresenter(final BaseFragmentPresenter presenter) {
        fragmentFragmentScenario.onFragment(fragment -> {
            fragment.presenter = presenter;
        });
    }

    @Test
    public void itShouldCallPresenterOnStart() {
        setPresenter(presenter);
        verify(presenter).onStart();
    }

    @Test
    public void itShouldCallPresenterOnResume() {
        setPresenter(presenter);
        verify(presenter).onResume();
    }

    @Test
    public void itShouldNotRegisterPresenterOnBusDueToLackOfSubscriptions() {
        setPresenter(presenter);
        baseFragment.onResume();
        assertFalse(bus.isRegistered(baseFragment.presenter));
    }

    @Test
    public void itShouldRegisterPresenterOnBus() {
        setPresenter(new PresenterWithSubscription(baseFragment));
        baseFragment.onResume();
        assertTrue(bus.isRegistered(baseFragment.presenter));
    }

    @Test
    public void itShouldCallPresenterOnPause() {
        setPresenter(presenter);
        baseFragment.onPause();
        verify(presenter).onPause();
    }

    @Test
    public void itShouldUnregisterPresenterFromBus() {
        setPresenter(new PresenterWithSubscription(baseFragment));
        baseFragment.onResume();
        baseFragment.onPause();
        assertFalse(bus.isRegistered(baseFragment.presenter));
    }

    @Test
    public void itShouldCallPresenterOnStop() {
        setPresenter(presenter);
        baseFragment.onStop();
        verify(presenter).onStop();
    }

    @Test
    public void itShouldCallPresenterOnCreateOptionsMenu() {
        setPresenter(presenter);
        Menu mockMenu = mock(Menu.class);
        MenuInflater mockMenuInflater = mock(MenuInflater.class);
        baseFragment.onCreateOptionsMenu(mockMenu, mockMenuInflater);
        verify(presenter).onCreateOptionsMenu(mockMenu, mockMenuInflater);
    }

    @Test
    public void itShouldCallPresenterOnOptionsItemSelected() {
        setPresenter(presenter);
        MenuItem mockMenuItem = mock(MenuItem.class);
        baseFragment.onOptionsItemSelected(mockMenuItem);
        verify(presenter).onOptionsItemSelected(mockMenuItem);
    }

    @Test
    public void itShouldCallPresenterOnConfigurationChanged() {
        setPresenter(presenter);
        Configuration mockedConfiguration = mock(Configuration.class);
        baseFragment.onConfigurationChanged(mockedConfiguration);
        verify(presenter).onConfigurationChanged(mockedConfiguration);
    }

    @Test
    public void itShouldCallPresenterOnSaveInstanceState() {
        setPresenter(presenter);
        Bundle mockedBundle = mock(Bundle.class);
        baseFragment.onSaveInstanceState(mockedBundle);
        verify(presenter).onSaveInstanceState(mockedBundle);
    }

    static class PresenterWithSubscription extends BaseFragmentPresenter<BaseFragmentView, BaseEventsModel> {
        PresenterWithSubscription(@NonNull BaseFragment fragment) {
            super(new MockBaseFragmentView(fragment), new BaseEventsModel());
        }

        @Subscribe
        public void onEvent(Object event) {
        }
    }

    static class MockBaseFragmentView extends BaseFragmentView {
        MockBaseFragmentView(@NonNull BaseFragment fragment) {
            super(fragment);
        }
    }

    public static class MockBaseFragment extends BaseFragment {
        @org.jetbrains.annotations.Nullable
        @Override
        public View onCreateView(@NotNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container, @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            presenter = BaseFragmentTest.presenter;
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}