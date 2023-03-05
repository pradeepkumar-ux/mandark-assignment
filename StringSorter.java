import java.util.*;

public class StringSorter {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList(args);
        List<String> l1 = sortAscByFirstChar(inputList);
        List<String> l2 = sortDescByRemainingNum(l1);
        System.out.println("L1: " + l1);
        System.out.println("L2: " + l2);
    }
    
    public static List<String> sortAscByFirstChar(List<String> inputList) {
        Comparator<String> byFirstChar = (s1, s2) -> s1.charAt(0) - s2.charAt(0);
        inputList.sort(byFirstChar);
        return inputList;
    }
    
    public static List<String> sortDescByRemainingNum(List<String> inputList) {
        Comparator<String> byRemainingNum = (s1, s2) -> {
            String num1 = s1.substring(1);
            String num2 = s2.substring(1);
            return Integer.parseInt(num2) - Integer.parseInt(num1);
        };
        
        Map<Character, List<String>> map = new HashMap<>();
        for (String s : inputList) {
            char firstChar = s.charAt(0);
            map.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(s);
        }
        
        List<String> result = new ArrayList<>();
        for (List<String> subList : map.values()) {
            subList.sort(byRemainingNum);
            result.addAll(subList);
        }
        
        return result;
    }
}
