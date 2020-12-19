package com.nerdscorner.mvplib.events.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nerdscorner.mvplib.events.model.BaseEventsModel;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;


import static org.mockito.Mockito.verify;

public class BaseFragmentPresenterTest {

    private BaseFragmentPresenter baseFragmentPresenter;

    @Mock BaseFragmentView view;
    @Mock BaseEventsModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseFragmentPresenter = new BaseFragmentPresenter<>(view, model);
    }

    @Test
    public void onStart() {
        baseFragmentPresenter.onStart();
    }

    @Test
    public void onResume() {
        baseFragmentPresenter.onResume();
    }

    @Test
    public void onPause() {
        baseFragmentPresenter.onPause();
    }

    @Test
    public void onStop() {
        baseFragmentPresenter.onStop();
    }

    @Test
    public void onDestroyView() {
        baseFragmentPresenter.onDestroyView();
        verify(view).unbind();
    }
}