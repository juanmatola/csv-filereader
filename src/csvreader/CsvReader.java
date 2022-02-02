/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author USER-PC
 */
public class CsvReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\USER-PC\\Desktop\\secuencia5.csv";

        try {

            FileReader reader = new FileReader(fileLocation);
            BufferedReader doc = new BufferedReader(reader);

            Integer[] dimention = getDimention(doc);
            doc.close();

            System.err.println("Matriz: " + dimention[0] + "x" + dimention[1]);

            Integer[][] matriz = new Integer[dimention[0]][dimention[1]];

            reader = new FileReader(fileLocation);
            doc = new BufferedReader(reader);
            for (int i = 0; i < dimention[0]; i++) {

                String[] splitedLineData = doc.readLine().split(",");

                for (int j = 0; j < dimention[1]; j++) {
                    matriz[i][j] = Integer.parseInt(splitedLineData[j]);
                }

            }
            
            
            show(matriz);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static Integer[] getDimention(BufferedReader csvMatrix) throws Exception {
        String lineData;
        Integer rows = 0, columns = 0;

        while ((lineData = csvMatrix.readLine()) != null) {

            if (rows < 1) {
                String[] splitedLineData = lineData.split(",");
                columns = splitedLineData.length;
            }

            rows++;
        }

        Integer[] dimention = new Integer[2];
        dimention[0] = rows;
        dimention[1] = columns;

        return dimention;

    }

    public static void show(Integer[][] matriz) {

        for (int x = 0; x < matriz.length; x++) {
            
            for (int y = 0; y < matriz[x].length; y++) {
                
                System.out.print(matriz[x][y]);
                
                if (y != matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            
            System.out.println();
        
        }

    }

}
