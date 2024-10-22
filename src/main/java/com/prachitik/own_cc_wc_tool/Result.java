package com.prachitik.own_cc_wc_tool;

public class Result {
    private int linesCount;
    private int wordsCount;
    private int bytesCount;
    private int charsCount;

    //String file;


    public Result() {
        this.linesCount = -1;
        this.wordsCount = -1;
        this.bytesCount = -1;
        this.charsCount = -1;
    }

//    public Result(int linesCount, int wordsCount, int bytesCount, int charsCount) {
//        this.linesCount = linesCount;
//        this.wordsCount = wordsCount;
//        this.bytesCount = bytesCount;
//        this.charsCount = charsCount;
//    }

    public int getLinesCount() {
        return linesCount;
    }

    public void setLinesCount(int linesCount) {
        this.linesCount = linesCount;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getBytesCount() {
        return bytesCount;
    }

    public void setBytesCount(int bytesCount) {
        this.bytesCount = bytesCount;
    }

    public int getCharsCount() {
        return charsCount;
    }

    public void setCharsCount(int charsCount) {
        this.charsCount = charsCount;
    }
}
