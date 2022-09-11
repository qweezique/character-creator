package com.qwee.character.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;


public class P6spySqlPrettyFormatterLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
//        return "#" + now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + "| url " + url + "\n" + prepared + "\n" + sql + ";";
        return "#" + now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + "| url " + url + "\n" + sql + ";";
    }
}
