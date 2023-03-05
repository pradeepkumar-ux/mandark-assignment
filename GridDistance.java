import java.util.*;

public class GridDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // get start point as array containing x and y coordinates
        System.out.print("Enter start point as [x, y]: ");
        int[] startPoint = Arrays.stream(input.nextLine().replaceAll("\\[|\\]|\\s", "").split(","))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
        
        // get input string
        System.out.print("Enter string: ");
        String inputString = input.nextLine();
        
        // calculate end point based on input string
        int[] endPoint = startPoint;
        for (int i = 0; i < inputString.length(); i++) {
            endPoint = getNextPoint(endPoint, inputString.charAt(i));
        }
        
        // calculate distance between start and end points
        double distance = Math.sqrt(Math.pow(endPoint[0] - startPoint[0], 2) + Math.pow(endPoint[1] - startPoint[1], 2));
        
        // print result
        System.out.printf("%.1f", distance);
    }
    
    // helper method to calculate next point based on direction
    private static int[] getNextPoint(int[] point, char direction) {
        switch (direction) {
            case 'N':
                return new int[] {point[0], point[1] + 1};
            case 'S':
                return new int[] {point[0], point[1] - 1};
            case 'E':
                return new int[] {point[0] + 1, point[1]};
            case 'W':
                return new int[] {point[0] - 1, point[1]};
            default:
                return point;
        }
    }
}
