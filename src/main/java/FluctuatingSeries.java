import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FluctuatingSeries {
    List<Integer> data = new ArrayList<>();

    public FluctuatingSeries() {
        while (true) {
            String[] input = Main.scanner.nextLine().split(",");
            try {
                this.data.clear();
                this.data = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
                if (this.data.size() == 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input");
            }
        }
    }

    public FluctuatingSeries(String allInput) {
        String[] input = allInput.split(",");
        try {
            this.data.clear();
            this.data = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
            if (this.data.size() == 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.print("Invalid input. Retry.");
        }
    }

    public void main() {
        int longest = 0;
        System.out.println(data.toString());
        if (data.size() > 1) {
            List<Integer> delta = calcDelta();
            List<Boolean> fluctuatingStatus = checkFluctuation(delta);
            for (int start = 0; start < fluctuatingStatus.size(); start++) {
                int length = checkFluctuatingLength(fluctuatingStatus, start);
                longest = length > longest ? length : longest;
            }
        } else if (data.size() == 1) longest = 1;
        else longest = 0;
        System.out.println(String.format("Longest fluctuating sequences is: %d", longest));

    }

    public List<Integer> calcDelta() {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < data.size() - 1; index++) {
            result.add(data.get(index + 1) - data.get(index));
        }
        return result;
    }

    public List<Boolean> checkFluctuation(List<Integer> data) {
        List<Boolean> result = new ArrayList<>();
        for (int index = 0; index < data.size() - 1; index++) {
            boolean tmp = data.get(index) * data.get(index + 1) < 0;
            result.add(tmp);
        }
        return result;
    }

    public int checkFluctuatingLength(List<Boolean> fluctuatingStatus, int startingPoint) {
        int longest = 0;
        int index = 0;
        for (index = 0; index + startingPoint < fluctuatingStatus.size(); index++) {
            if ((fluctuatingStatus.get(index + startingPoint))) {
                longest++;
            } else break;
        }
//        System.out.println(String.format("Checking with starting point = %d ; result = %d", startingPoint, longest));
        return longest + 2;
    }

}
