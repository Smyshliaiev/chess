package com.example;

import com.example.common.ParamReader;

import java.io.IOException;

/**
 * Created by Toxa on 06.04.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        ParamReader paramReader = new ParamReader();
        paramReader.readParams(args);

        MainWorker mainWorker = new MainWorker(paramReader);
        mainWorker.findUniqueConfigurations();

    }

}
