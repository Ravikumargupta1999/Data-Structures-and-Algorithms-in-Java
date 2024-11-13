public class BST_231_N_Appointments_find_all_conflicting_appointments {
    // https://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/
    static class Interval
    {
        int low, high;
    }

    static class ITNode
    {

        // 'i' could also be a normal variable
        Interval i;
        int max;
        ITNode left, right;
    }

    // A utility function to create a new node
    static Interval newNode(int l, int h)
    {
        Interval temp = new Interval();
        temp.low = l;
        temp.high = h;
        return temp;
    }

    // A utility function to create a new node
    static ITNode newNode(Interval i)
    {
        ITNode temp = new ITNode();
        temp.i = i;
        temp.max = i.high;
        temp.left = temp.right = null;
        return temp;
    }

    // A utility function to insert a new
// Interval Search Tree Node. This is
// similar to BST Insert. Here the
// low value of interval is used to
// maintain BST property
    static ITNode insert(ITNode root, Interval i)
    {

        // Base case: Tree is empty,
        // new node becomes root
        if (root == null)
            return newNode(i);

        // Get low value of interval at root
        int l = root.i.low;

        // If root's low value is smaller,
        // then new interval goes to left subtree
        if (i.low < l)
            root.left = insert(root.left, i);

            // Else, new node goes to right subtree.
        else
            root.right = insert(root.right, i);

        // Update the max value of this
        // ancestor if needed
        if (root.max < i.high)
            root.max = i.high;

        return root;
    }

    // A utility function to check if given
// two intervals overlap
    static boolean doOverlap(Interval i1, Interval i2)
    {
        if (i1.low < i2.high && i2.low < i1.high)
            return true;

        return false;
    }

    // The main function that searches a given
// interval i in a given Interval Tree.
    static Interval overlapSearch(ITNode root, Interval i)
    {

        // Base Case, tree is empty
        if (root == null)
            return null;

        // If given interval overlaps with root
        if (doOverlap(root.i, i))
            return root.i;

        // If left child of root is present
        // and max of left child is greater
        // than or equal to given interval,
        // then I may overlap with an interval
        // is left subtree
        if (root.left != null &&
                root.left.max >= i.low)
            return overlapSearch(root.left, i);

        // Else interval can only
        // overlap with right subtree
        return overlapSearch(root.right, i);
    }

    // This function prints all conflicting
// appointments in a given array of appointments.
    static void printConflicting(Interval[] appointment, int n)
    {

        // Create an empty Interval Search
        // Tree, add first appointment
        ITNode root = insert(null, appointment[0]);

        // Process rest of the intervals
        for(int i = 1; i < n; i++)
        {

            // If current appointment conflicts
            // with any of the existing intervals,
            // print it
            Interval res = overlapSearch(root, appointment[i]);

            if (res != null)
                System.out.print("[" + appointment[i].low + "," + appointment[i].high +
                        "] Conflicts with [" +
                        res.low + "," +
                        res.high + "]\n");

            // Insert this appointment
            root = insert(root, appointment[i]);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        Interval[] appointment = new Interval[4];
        appointment[0] = newNode(6, 7);
        appointment[1] = newNode(2, 6);
        appointment[2] = newNode(6, 8);
        appointment[3] = newNode(1, 4);


        int n = appointment.length;
        System.out.print("Following are conflicting intervals\n");

        printConflicting(appointment, n);
    }
}
