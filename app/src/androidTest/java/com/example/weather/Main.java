package com.example.weather;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.action.AdapterViewProtocol;

import com.example.weathercast.AppRetrofit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class Main {
    @Test
    public void Test()
    {
        ArrayList<String> list = new ArrayList();
        list.add("paris");
        list.add("berlin");
       TownListAdapter toto = new TownListAdapter(list);
       Assert.assertNotNull(toto);

    }


}
