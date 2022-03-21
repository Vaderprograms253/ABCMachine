package tests.abc;

import static org.junit.Assert.*;

import abc.ALU;
import abc.Nzp;
import abc.Operator;
import org.junit.Test;

public class ALUTest {

    @Test
    public void testAdd(){
        ALU alu = new ALU();
        ALU alu1 = new ALU();
        ALU alu2 = new ALU();
        ALU alu3 = new ALU();
        ALU alu4 = new ALU();
        ALU alu5 = new ALU();

        //POSITIVE
        alu.operate((short) 1, Operator.ADD,(short)(2));
        alu1.operate((short) 3, Operator.ADD,(short) (4));
        assertEquals(Nzp.POSITIVE, alu.getStatus());
        assertEquals(Nzp.POSITIVE, alu1.getStatus());
        //NEGATIVE
        alu2.operate((short) -1, Operator.ADD, (short) -2);
        alu3.operate((short) -3, Operator.ADD, (short) -4);
        assertEquals(Nzp.NEGATIVE, alu2.getStatus());
        assertEquals(Nzp.NEGATIVE, alu3.getStatus());
        //ZERO
        alu4.operate((short) -2, Operator.ADD, (short) 2);
        alu5.operate((short) -3, Operator.ADD, (short) 3);
        assertEquals(Nzp.ZERO, alu4.getStatus());
        assertEquals(Nzp.ZERO, alu5.getStatus());

    }

    @Test
    public void testSUB(){
        ALU alu = new ALU();
        ALU alu1 = new ALU();
        ALU alu2 = new ALU();
        ALU alu3 = new ALU();
        ALU alu4 = new ALU();
        ALU alu5 = new ALU();

        //POSITIVE
        alu.operate((short) 4, Operator.SUB, (short) 3);
        alu1.operate((short) 3, Operator.SUB, (short) 2);
        assertEquals(Nzp.POSITIVE, alu.getStatus());
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        //NEGATIVE
        alu2.operate((short) -4, Operator.SUB, (short) -3);
        alu3.operate((short) -3, Operator.SUB, (short) -2);
        assertEquals(Nzp.NEGATIVE, alu2.getStatus());
        assertEquals(Nzp.NEGATIVE, alu3.getStatus());

        //ZERO
        alu4.operate((short) 4, Operator.SUB, (short) -4);
        alu5.operate((short) 3, Operator.SUB, (short) -3);
        assertEquals(Nzp.ZERO, alu4.getStatus());
        assertEquals(Nzp.ZERO, alu5.getStatus());

    }

    @Test
    public void testMult(){
        ALU alu = new ALU();
        ALU alu1 = new ALU();
        ALU alu2 = new ALU();
        ALU alu3 = new ALU();
        ALU alu4 = new ALU();
        ALU alu5 = new ALU();

        //POSITIVE
        alu.operate((short) 4, Operator.MULT, (short) 3);
        alu1.operate((short) 3, Operator.MULT, (short) 2);
        assertEquals(Nzp.POSITIVE, alu.getStatus());
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        //NEGATIVE
        alu2.operate((short) -4, Operator.MULT, (short) -3);
        alu3.operate((short) -3, Operator.MULT, (short) -2);
        assertEquals(Nzp.POSITIVE, alu2.getStatus());
        assertEquals(Nzp.POSITIVE, alu3.getStatus());

        //ZERO
        alu4.operate((short) 4, Operator.MULT, (short) 0);
        alu5.operate((short) 3, Operator.MULT, (short) 0);
        assertEquals(Nzp.ZERO, alu4.getStatus());
        assertEquals(Nzp.ZERO, alu5.getStatus());
    }

    @Test
    public void testDiv(){
        ALU alu = new ALU();
        ALU alu1 = new ALU();
        ALU alu2 = new ALU();
        ALU alu3 = new ALU();
        ALU alu4 = new ALU();
        ALU alu5 = new ALU();

        //POSITIVE
        alu.operate((short) 4, Operator.DIV, (short) 3);
        alu1.operate((short) 3, Operator.DIV, (short) 2);
        assertEquals(Nzp.POSITIVE, alu.getStatus());
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        //NEGATIVE
        alu2.operate((short) -4, Operator.DIV, (short) -3);
        alu3.operate((short) -3, Operator.DIV, (short) -2);
        assertEquals(Nzp.POSITIVE, alu2.getStatus());
        assertEquals(Nzp.POSITIVE, alu3.getStatus());

        //ZERO
        try {
            alu4.operate((short) 4, Operator.DIV, (short) 0);
            assertEquals(Nzp.ZERO, alu4.getStatus());

        } catch (ArithmeticException e) {
            e.getMessage();
        }
        alu5.operate((short) 0, Operator.DIV, (short) 3);
        assertEquals(Nzp.ZERO, alu5.getStatus());
    }

}