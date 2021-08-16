import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class KMeans {

    private final int ROW_SIZE = 20000;
    private final int COLUMN_SIZE = 100;

    private double[][] array;
    private int num = 0;

    private double[][] data_set = new double[ROW_SIZE][COLUMN_SIZE];
    private double[][] diff = new double[ROW_SIZE][COLUMN_SIZE];

    private double intial_centroid[][] = new double[300][400];
    private double center_mean[][] = new double[ROW_SIZE][COLUMN_SIZE];
    private double total_mean[] = new double[ROW_SIZE];

    private int cnum,
            it = 1,
            checker = 1,
            row = 4;

    public static void main(String[] args) throws FileNotFoundException {
        KMeans k = new KMeans();

        k.readFile();
        k.first();

        while(k.checker!=0) {
            k.calculateKMean();
            k.kmeans1();
            k.check();

        }

        k.display();
        k.print();
    }

    public static File pickFile() {

        JFileChooser chooser = new JFileChooser();
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    private void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(pickFile());//Dataset path
        scanner.useDelimiter(System.getProperty("line.separator"));

        int line_number  = 0;

        while (scanner.hasNext()) {

            readLine(scanner.next(), line_number);
            line_number++;
            System.out.println();
        }

        scanner.close();
    }

    public void readLine(String line, int line_number)  {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");

        for(int column = 0; column < row; column++) {
            data_set[num][column] = scanner.nextDouble();
        }

        num++;

    }

    public void first() {
        double a = 0;

        System.out.println("Enter number of centroid: ");
        Scanner scanner = new Scanner(System.in);
        cnum = scanner.nextInt();

        int result[] = new int[cnum];
        double re = 0;

        System.out.println("Centroid");
        for(int i = 0; i < cnum; i++) {
            for (int j = 0; j < row; j++) {
                intial_centroid[i][j] = data_set[i][j];
                System.out.print(intial_centroid[i][j]);
            }

            System.out.println();
        }

        int x = 0;

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < row; j++) {
                System.out.print(data_set[i][j]);

            }

            x++;
            System.out.println();

        }

        System.out.println("Data Count: " + x);

        for(int i = 0; i < num; i++) {
            for(int j = 0;j < cnum; j++) {
                re = 0;

                for(int k=0;k<row;k++) {
                    a = (intial_centroid[j][k]-data_set[i][k]);
                    a = a * a;
                    re = re + a;

                }

                diff[i][j] = Math.sqrt(re);

            }
        }

        double aaa,counter;
        int ccc=1;

        for(int i = 0; i < num; i++) {
            int c=1;

            counter=c;
            aaa=diff[i][0];

            for(int j = 0; j < cnum; j++) {
                if(aaa >= diff[i][j] )  {
                    aaa = diff[i][j];
                    counter = j;

                }
            }

            data_set[i][row]=counter;

        }

        System.out.println("First Iteration");

        for(int i = 0; i < num; i++) {
            for(int j = 0; j <= row; j++) {
                System.out.print(data_set[i][j]+ " ");
            }

            System.out.println();
        }

        it++;
    }


    public void calculateKMean() {
        for(int i = 0; i < 20000; i++)  {
            for(int j = 0; j < 100; j++) {
                center_mean[i][j] = 0.0;
            }
        }

        double c = 0;
        int a = 0, p, abbb = 0;

        if(it % 2 == 0)  {
            abbb = row;
        } else if(it % 2 == 1) {
            abbb = row + 1;
        }

        for(int k = 0; k < cnum; k++) {
            double counter = 0;

            for(int i = 0; i < num; i++) {
                for(int j = 0;j <= row; j++) {
                    if(data_set[i][abbb] == a) {
                        System.out.print(data_set[i][j]);
                        center_mean[k][j] += data_set[i][j];

                    }
                }

                System.out.println();

                if(data_set[i][abbb] == a) {
                    counter++;
                }

                System.out.println();
            }

            a++;
            total_mean[k] = counter;

        }

        for(int i = 0; i < cnum ; i++) {
            System.out.println("\n");

            for(int j = 0; j < row; j++) {
                if(total_mean[i] == 0)  {
                    center_mean[i][j] = 0.0;
                } else {
                    center_mean[i][j] = center_mean[i][j] / total_mean[i];
                }
            }
        }

        for(int k = 0; k < cnum; k++) {
            for(int j = 0; j < row; j++)  {
                System.out.print(center_mean[k][j]);
            }

            System.out.println();

        }

        for(int j = 0; j < cnum; j++) {
            System.out.println(total_mean[j]);

        }

    }

    public void kmeans1() {
        double a = 0, re = 0;
        int result[] = new int[cnum];

        System.out.println("New Centroid");

        for(int i = 0; i < cnum; i++) {
            for(int j = 0; j < row; j++) {
                intial_centroid[i][j] = center_mean[i][j];
                System.out.print(intial_centroid[i][j]);
            }

            System.out.println();
        }

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < cnum; j++) {
                re = 0;

                for(int k = 0; k < row; k++) {
                    a = (intial_centroid[j][k]-data_set[i][k]);
                    a = a * a;
                    re = re + a;

                }

                diff[i][j] = Math.sqrt(re);
            }
        }

        double aaa, counter;

        for(int i = 0; i < num; i++) {
            int c = 1;
            counter = c;
            aaa = diff[i][0];

            for(int j = 0;j < cnum; j++) {
                if(aaa >= diff[i][j]) {
                    aaa = diff[i][j];
                    counter = j;

                }
            }


            if(it % 2 == 0) {
                data_set[i][row + 1] = counter;

            } else if(it % 2 == 1) {
                data_set[i][row] = counter;

            }
        }

        System.out.println(it + " Iteration");

        for(int i = 0; i < num; i++) {
            for(int j = 0; j <= row + 1; j++) {
                System.out.print(data_set[i][j] + " ");
            }

            System.out.println();
        }

        it++;
    }
    public void check() {

        checker = 0;
        for(int i = 0; i < num; i++) {
            if(Double.compare(data_set[i][row],data_set[i][row+1]) != 0){
                checker = 1;
                break;
            }

            System.out.println();
        }

    }

    public void display() {
        System.out.println(it + " Iteration");

        for(int i = 0; i < num; i++) {
            for(int j = 0; j <= row + 1; j++) {
                System.out.print(data_set[i][j]+" ");
            }

            System.out.println();
        }
    }


    public void print() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----OUTPUT----");

        int c = 0;
        int a = 0;

        for(int i = 0; i < cnum; i++) {
            System.out.println("---------CLUSTER-"+i+"-----");

            a = 0;

            for(int j = 0; j < num; j++) {
                if(data_set[j][row] == i) {

                    a++;

                    for(int k = 0; k < row; k++) {
                        System.out.print(data_set[j][k]+"  ");
                    }

                    c++;
                    System.out.println();
                }

            }

            System.out.println("CLUSTER INSTANCES=" + a);

        }

        System.out.println("TOTAL INSTANCE" + c);
    }

}