import java.util.Scanner;

public class NextSparseNumber {
    Long number;
    public NextSparseNumber(){
        System.out.println("Initiating NextSparseNumber...");
        System.out.println("What's your number ?");
        Scanner scanner = new Scanner(System.in);
        Long input;
        while(true){
            try{
                input = Long.parseLong(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Fail to parse input to Long. Please re-try");
            }
        }
        this.number = input;
        // scanner.close();
    }

    public NextSparseNumber(Long init){
        this.number = init;
    }
    public void main(){
        String binForm = convertToBinary();
        System.out.println(binForm);
        while (true){
            int violatedIndex = checkSparseViolatedIndex();
            if (violatedIndex ==-1){
                break;
            }
            String addValueBinary = fixViolation(checkSparseViolatedIndex());
            Long addValueNumber = Long.parseLong(addValueBinary, 2);
            this.number += addValueNumber;
            System.out.println(String.format("tmp result is: %d ; %s", this.number, convertToBinary()));
        }
        System.out.println(String.format("Final result is: %d ; %s", this.number, convertToBinary()));
    }

    public String convertToBinary(){
        String result = "";
        Long input = this.number;
        while (input/2>=1){
            result = input%2 + result;
            input = input/2;
        }
        if (input!=0) result = input + result;
        return result;
    }
    public int checkSparseViolatedIndex(){
        String binForm = convertToBinary();
        int violatedIndex = -1;
        for (int index=0; index < binForm.length()-1; index++){
            if (binForm.charAt(binForm.length()-1-index)=='1'
                && binForm.charAt(binForm.length()-2-index)=='1'){
                violatedIndex = index;
                break;
            }
        }
        return violatedIndex;
    }

    public String fixViolation(int violationIndex){
        String result = "1";
        for (int index = violationIndex-1; index>=0; index--){
            result+="0";
        }
        return result;
    }

}
