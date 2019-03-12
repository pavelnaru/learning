import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/find-the-parity-outlier/java
public class ParityOutlier {
    static List<Integer> data;

    protected static void setData(String input){
        data = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }
    protected static void setData(){
        data = Arrays.stream(Main.scanner.nextLine().split(","))
                            .map(Integer::valueOf).collect(Collectors.toList());
    }

    public static int find(int[] inputs){
        data = Arrays.stream(inputs).mapToObj(Integer::valueOf).collect(Collectors.toList());
        Integer selectedGroup = checkFullList(demoCheckOdd(data.subList(0,3)));
        return selectedGroup;
    }
    protected static Integer checkFullList(boolean isOdd){
        return data.stream().parallel()
                .map(e -> (isOdd!=checkOdd(e))?e:null)
                .filter(Objects::nonNull).findFirst().get();
    }
    protected static boolean demoCheckOdd(List<Integer>demoData){
        AtomicInteger counter= new AtomicInteger();
        demoData.forEach(e->{if (checkOdd(e)) counter.getAndIncrement();} );
        return (counter.get()>=2);
    }
    protected static boolean checkOdd(int input){
        return input%2!=0;
    }

}
