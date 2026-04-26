import java.util.*;

class Solution {
    private static void saveTime(String carNum, String in, String out) {
        String[] t1 = in.split(":");
        String[] t2 = out.split(":");
        int num1 = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
        int num2 = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);
        int time = num2 - num1;
        result.put(carNum, result.getOrDefault(carNum, 0) + time);
    }

    private static void calculate(int[] fees, String carNum, int t) {
        if (t > fees[0]) {
            sorted.put(carNum, fees[1] + (int)Math.ceil((t - fees[0]) / (double)fees[2]) * fees[3]);
        } else {
            sorted.put(carNum, fees[1]);
        }
    }

    private static List<Integer> answer = new ArrayList<>();
    private static Map<String, Integer> result = new HashMap<>();
    private static Map<String, Integer> sorted = new TreeMap<>();

    public List<Integer> solution(int[] fees, String[] records) {
        Map<String, String> parking = new HashMap<>();
        for (String s : records) {
            String[] info = s.split(" ");
            if (info[2].equals("IN"))
                parking.put(info[1], info[0]);
            if (info[2].equals("OUT") && parking.containsKey(info[1])) {
                saveTime(info[1], parking.get(info[1]), info[0]);
                parking.remove(info[1]);
            }
        }
        for (Map.Entry<String, String> car : parking.entrySet()) {
            saveTime(car.getKey(), car.getValue(), "23:59");
        }
        
        for (Map.Entry<String, Integer> times : result.entrySet()) {
            calculate(fees, times.getKey(), times.getValue());
        }
        
        for (Map.Entry<String, Integer> sTime : sorted.entrySet()) {
            answer.add(sTime.getValue());
        }
        return answer;
    }
}