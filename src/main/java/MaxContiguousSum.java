import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxContiguousSum {
    private static int sum;
    private static int newStartIndex;

    public static int maxContiguousSum(int[] dataArray) {
        int result = 0;
        List<Integer> data = Arrays.stream(dataArray).mapToObj(Integer::new)
                .collect(Collectors.toList());
        for (int startIndex = 0; startIndex < data.size(); startIndex++) {
            if (data.get(startIndex) < 0) continue;
            if (startIndex>data.size()/2
                && result >data.subList(startIndex,data.size()).stream().filter(e -> e>0).mapToInt(Integer::valueOf).sum()){
                break;
            }
            System.out.println("\nstartIndex= " + startIndex);
            for (int stopIndex = startIndex; stopIndex <= data.size(); stopIndex++) {
//                System.out.print(".");

                newStartIndex = 0;
//                 if (data.get(startIndex)<0) break;
                sum = calcMaxSum(data.subList(startIndex, stopIndex));
//                        .forEach(e->{
//                    if (Sum(e)<0) ;
//                });
//                sum= data.subList(startIndex, stopIndex).stream().mapToInt(Integer::new).sum();

//                data.subList(startIndex, stopIndex).forEach(MaxContiguousSum::calcSum);

                if (sum > result) {
                    result = sum;
//                    System.out.println("new max: " + sum);
                }
                if (newStartIndex > 0) {
                    startIndex += newStartIndex;
                    break;
                }
            }
        }
        System.out.println("\nResult is: " + result);
        return result;
    }

    public static int calcMaxSum(List<Integer> data) {
        int sum = 0;
        Iterator<Integer> iters = data.iterator();
        while (iters.hasNext()) {
            int i = iters.next();
            if (i > -sum) sum += i;
            else {
                newStartIndex = data.indexOf(i);
                break;
            }
        }
        return sum;
    }

    public static int maxContiguousSum_v2(int[] dataArray){
        int maxSum=0, tmpSum = 0;
        for (int i : dataArray) {
            tmpSum = (tmpSum+i>0)?tmpSum+i:0;
            maxSum = Integer.max(maxSum,tmpSum);
        }
        return maxSum;
    }
}