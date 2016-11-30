package com.samuelstudios.gainsmaker;

/**
 * Created by Sam on 6/12/2016.
 */

public class FoodItems
{
    private int _id;
    private String _foodName;

    public FoodItems()
    {

    }
    public FoodItems(String foodName)
    {
    this._foodName=foodName;
    }

    public String get_foodName() {
        return _foodName;
    }

    public void set_foodName(String _foodName) {
        this._foodName = _foodName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
