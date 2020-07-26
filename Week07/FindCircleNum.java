/**
 * @author ShiChang Wang
 * @description 朋友圈
 * @date 2020/7/26
 */
public class FindCircleNum {
    /**
     * DFS
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 ){
            return 0;
        }
        //获取人数
        int peopleNum = M.length;
        int[] visited = new int[peopleNum];
        int count = 0;
        for (int i = 0; i < peopleNum; i++) {
            if (visited[i] == 0) {
                //此人未被访问过
                dfs(M, visited, i, peopleNum);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int[] visited, int i, int peopleNum) {
        for (int j = 0; j < peopleNum; j++){
            if (m[i][j] == 1 && visited[j] == 0) {
                //此人与j位置的人是朋友，且j没有被访问过
                visited[j] = 1;
                //再找下一个
                dfs(m, visited, j, peopleNum);
            }
        }
    }
}
