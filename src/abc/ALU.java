package abc;
/**
 * Xavier Denson
 * 3/17/2022
 * This class represents the ALU
 */
public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    /**
     * this method sets the NPZ status to Zero
     */
    public ALU() {
        status = Nzp.ZERO;

    }

    //TODO: This method will perform a math operation on two numbers and set the nzp status
    // appropriately based on whether the math operation resulting in a positive, negative, or zero value

    /**
     * This method gets the operator and determines which operation to use.
     * @return result of the operation performed
     */
    public short operate(short num1, Operator operator, short num2) {
        short answer = 0;
        switch (operator) {
            case MULT -> answer = (short)(num1 * num2);
            case ADD -> answer = (short)(num1 + num2);
            case SUB -> answer = (short)((num1) - (num2));
            case DIV -> answer = (short) (num1 / num2);
        }

        //update ALU status
        if (answer < 0){
            status = Nzp.NEGATIVE;
        } else if (answer == 0){
            status = Nzp.ZERO;
        } else {
            status = Nzp.POSITIVE;
        }

        return answer;//answer to ADD, SUB, MULT, DIV

    }

    /**
     *
     * @return POSITVE, NEGATIVE, or ZERO
     */
    public Nzp getStatus() {
        return status;
    }



}
