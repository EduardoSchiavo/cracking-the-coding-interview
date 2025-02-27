package arraystring;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
class _01_07_RotateMatrix {
    int[][] rotate(int[][] m) {
        if (m.length == 0 || m.length != m[0].length) return m;
        int n = m.length;
        for (int layer=0; layer < n/2; layer++){
            int first = layer; //topmost layer
            int last = n -1 -layer;
            for (int i =0; i < n; i++){
                int offset = i -first;
                int temp = m[first][i];

                m[first][i] = m[last - offset][first];
                m[last - offset][first] = m[last][last -offset];
                m[last][last - offset] = m[i][last];
                m[i][last] = temp;
            }
        }
        System.out.println(Arrays.deepToString(m));
        return m;

    }


}
