package com.prachitik.own_cc_wc_tool;

public enum ccwcCommandOption {
    COUNT_BYTES("-c", "Outputs the number of bytes in a file"),
    COUNT_LINES("-l", "Outputs the number of lines in a file"),
    COUNT_WORDS("-w", "Outputs the number of words in a file"),
    COUNT_CHARS("-m", "Outputs the number of characters in a file");

    private final String cmdOpt;
    private final String description;



    ccwcCommandOption(String cmdOpt, String description) {
        this.cmdOpt = cmdOpt;
        this.description = description;

    }

    public String getCmdOpt() {
        return cmdOpt;
    }

    public String getDescription() {
        return description;
    }

    private static ccwcCommandOption getccwcCommandOption(String name){
        for(ccwcCommandOption ccwcCmdOption : ccwcCommandOption.values()){
            if(ccwcCmdOption.cmdOpt.equalsIgnoreCase(name)){
                return ccwcCmdOption;
            }
        }
        return null; // Return null if no match found
    }

    public static ccwcCommandOption fromStringToOption(String name){
        return getccwcCommandOption(name);
    }
}
