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
                default:
                    NextSparseNumber nsn1 = new NextSparseNumber();
                    nsn1.main();
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
