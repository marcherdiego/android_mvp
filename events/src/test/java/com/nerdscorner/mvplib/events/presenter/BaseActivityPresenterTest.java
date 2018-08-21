package com.nerdscorner.mvplib.events.presenter;

import com.nerdscorner.mvplib.events.view.BaseActivityView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class BaseActivityPresenterTest {

    private BaseActivityPresenter baseActivityPresenter;

    @Mock BaseActivityView view;
    @Mock BaseModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseActivityPresenter = new BaseActivityPresenter<>(view, model);
    }

    @Test
    public void onStart() {
        baseActivityPresenter.onStart();
        verify(view).onStart();
        verify(model).onStart();
    }

    @Test
    public void onResume() {
        baseActivityPresenter.onResume();
        verify(view).onResume();
        verify(model).onResume();
    }

    @Test
    public void onPause() {
        baseActivityPresenter.onPause();
        verify(view).onPause();
        verify(model).onPause();
    }

    @Test
    public void onStop() {
        baseActivityPresenter.onStop();
        verify(view).onStop();
        verify(model).onStop();
    }

    @Test
    public void onDestroyView() {
        baseActivityPresenter.onDestroyView();
        verify(view).onDestroyView();
        verify(view).unbind();
    }
}