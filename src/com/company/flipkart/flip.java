package com.company.flipkart;

/**
 * created by suhail.jahangir on 30/09/20
 */

/**
 * So given a binary tree, give me the bottom view of the tree.
 *
 *                 		| 20 |
 * 		|	|      |	 |
 * 		8	|      |	22
 * 	|	       |	|	|	|
 * 	5 	      3 	|	4 	25
 * 	           |	      |
 * 	         10 	     14
 *
 * 5, 10, 4, 14, 25
 * Map<Integer,TreeNode> map = new HashMap<>()
 * Int max =0;
 * Int min =0;;
 *
 * Public  void process(root){
 * List<Integer> ans = new ArrayList<>();
 * recurse(root, 0);
 * for(int i=min; i<max; i++){
 * 	if(map.containsKey(i){
 * 	ans.add(map.get(i));
 * }
 *
 * Public void recurse(root, columm){
 * if(root == null){
 * Return;
 * map.put(column,root)
 * Min  = Math.min(column, min);
 * max  = Math.min(column, max);
 *
 * recurse(root.left, column-1)
 * recurse(root.right, column+1);
 *
 *
 *
 *
 * 1
 *
 *
 *
 *
 *
 *
 *
 *
 * 3
 *
 *
 * 4
 *
 *
 *
 *
 * 4
 *
 *
 * 4   6
 *
 *
 * 7
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * Time complexity: O(n). where n is number of nodes
 * Space complexity: m where m is the maxWidth of tree, worst case O(n), where n is number of elements
 *
 *
 * Given an integer which represents distance, you can take steps of size 1, 2, or 3. Find me the total number of ways to do it.
 * Ex: 4
 * 1+1+1+1
 * 1+2+1
 * 2+1+1
 * 1+1+2
 * 3+1
 * 1+3
 * 2+2
 * Answer: 7
 *
 *
 *       Arr[n+1]
 * Arr[0] = 0;
 * Arr[1] = 1;
 * Arr[2] = 2;
 * Arr[3] = 4;
 * process(int dist, arr[] steps, arr[]) {
 * 	if( arr[dist] != 0 )
 * 		Return arr[dist];
 *
 * 	for(int i : steps){
 * 		if(dist -i >0)
 * 			arr[dist ] += process(dist-i,steps, arr);
 * 		if(dist -i ==0){
 * 			arr[dist]++;
 *        }
 * 	Return arr[dist];
 *
 * }
 *
 * Space complexity  = O(n) , n is total distance
 * Time complexity = O(n) n is total distance
 *
 * DP has
 * 1. Overlapping sub problem; you save and reuse
 * 2.
 *
 *
 * An array of chars … only two charas ‘P’, ‘T’. you are also given k (integer) holding distance
 * Conditions:
 * One polic can catch only one T
 * That too within the given distance k
 *
 * Highest number of thieves caught
 *
 * T, 0,0, 0, 0, 0, 0 k =2
 *
 * 0, 0, 0, 0, 0, 0 k =3
 */
public class flip {
}
