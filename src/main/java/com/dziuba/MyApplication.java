package com.dziuba;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.dziuba.hello.StatelessPage;

public class MyApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
	return StatelessPage.class; // return default page
    }

}