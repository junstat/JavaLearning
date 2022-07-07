package Q0299.Q0233NumberofDigitOne.solution1;

/*
    设n = xyzdabc，求千位是1的个数，也就是d所在的位置
    此时，有3种情况
    case 1: d == 0，则千位上1的个数为 xyz * 1000
    case 2: d == 1, 则千位上1的个数为 xyz * 1000 + abc + 1
    case 3: d > 1，则千位上1的个数为 xyz * 1000 + 1000

    分析:
    哪些数能贡献千位1？
    1) 当 d==0 时，n = xyz0abc，千位的1只能来自于小于n数
       小于n，对于xyz，，可以取 0, 1, 2, ... (xyz - 1) 共 xyz种可能
       固定xyz，abc可取 0, 1, 2, ..., 999，共 1000种可能
       分步计数，用乘 =>  共 xyz * 1000种
    2) d==1
      在1) 中xyz只能取到(xyz-1)，当d=1时，小于n的数，可取xyz，千位刚好为1，此时abc可以取 0 ~ abc，共abc + 1种
    3) d > 1
      abc可以取 0 ~ 999，共1000种

 */
public class Solution {

    public int countDigitOne(int n) {
        int result = 0;
        for (long k = 1; k <= n; k *= 10) {
            // xyzdabc
            long abc = (n % k);
            long xyzd = n / k;
            long d = xyzd % 10;
            long xyz = (xyzd + 8) / 10;     // +8是处理 d > 1的情况，此时左边求出来的xyz会多1
            result += xyz * k;
            if (d == 1) {
                result += abc + 1;
            }
        }
        return result;
    }
}
