/**
 * Xavier Denson
 * 3/17/2022
 * This class represents the NPZ
 */
package abc;

/**
 * The status of the ALU after it performs an operation.
 * If the last result of the ALU operation generates a negative signed number,
 * the ALU status is set to NEGATIVE
 * If the last result of the ALU operation generates a zero value,
 * the ALU status is set to ZERO
 * If the last result of the ALU operation generates a positive signed number,
 * the ALU status is set to POSITIVE
 */
public enum Nzp {
    NEGATIVE,
    ZERO,
    POSITIVE
}
