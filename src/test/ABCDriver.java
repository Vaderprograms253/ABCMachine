/**
 * Xavier Denson
 * 3/17/2022
 * This class represents the ABC Driver
 */
package test;

import abc.*;

/**
 * This class takes in a file containing machine instructions and executes them printing out both
 * the registers and memory contents after all the instructions/computations are completed.
 */
public class ABCDriver
{
	/**
	 * The main method of the class which takes the file and runs all the instructions printing
	 * out the end result of the registry and memory.
	 * @param args The value being passed into main, not being used
	 */
	public static void main(String[] args)
	{
		//construct a new ABCMachine and pass it a new program to run
		ABCMachine mach = new ABCMachine("programs/program1.abc");
		mach.runProgram();

		//print out the ABCMachine's registers and memory after the program is executed
		System.out.println("Register dump");
		//TODO: print register contents
		mach.printRegisters();

		System.out.println("Memory dump");
		//TODO: print memory contents
		mach.printMemory();

	}
}
