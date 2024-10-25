package com.prachitik.own_cc_wc_tool;

import com.prachitik.own_cc_wc_tool.service.ccwcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

@SpringBootApplication
public class OwnCcWcToolApplication implements CommandLineRunner {

	@Autowired
	ccwcService ccwcservice;

	public static void main(String[] args) {
		SpringApplication.run(OwnCcWcToolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, Welcome to ccwc tool!");
		boolean standardInput = true;
		String filename = null;
		processCommand(standardInput, filename, args);
	}

	/**
	 * Processes wc command based on the options and arguments passed to it
	 * @param standardInput
	 * @param filename
	 * @param args
	 * @throws IOException
	 */
	public void processCommand (boolean standardInput, String filename, String... args) throws IOException{
		//Check if file is passed as an argument
//		System.out.println(filename);
//		System.out.println(standardInput);

		CommandOptions commandOptions = new CommandOptions();
		for(String arg : args){

			if(!arg.startsWith("-") && ccwcCommandOption.fromStringToOption(arg) == null){
				filename = arg;
				standardInput = false;
			}
			else{
				ccwcCommandOption option = ccwcCommandOption.fromStringToOption(arg);
				commandOptions.getOptions().add(option);
			}
		}
		//Check for filename value is present and standardInput flag is not true
		if(!standardInput && filename != null){
			readFromFile(commandOptions, filename);
		}else{
			readStandardInput(commandOptions);
		}

	}

	/**
	 * Reads standard input from user while executing the command as command does not contain file input
	 * @param options
	 * @throws IOException
	 */
	public void readStandardInput(CommandOptions options) throws IOException {

		System.out.println("Enter your input now.. and please end your input with \"EOF\" on new line");

		StringBuilder inputBuilder = new StringBuilder();
		Scanner in = new Scanner(System.in);
		while(true){
			String line = in.nextLine();
			if((line.trim()).equalsIgnoreCase("EOF")){
				break;
			}
			inputBuilder.append(line);
			inputBuilder.append("\n");
		}

		String input = inputBuilder.toString();
		// Check if command options are passed in as arguments
		if(options.getOptions().size() != 0){
			readStandardInputWithOptions(input, options);
		}else{
			readStandardInputDefaultOptions(input);
		}

	}

	/**Read input data from file.
	 * If command options are provided in command then apply them
	 * otherwise apply default options
	 * @param options
	 * @param filename
	 * @throws FileNotFoundException
	 */

	public void readFromFile(CommandOptions options, String filename) throws FileNotFoundException {
		System.out.println("Your file is being processed..");
		if(options == null || options.getOptions().size() == 0){
			readFromFileDefaultOptions(filename);
		}
		else{
			readFromFileWithOptions(options, filename);
		}

	}

	/**
	 * Reads input from a file and applies default wc options
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void readFromFileDefaultOptions(String filename) throws FileNotFoundException {
		Result result = new Result();
		result.setLinesCount(ccwcservice.getCountLines(filename));
		result.setWordsCount(ccwcservice.getCountWords(filename));
		result.setBytesCount(ccwcservice.getCountBytes(filename));
		displayOutput(result, filename);
	}

	/**
	 * Reads input from a file and applies passed in wc command options
	 * @param options
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public void readFromFileWithOptions(CommandOptions options, String filename) throws FileNotFoundException {
		Result result = new Result();
		for(ccwcCommandOption option: options.getOptions()){
			switch (option){
				case COUNT_LINES -> result.setLinesCount(ccwcservice.getCountLines(filename));
				case COUNT_WORDS -> result.setWordsCount(ccwcservice.getCountWords(filename));
				case COUNT_BYTES -> result.setBytesCount(ccwcservice.getCountBytes(filename));
				case COUNT_CHARS -> result.setCharsCount(ccwcservice.getCountChars(filename));
				default -> System.out.println("No such command option available. Please fix the command");
			};
		}
		displayOutput(result, filename);
	}

	/**
	 * Reads from standard input from user as filename was not passed in command
	 * @param input
	 * @param options
	 * @throws IOException
	 */
	public void readStandardInputWithOptions(String input, CommandOptions options) throws IOException {
		Result result = new Result();
		for(ccwcCommandOption option: options.getOptions()){
			switch (option){
				case COUNT_LINES : result.setLinesCount(ccwcservice.getCountLinesStdInput(input));
					break;
				case COUNT_WORDS : result.setWordsCount(ccwcservice.getCountWordsStdInput(input));
					break;
				case COUNT_BYTES : result.setBytesCount(ccwcservice.getCountBytesStdInput(input));
					break;
				case COUNT_CHARS : result.setCharsCount(ccwcservice.getCountCharsStdInput(input));
					break;
				default : System.out.println("No such command option available. Please fix the command");
					break;
			};
		}
		displayOutput(result, null);
	}

	/**
	 * Reads from standard input from user as filename was not passed in command.
	 * Also applies default wc command options
	 * @param input
	 * @throws IOException
	 */
	public void readStandardInputDefaultOptions(String input) throws IOException {
		Result result = new Result();
		result.setLinesCount(ccwcservice.getCountLinesStdInput(input));
		result.setWordsCount(ccwcservice.getCountWordsStdInput(input));
		result.setBytesCount(ccwcservice.getCountBytesStdInput(input));
		displayOutput(result, null);

	}

	/**
	 * Displays the output of wc command
	 * @param result
	 * @param filename
	 */
	public void displayOutput(Result result, String filename){
		StringBuilder output = new StringBuilder();
		int countOptions = 0;
		if(result.getLinesCount() != -1){
			countOptions++;
			output.append(" "+ result.getLinesCount());
		}
		if(result.getWordsCount() != -1){
			countOptions++;
			output.append(" "+ result.getWordsCount());
		}
		if(result.getBytesCount() != -1){
			countOptions++;
			output.append(" " + result.getBytesCount());
		}
		if(result.getCharsCount() != -1){
			if(countOptions < 3){
				output.append(" " + result.getCharsCount());
			}
		}

		if(filename != null){
			output.append(" " + filename);
		}
		System.out.println("Your output:");
		System.out.println(output.toString());
	}
}
