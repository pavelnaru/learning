import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static  void main(String[] args){
        String checkContinue="y";

        int loopIndex=1;
        int selection =0;
        while (checkContinue.toLowerCase().charAt(0)==('y')) {

            System.out.println(String.format("new loop:%d",loopIndex++));
            System.out.println("select 1 for run NextSparseNumber");
            System.out.println("select 2 for run FluctuatingSeries");
            System.out.println("select 3 for run SquareDigit");
            System.out.print("Your selection: ");
            selection = getIntFromInput();
            switch (selection){
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
                    System.out.println(ParityOutlier.find(new int[]{2,6,8,-11,3}));
                    System.out.println(ParityOutlier.find(new int[]{1056521,7,17,1901,206847684,21104421,7,1,35521,1,7781}));

                    break;
                default:
                    StringBuilder builder = new StringBuilder();
                    for (int i =0; i < 1500; i++) builder.append("1,2,0,4,0,2,");
                    FluctuatingSeries fs1 = new FluctuatingSeries(builder.toString());
                    fs1.main();
                    fs1 = new FluctuatingSeries("100");
                    fs1.main();
                    fs1 = new FluctuatingSeries(",");
                    fs1.main();
                    break;
            }


            System.out.println("press ENTER to continue");
            String c = Main.scanner.nextLine();
            checkContinue = c.isEmpty()?"y": c;
        }



    }
    public static int getIntFromInput(){
        int result=0;
        while(true){
            try{
                result = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Fail to parse input to Long. Please re-try");
            }
        }
        return result;
    }


}
