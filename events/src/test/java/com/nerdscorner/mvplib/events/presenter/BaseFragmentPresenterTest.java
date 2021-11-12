package com.nerdscorner.mvplib.events.presenter;

import org.junit.Before;
import org.junit.Ignore;
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
        MockitoAnnotations.openMocks(this);
        baseFragmentPresenter = new BaseFragmentPresenter<>(view, model);
    }

    @Test
    @Ignore
    public void onStart() {
        baseFragmentPresenter.onStart();
    }

    @Test
    @Ignore
    public void onResume() {
        baseFragmentPresenter.onResume();
    }

    @Test
    @Ignore
    public void onPause() {
        baseFragmentPresenter.onPause();
    }

    @Test
    @Ignore
    public void onStop() {
        baseFragmentPresenter.onStop();
    }

    @Test
    @Ignore
    public void onDestroyView() {
        baseFragmentPresenter.onDestroyView();
        verify(view).unbind();
    }
}