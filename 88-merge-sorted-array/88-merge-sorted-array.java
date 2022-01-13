class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;n--;
        int index = nums1.length - 1;
        
        while(index >= 0){
            if(m < 0){
                nums1[index] = nums2[n];
                n--;
            }else if( n < 0){
                nums1[index] = nums1[m];
                m--;
            }else 
            {
                if(nums1[m] > nums2[n]){
                    nums1[index] = nums1[m];
                    m--;
                }else{
                    nums1[index] = nums2[n];
                    n--;
                }
            }
            index--;
        }
    }
}



//Algorithm

/*
Two arrays are sorted so
we compare last elem of both arrays and put greater elem in last index of 1st array
then decrement lastIndex and index of array  which elem is greater 

Do this until one of array is over and then

put one by one all element of remaining array in lastIndex of firstArray
by decrementing lastIndex 
*/