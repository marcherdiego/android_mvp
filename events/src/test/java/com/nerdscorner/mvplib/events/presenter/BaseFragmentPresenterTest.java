package com.nerdscorner.mvplib.events.presenter;

import com.nerdscorner.mvplib.events.model.BaseModel;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class BaseFragmentPresenterTest {

    private BaseFragmentPresenter baseFragmentPresenter;

    @Mock BaseFragmentView view;
    @Mock BaseModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseFragmentPresenter = new BaseFragmentPresenter<>(view, model);
    }

    @Test
    public void onStart() {
        baseFragmentPresenter.onStart();
        verify(view).onStart();
        verify(model).onStart();
    }

    @Test
    public void onResume() {
        baseFragmentPresenter.onResume();
        verify(view).onResume();
        verify(model).onResume();
    }

    @Test
    public void onPause() {
        baseFragmentPresenter.onPause();
        verify(view).onPause();
        verify(model).onPause();
    }

    @Test
    public void onStop() {
        baseFragmentPresenter.onStop();
        verify(view).onStop();
        verify(model).onStop();
    }

    @Test
    public void onDestroyView() {
        baseFragmentPresenter.onDestroyView();
        verify(view).onDestroyView();
        verify(view).unbind();
    }
}