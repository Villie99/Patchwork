import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private int numberOfRows= 0;
    private int numberOfColumns= 0;
    //private int numberOfPatches= 0;
    private int r_i= 0;
    private int c_i= 0;
    private int nbrofDiffPatches = 0;
    private String[][] patchArray = null;
    private String[][] patchCreation = null;
    private HashMap<Integer, String[][]> mapForAllPatches = new HashMap<Integer, String[][]>();
    private int patchesToSewIn = 0;
    private int row = 0;
    private int column = 0;
    private int patchType = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.PatchWork();

    }

    public void PatchWork(){
        //tar ut Rows och Columns OCH fyller alla platser med "."
        Scanner scanner = new Scanner(System.in);
        String inputLine1 = scanner.nextLine();
        String[] inputArray = inputLine1.split(" ");
        numberOfRows = Integer.parseInt(inputArray[0]);
        numberOfColumns = Integer.parseInt(inputArray[1]);
        patchArray = new String[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                patchArray[i][j] = ".";
            }
        }


        //tar ut N som ska vara hur många olika patches det finns.
        String inputLine2 = scanner.nextLine();
        nbrofDiffPatches = Integer.parseInt(inputLine2);

        //Loop for hur många patches det ska finnas och skapar dem.
        for (int i = 0; i < nbrofDiffPatches; i++) {
            String r_iAndc_i = scanner.nextLine();
            String[] r_iAndc_iArray = r_iAndc_i.split(" ");
            r_i = Integer.parseInt(r_iAndc_iArray[0]);
            c_i = Integer.parseInt(r_iAndc_iArray[1]);
            //Loop för hur många rader det ska finnas i patchen, skapar och läggr in patches i HashMap.
            patchCreation = new String[r_i][c_i];
            for (int j = 0; j < r_i; j++) {
                String patchCreationLine = scanner.nextLine();
                for (int k = 0; k < c_i; k++) {
                    patchCreation[j][k] = patchCreationLine.substring(k, k + 1);
                }
                mapForAllPatches.put(i + 1, patchCreation);
            }

        }
        //Lästa ut mönster
        patchesToSewIn = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < patchesToSewIn; i++) {
            String[] coordinates = scanner.nextLine().split(" ");
            row = Integer.parseInt(coordinates[0]);
            column = Integer.parseInt(coordinates[1]);
            patchType = Integer.parseInt(coordinates[2]);
            String[][] getThePatch = mapForAllPatches.get(patchType);

            //lägga in dem i patchArray
            mapForAllPatches.get(patchType);
            for (int j = 0; j < getThePatch.length; j++) {
                for (int k = 0; k < getThePatch[0].length; k++) {
                    if (row + j < numberOfRows && column + k < numberOfColumns) {
                        patchArray[row + j][column + k] = getThePatch[j][k];
                    }
                }
            }


        }
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print(patchArray[i][j]);
            }
            System.out.println();
        }

    }
}