/**
 * Xavier Denson
 * 3/17/2022
 * This class represents the control unit
 */
package abc;

/**
 * This class represents the Control Unit for the
 * ABC Machine
 */
public class ControlUnit {

    private ABCMachine machine;

    /**
     * @param machine The ABC machine this ControlUnit belongs to
     */
    public ControlUnit(ABCMachine machine) {
        this.machine = machine;
    }

    /*
     * This method will continuously fetch, decode, execute, and store instructions/data that are
     * loaded into the ABCMachine's memory map. The program "halts" when it reaches an instruction
     * that is zero. (Note: This method has been completed for you)
     */
    public void startProcessing() {

        while (!halt()) {
            fetch();
            decodeExecuteStore();

        }

    }

    /*
     * This method accesses memory and loads the instruction into the Instruction Register
     * this method also increment the program counter
     */
    public void fetch() {
        //access memory address for next instruction in PC register
        short instruction = machine.getMemory()[machine.getPc()];

        //Place instruction into the instruction register
        machine.setIr(instruction);

        //Increment program counter value in pc register
        byte pcValue = machine.getPc();
        machine.setPc((byte) (pcValue + 1));

    }

    /*
     *
     *  This method decodes the instruction
     */
    public void decodeExecuteStore() {
        //decode the instruction
        //load opcode, src1, and address
        //ir 1010000000001110
        short shiftIr = (short) (machine.getIr() >>> 13);
        int opcode = shiftIr & 0b111;

        //get src 1
        shiftIr = (short) (machine.getIr() >>> 10);
        int src1 = shiftIr & 0b111;

        //get src 2
        shiftIr = (short) (machine.getIr() >>> 7);
        int src2 = shiftIr & 0b111;

        //get destination
        shiftIr = (short) (machine.getIr() >>> 4);
        int dest = shiftIr & 0b111;

        //isolate address
        int address = machine.getIr() & 0b1111;

        executeInstruction(opcode, src1, src2, dest, address);

    }

    /**
     * This method executes the instruction passed in
     */
    public void executeInstruction(int opcode, int src1, int src2, int dest, int address) {
        final int ADD = 0, SUB = 1, MULT = 2, DIV = 3, ST = 4, LOAD = 5, BRANCH = 6, JMP = 7;
        Nzp aluStatus;
        switch (opcode) {
            case ADD -> machine.getRegisters()[dest] = machine.getAlu().operate(machine.getRegisters()[src1], Operator.ADD, machine.getRegisters()[src2]);
            case SUB -> machine.getRegisters()[dest] = machine.getAlu().operate(machine.getRegisters()[src1], Operator.SUB, machine.getRegisters()[src2]);
            case MULT -> machine.getRegisters()[dest] = machine.getAlu().operate(machine.getRegisters()[src1], Operator.MULT, machine.getRegisters()[src2]);
            case ST -> machine.getMemory()[address] = machine.getRegisters()[src1];
            case DIV -> machine.getRegisters()[dest] = machine.getAlu().operate(machine.getRegisters()[src1], Operator.DIV, machine.getRegisters()[src2]);
            case LOAD -> machine.getRegisters()[src1] = machine.getMemory()[address];
            case BRANCH -> {
                aluStatus = machine.getAlu().getStatus();
                //if ALU operation produced a positive result and nzp bits in instruction set to positive 001(1), negative 100(4), zero 010(2)
                if (aluStatus == Nzp.POSITIVE && src1 == 0b001) {
                    machine.setPc((byte) address);

                }
                if (aluStatus == Nzp.NEGATIVE && src1 == 0b100) {
                    machine.setPc((byte) address);
                }
                if (aluStatus == Nzp.ZERO && src1 == 0b010) {
                    machine.setPc((byte) address);
                }
            }
            case JMP -> machine.setPc((byte) address);

        }

    }

    /**
     * @return true if next instruction contains all zeros, otherwise false
     * (Note: This method has been completed for you)
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}
