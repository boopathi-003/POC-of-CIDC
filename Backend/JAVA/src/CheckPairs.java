import java.util.Scanner;
class Pair
{

    public boolean checkIfexist(int[] nums, int target) {
        for(Integer nums1: nums)
        {
            for(Integer nums2 : nums)
            {
                if(nums1+nums2 == target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
public class CheckPairs {
    public CheckPairs() {
    }

    public static void main(String[] args) {
        Pair p = new Pair();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        int target;
        for(target = 0; target < n; ++target) {
            nums[target] = sc.nextInt();
        }

        target = sc.nextInt();
        System.out.println(p.checkIfexist(nums, target));
    }
}