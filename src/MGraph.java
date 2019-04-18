public class MGraph {
	
	
	 private int[][] edges;//邻接矩阵
	 private int numOfEdges;//边的数目
	 private int numOfVetex;//顶点的数目
	 
	//初始化一个邻接矩阵 
	public MGraph(int n) {
		edges = new int[n][n];
		numOfEdges = 0;
		numOfVetex = n;
	}
	
	//初始化一个邻接矩阵并且以一个n*n的矩阵为其赋值
	public MGraph(int[][] edges,int n){
		numOfVetex=n;
		numOfEdges=0;
		this.edges = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				this.edges[i][j]=edges[i][j];
				if((edges[i][j]!=-1)&&(edges[i][j]!=0)){
					numOfEdges++;
				}
			}
		}
	}
	
	//从某一个顶点开始对该图进行深度优先搜索
	public void DFS(int v) {
		int[] visited = new int[numOfVetex];
		for (int i = 0; i < numOfVetex; i++) {
			visited[i] = 0;
		}
		DFSREC(v, visited);
		System.out.println();
		int flag=1;
		for(int i=0;i<visited.length;i++){
			if(visited[i]==0)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
			System.out.println("已遍历完全图");
		else
			System.out.println("从该点出发无法遍历全图");

	}
	
	//深度优先搜索辅助函数
	private void DFSREC(int v, int visited[]) {
		visited[v] = 1;
		System.out.print(v + "-->");
		for (int i = 0; i < numOfVetex; i++) {
			if (edges[v][i] != -1 && edges[v][i] != 0 && visited[i] != 1) {
				DFSREC(i, visited);
			}
		}
	}
	
	//广度优先搜索
	public void BFS(int v) {
		int[] qu=new int[numOfVetex];
		int[] visited=new int[numOfVetex];
		int head=0;
		int tail=0;
		qu[tail++]=v;
		visited[v]=1;
		while(head!=tail){
			int t=qu[head++];
			System.out.print(t+"-->");
			for(int i=0;i<numOfVetex;i++){
				if(edges[t][i]!=-1&&edges[t][i]!=0&&visited[i]==0)
				{
					qu[tail++]=i;
					visited[i]=1;
				}
				
			}
		}
		
	}
	
	//测试该图是否为连通图
	public boolean isConnect(){
		int[] visited = new int[numOfVetex];
		for (int i = 0; i < numOfVetex; i++) {
			visited[i] = 0;
		}
		DFSREC(0, visited);
		
		for(int i=0;i<visited.length;i++){
			if(visited[i]==0)
				return false;
		}
		return true;
	}
	
	//输出从顶点u至顶点v的所有长度为l的路径
	//path数组用来记录当前已经走过的路径
	//d用来代表当前走过的长度
	private void pathAllREC(int u,int v,int l,int d,int[] visited,int[] path){
		visited[u]=1;
		d++;
		path[d]=u;
		if(u==v&&d==l){
			for(int i=0;i<=d;i++)
				if(i==d){
					System.out.print(path[i]);
				}
				else{
					System.out.print(path[i]+"-->");
				}
		}
		else{
			for(int t=0;t<numOfVetex;t++){
				if(visited[t]!=1&&edges[u][t]!=0&&edges[u][t]!=-1){
					pathAllREC(t, v, l, d, visited, path);
				}
			}
			visited[u]=0;
		}
	}
	
	//输出从顶点u至顶点v的所有长度为l的路径
	//path数组用来记录当前已经走过的路径
	//d用来代表当前走过的长度
	public void pathAll(int u,int v,int l){
		int d=-1;
		int[] visited=new int[numOfVetex];
		int[] path=new int[numOfVetex];
		pathAllREC(u,v,l,d,visited,path);
	}
	
	
	
	
	
	public static void main(String args[]){
		int[][] edges={{0,2,-1,-1},{-1,0,3,1},{-1,-1,0,4},{5,-1,-1,0}};
		MGraph m=new MGraph(edges,4);
		m.pathAll(0, 3, 3);
//		if(m.isConnect()==true)
//			System.out.println("YES");
		
	}
	 
	 

}
