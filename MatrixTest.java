import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testDeterminant() {
		//source used for test file: Lab 07 Slides
		double[][] matrix = new double[3][3];
		matrix[0][0] = 5;
		matrix[0][1] = 4;
		matrix[0][2] = 3;
		matrix[1][0] = 6;
		matrix[1][1] = 9;
		matrix[1][2] = 1;
		matrix[2][0] = 2;
		matrix[2][1] = 5;
		matrix[2][2] = 3;
		
		
		assertEquals(82.0, Matrix.determinant(matrix, 3), .001);
	}

}
