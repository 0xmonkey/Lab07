import java.io.*;
import java.util.Scanner;

public class Matrix 
{
	static double[][] m_arr;
	
	public static double determinant(double[][] x, int n)
	{
		double det = 0.0;
		int n_length = n;
		
		if (n_length == 1)
		{
			det = x[1][1];
		}
		else if(n == 2)
		{
			det = x[0][0] * x[1][1] - x[0][1] * x[1][0];
		}
		else
		{
			for(int j1 = 0 ; j1 < n; j1++)
			{
				m_arr = new double[n][];
				for(int k = 0 ; k < (n-1) ; k++)
				{
					m_arr[k] = new double[n-1];
				}
				for(int i = 1 ; i < n ; i++)
				{
					int ns = 0;
					for(int j = 0 ; j < n; j++)
					{
					  if(j == j1)
					  {
						  continue;
					  }
					  m_arr[i-1][ns] = x[i][j];
					  ns++;
					}
				}
				 det += Math.pow(-1.0,1.0+j1+1.0)* x[0][j1] * determinant(m_arr,n-1);


			}
		}
		
		
		return det;
	}

	
	public static void main(String[] args)
	{
		
		String fileName = "input.txt";
		//String line = null;
		try{
			boolean cond = true;
			
			//creating the file reader
			Scanner fileReader = new Scanner(new File(fileName));
			BufferedWriter bufferedWriter = null;
			FileWriter fileWriter = null;
			fileWriter = new FileWriter("output.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			
			while(cond)
			{
				//reading in the size
				String n_size = fileReader.next();
				int m_size = Integer.parseInt(n_size);
				if(m_size == 0)
				{
					cond = false;
					System.out.println("Done!");
				}
				else
				{
					//filling the matrix
					double[][] matrix = new double[m_size][];
					for(int i = 0 ; i < m_size ; i++)
					{
						matrix[i] =  new double[m_size];
					}
					for(int i = 0; i < m_size ; i++)
					{
						for(int j = 0 ; j < m_size ; j++)
						{
							matrix[i][j] = Integer.parseInt(fileReader.next());
						}
					}
					
					System.out.println("M = ");
					bufferedWriter.write("M = ");
					for(int i = 0; i < m_size ; i++)
					{
						for(int j = 0 ; j < m_size ; j++)
						{
							System.out.print((int)matrix[i][j] + "	");
							bufferedWriter.write((int)matrix[i][j] + "	");
						}
						System.out.println();
						bufferedWriter.write("\n");
					}
					
					double det = determinant(matrix, m_size);
					System.out.println("det(M) = " + det);
					bufferedWriter.write("det(M) = " + det + "\n");
					System.out.println();
					bufferedWriter.write("\n");
					
					System.out.println("Minv = ");
					bufferedWriter.write("Minv = \n");
					for(int i = 0; i < m_size ; i++)
					{
						for(int j = 0 ; j < m_size ; j++)
						{
							System.out.print((matrix[j][i] / det) + "	");
							bufferedWriter.write((matrix[j][i] / det) + "	");
						}
						System.out.println();
						bufferedWriter.write("\n");
					}
					System.out.println();
					bufferedWriter.write("\n");
					
				}
				
			}
			fileReader.close();
			bufferedWriter.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to find file '" + fileName + "'");
		}
		catch(IOException ex)
		{
			System.out.println("Error with file '" + fileName + "'");
		}
		
		
	}
}