//package sol1;
//
//public class tress {
//
//    public boolean checkForBST(Root root) {
//        return isBST(root) != null;
//    }
//    public boolean  resultFound;
//    public Integer isBST(Root root) {
//
//        if(root == null) {
//            return null;
//        }
//        Integer leftval = isBst(root.left);
//        Integer rightVal = isBst(root.right);
//        if(leftVal != null && root.val > leftVal) {
//            if(rightVal != null && root.val < rightVal)
//                return rightVal;
//            else {
//                return null;
//            }
//        } else{
//            return null;
//        }
//    }
//}
