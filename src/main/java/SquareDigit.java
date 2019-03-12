import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        int input = n;
        while (input/10>=1){
            digits.add(input%10);
            input = input/10;
        }
        if (n>0) digits.add(input);
        List<Integer> results = digits.stream().map(SquareDigit::square).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
//        results.in
//        results.forEach(builder::append);
        results.forEach(e -> builder.insert(0,e));
        System.out.println(String.format("Result of Square digit: %s", builder.toString()));
        return Integer.parseInt(builder.toString());
    }

    public static Integer square(Integer i){
        return Integer.valueOf(i*i);
    }
}
