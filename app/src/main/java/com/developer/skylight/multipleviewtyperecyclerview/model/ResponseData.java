package com.developer.skylight.multipleviewtyperecyclerview.model;

import java.util.ArrayList;

/**
 * Created by akash.wangalwar on 24/07/18.
 */

public class ResponseData {

    public ArrayList<Records> getData() {
        return data;
    }

    public void setData(ArrayList<Records> data) {
        this.data = data;
    }

    private ArrayList<Records> data;
}
