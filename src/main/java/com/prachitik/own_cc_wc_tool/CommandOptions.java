package com.prachitik.own_cc_wc_tool;

import java.util.ArrayList;

public class CommandOptions {
    private ArrayList<ccwcCommandOption> options;

    public CommandOptions(){
        this.options = new ArrayList<ccwcCommandOption>();
    }

    public CommandOptions(ArrayList<ccwcCommandOption> options){
        this.options = options;
    }

    public ArrayList<ccwcCommandOption> getOptions() {
        return options;
    }
}
