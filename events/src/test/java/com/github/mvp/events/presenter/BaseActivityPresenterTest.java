package com.github.mvp.events.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.marcherdiego.mvp.events.model.BaseEventsModel;
import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter;
import com.github.marcherdiego.mvp.events.view.BaseActivityView;


import static org.mockito.Mockito.verify;

public class BaseActivityPresenterTest {

    private BaseActivityPresenter baseActivityPresenter;

    @Mock BaseActivityView view;
    @Mock BaseEventsModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        baseActivityPresenter = new BaseActivityPresenter<>(view, model);
    }

    @Test
    public void onStart() {
        baseActivityPresenter.onStart();
    }

    @Test
    public void onResume() {
        baseActivityPresenter.onResume();
    }

    @Test
    public void onPause() {
        baseActivityPresenter.onPause();
    }

    @Test
    public void onStop() {
        baseActivityPresenter.onStop();
    }

    @Test
    public void onDestroyView() {
        baseActivityPresenter.onDestroyView();
        verify(view).unbind();
    }
}