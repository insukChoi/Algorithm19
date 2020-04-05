public class Test {
    public int shipWithinDays(int[] weights, int d) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (checkValid(weights, mid, d)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean checkValid(int[] weights, int mid, int d) {
        int index = 0;
        int count = 0;
        while (index < weights.length) {
            int curShip = 0;
            while (index < weights.length && curShip + weights[index] <= mid) {
                curShip += weights[index++];
            }
            count++;
            if (count > d) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test result = new Test();
        System.out.println(result.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
        //System.out.println(result.capacityToShipPackagesWithinDDays(new int[] {3,2,2,4,1,4}, 3));
        //System.out.println(result.capacityToShipPackagesWithinDDays(new int[] {7,2,5,10,8}, 2));
    }

}
