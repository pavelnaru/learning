import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String checkContinue = "y";

        int loopIndex = 1;
        int selection = 0;
        while (checkContinue.toLowerCase().charAt(0) == ('y')) {

            System.out.println(String.format("new loop:%d", loopIndex++));
            System.out.println("select 1 for run NextSparseNumber");
            System.out.println("select 2 for run FluctuatingSeries");
            System.out.println("select 3 for run SquareDigit");
            System.out.print("Your selection: ");
            selection = getIntFromInput();
            switch (selection) {
                case 1:
                    NextSparseNumber nsn = new NextSparseNumber();
                    nsn.main();
                    break;
                case 2:
                    FluctuatingSeries fs = new FluctuatingSeries();
                    fs.main();
                    break;
                case 3:
                    SquareDigit sd = new SquareDigit();
                    sd.squareDigits(1089);
                    break;
                case 4:
                    System.out.println(ParityOutlier.find(new int[]{2, 6, 8, -11, 3}));
                    System.out.println(ParityOutlier.find(new int[]{1056521, 7, 17, 1901, 206847684, 21104421, 7, 1, 35521, 1, 7781}));

                    break;
                case 5:
//                    MaxContiguousSum mcs = new MaxContiguousSum(new int[]{3, -4, 8, 7, -10, 19, -3}).;
//                    mcs.findMaxContiguousSum();
                    int w = 10;
                    while (w-- > 0) {
                        StringBuffer builder = new StringBuffer();
                        for (long l = 0; l < 50000; l++) {
                            int a = Integer.parseInt(String.valueOf(Math.random() * 1000).split("\\.")[0]);
                            int b = Integer.parseInt(String.valueOf(Math.random() * 1000).split("\\.")[0]);
                            builder.append(a * ((b % 2) == 0 ? 1 : -1)).append(",");
                        }
                        int[] data = Arrays.stream(builder.toString().split(",")).mapToInt(Integer::valueOf).toArray();
                        System.out.println(MaxContiguousSum.maxContiguousSum_v2(data));
                    }

                    break;

                default:
                    System.out.println("running default case\n");
                    StringBuilder builderDef = new StringBuilder();
                    for (int i = 0; i < 1500; i++) builderDef.append("1,2,0,4,0,2,");
                    FluctuatingSeries fs1 = new FluctuatingSeries(builderDef.toString());
                    fs1.main();
                    fs1 = new FluctuatingSeries("100");
                    fs1.main();
                    fs1 = new FluctuatingSeries(",");
                    fs1.main();
                    break;
            }


            System.out.println("press ENTER to continue");
            String c = Main.scanner.nextLine();
            checkContinue = c.isEmpty() ? "y" : c;
        }


    }

    public static int getIntFromInput() {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Fail to parse input to Long. Please re-try");
            }
        }
        return result;
    }


}
