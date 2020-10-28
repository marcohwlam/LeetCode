package TreeGraph;

public class Bsearch {

    // A recursive binary search function. It returns location of x in
// given array arr[l..r] is present, otherwise -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)  return mid;

            // If element is smaller than mid, then it can only be present
            // in left subarray
            if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }


    // A recursive ternary search function. It returns location of x in
// given array arr[l..r] is present, otherwise -1
    int ternarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid1 = l + (r - l)/3;
            int mid2 = mid1 + (r - l)/3;

            // If x is present at the mid1
            if (arr[mid1] == x)  return mid1;

            // If x is present at the mid2
            if (arr[mid2] == x)  return mid2;

            // If x is present in left one-third
            if (arr[mid1] > x) return ternarySearch(arr, l, mid1-1, x);

            // If x is present in right one-third
            if (arr[mid2] < x) return ternarySearch(arr, mid2+1, r, x);

            // If x is present in middle one-third
            return ternarySearch(arr, mid1+1, mid2-1, x);
        }
        // We reach here when element is not present in array
        return -1;
    }
}
