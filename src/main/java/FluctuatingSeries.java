import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FluctuatingSeries {
    List<Integer> data = new ArrayList<Integer>();
//    List<Integer> delta = new ArrayList<Integer>();

    public FluctuatingSeries(){
        while (true){
            String[] input = Main.scanner.nextLine().split(",");
            try {
                data.clear();
                data = Arrays.stream(input).map(Integer::valueOf).collect(Collectors.toList());
                if (data.size()==0) throw new NumberFormatException();
            }catch (NumberFormatException e){
                System.out.print("Invalid input. Retry.");
            }
            break;
        }

    }

    public void main(){
        int longest = 0;
        System.out.println(data.toString());
        if (data.size()>1) {
            List<Integer> delta = calcDelta();
            System.out.println(delta.toString());
            List<Boolean> fluctuatingStatus = checkFluctuation(delta);
            System.out.println(fluctuatingStatus.toString());
            for (int start = 0; start < fluctuatingStatus.size(); start++) {
                int length = checkFluctuatingLength(fluctuatingStatus, start);
                longest = length > longest ? length : longest;
            }
        }else longest = 2;
        System.out.println(String.format("Longest fluctuating sequences is: %d", longest));

    }
    public List<Integer> calcDelta(){
        List<Integer> result = new ArrayList<>();
        for (int index=0; index<data.size()-1; index ++) {
            result.add( Integer.valueOf(data.get(index+1) -data.get(index)) );
        }
        return result;
    }
    public List<Boolean> checkFluctuation(List<Integer> data){
        List<Boolean> result = new ArrayList<>();
        for (int index=0; index<data.size()-1; index ++) {
            boolean tmp = data.get(index)*data.get(index+1)>=0?false: true;
            result.add(tmp);
        }
        return result;
    }
    public int checkFluctuatingLength(List<Boolean> fluctuatingStatus, int startingPoint){
        int longest = 0;
        int index=0;
        for (index = 0; index+startingPoint < fluctuatingStatus.size(); index++){
            System.out.println(fluctuatingStatus.get(index+startingPoint));
            if ((fluctuatingStatus.get(index+startingPoint))){
                longest++;
            }else break;
        }
        System.out.println(String.format("Checking with starting point = %d ; result = %d", startingPoint, longest));
        return longest + 2;
    }

}
