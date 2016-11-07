public class Solution {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        ///给出一组先修课程 和课程总数 判断是否能将课程修完
        //拓扑排序  课程代表有向图的节点 如果存在环 则代表不可能修完
        //判断(n2,n1) 是否包含在Hap<n1,n2> 
        //BFS
        ArrayList[] lists=new ArrayList[numCourses];
        for(int i=0;i<lists.length;i++)
            lists[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
            lists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int [] degree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
        }
        int count=0;
        Queue q=new LinkedList();
        for(int i=0;i<degree.length;i++){
            if(degree[i] == 1){
                q.add(i);
                count++;
            }
            }
        while(q.size()!=0){
            int p=(int)q.poll();
            for(int i=0;i<lists.get(p).size();i++){
                int f=lists.get(p).get(i);
                degree[f]--;
                if(degree[f]==0){
                    q.add(f);
                    count++;
                }
            }
            
            
            
        }
        if(count==numCourses){
            return true;
}
        else 
            return false;
    }
}
